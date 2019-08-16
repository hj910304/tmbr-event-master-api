package com.skcc.mbr;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.skcc.mbr.config.MasterInfoConfiguration;

@Configuration
@ComponentScan
@MapperScan(value= {"com.skcc.mbr.**.dao"})
@SpringBootApplication
@EnableJpaRepositories("com.skcc.mbr.saga.**.domain")
@Import({MasterInfoConfiguration.class})
public class TmbrEventMasterApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TmbrEventMasterApiApplication.class, args);
	}
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**.xml");
        sessionFactory.setMapperLocations(res);
        return sessionFactory.getObject();
    }
}