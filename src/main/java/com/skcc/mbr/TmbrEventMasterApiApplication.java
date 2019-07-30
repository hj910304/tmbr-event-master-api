package com.skcc.mbr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value= {"com.skcc.mbr.**.dao"})
@SpringBootApplication
public class TmbrEventMasterApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TmbrEventApiApplication.class, args);
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