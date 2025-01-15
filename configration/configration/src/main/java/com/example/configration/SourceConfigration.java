package com.example.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SourceConfigration {

  @Bean
  MyBean myBean() {
	  MyBean myBean=new MyBean();
	  myBean.setMyLong(1453);
	  myBean.setMyDouble(25760);
	  myBean.setMyString("teknoloji atlası");
	  return myBean;
  }
  
  @Bean
  MySpec mySpec() {
	  
	  MySpecImpl myspec=new MySpecImpl();
	  
	  return myspec;
  }
     
}
