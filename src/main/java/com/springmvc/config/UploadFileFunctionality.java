package com.springmvc.config;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration
@PropertySource("classpath:static/folderLocation.properties")
public class UploadFileFunctionality{

	
	@Autowired
	private Environment env;

	@Bean
	public CommonsMultipartResolver multipartResolver() 
		{
			CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
			multipartResolver.setMaxUploadSize(208488200);
			return multipartResolver;
		}
	
	@Bean
	public  Properties pathLocation() 
	{
		Properties prop=new Properties();
		prop.put("RELATIVELOCATION",env.getRequiredProperty("RELATIVELOCATION"));
		prop.put("PATIENTREPORT",env.getRequiredProperty("PATIENTREPORT"));
		return prop;	
	}
}
