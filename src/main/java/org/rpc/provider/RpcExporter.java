package org.rpc.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {
    public static Executor executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName,int port) throws Exception{
        ServerSocket serverSocket=new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName,port));
        while(true){
            executor.execute(new ExporterTask(serverSocket.accept()));
        }
    }

    private static class ExporterTask implements Runnable{

        Socket client=null;

        public ExporterTask(Socket socket){
            this.client=socket;
        }

        @Override
        public void run() {
            ObjectInputStream inputStream=null;
            ObjectOutputStream outputStream=null;
            try {
                inputStream=new ObjectInputStream(client.getInputStream());
                String className= inputStream.readUTF();
                Class service=Class.forName(className);
                String methodName= inputStream.readUTF();
                Class[] parameterTypes=(Class[]) inputStream.readObject();
                Object[] arguments=(Object[]) inputStream.readObject();
                Method method=service.getMethod(methodName,parameterTypes);
                Object result=method.invoke(service.newInstance(),arguments);

                outputStream=new ObjectOutputStream(client.getOutputStream());
                outputStream.writeObject(result);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }finally {
                if(outputStream!=null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(inputStream!=null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(client!=null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
