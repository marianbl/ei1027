package es.uji.ei1027.clubesportiu;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;




@Configuration
public class ClubesportiuConfiguration {

	
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
  	  return DataSourceBuilder.create().build();
    }


    /*@Bean 
    public TestController testController() {
	  final TestController testController = new TestController();
	  testController.setAthlete(tennisPlayer());
	  return testController;
    }*/
}
