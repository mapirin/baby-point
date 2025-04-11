package com.point.baby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.point.baby.entity"})
//@MapperScan(basePackages = {"com.point.baby.repository"})
public class BabyPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyPointApplication.class, args);
	}
	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        // コンフィグファイルの読み込み
//        sessionFactory.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));
//
//        return sessionFactory.getObject();
//    }

}
