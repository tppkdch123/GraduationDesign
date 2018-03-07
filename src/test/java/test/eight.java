package test;

public interface eight {
    void go();
    default void to(){
        System.out.println("to");
    }
    static void jo(){
        System.out.println("jo");
    }
}
interface nine{
    void kl();
    default void to(int a){
        System.out.println("to");
    }
    static void jo(){

    }
}
interface ten extends nine,eight{

}