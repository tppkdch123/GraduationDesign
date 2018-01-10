package org.graduationdesign.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@Data
@MapperScan(basePackages = "org.graduationdesign.mappers",sqlSessionFactoryRef = "sqlSessionFactory")
public class SpringBootConfig {
  private static final String url="jdbc:mysql://127.0.0.1:3306/mydatabase?user=root";
  private static final String username="root";
  private static final String password="a19960901";
  private static final String driverClassName="com.mysql.jdbc.Driver";

  @Bean("dataSource")
  public DataSource dataSource(){
      DruidDataSource druidDataSource=new DruidDataSource();
      druidDataSource.setUsername(username);
      druidDataSource.setPassword(password);
      druidDataSource.setUrl(url);
      druidDataSource.setDriverClassName(driverClassName);
      return druidDataSource;
  }

  @Bean("sqlSessionFactory")
  public SqlSessionFactory mySqlSessionFactory(){
      final SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
      sqlSessionFactoryBean.setDataSource(dataSource());
      try {
          sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/Mapper/*Mapper.xml"));
      } catch (IOException e) {
          System.out.println("xxxx");
      }
      sqlSessionFactoryBean.setTypeAliasesPackage("org.graduationdesign.entity");
      try {
          return sqlSessionFactoryBean.getObject();
      } catch (Exception e) {
          System.out.println("yyy");
          return null;
      }
  }

  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager(){
      return new DataSourceTransactionManager(dataSource());
  }
}
