package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.AloeBusinessService;

@Configuration 
public class SpringConfig {
	@Bean (name="AloeBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	
	public AloeBusinessService getOrdersBusiness() 
	{
		
		return new AloeBusinessService();
	}
}
