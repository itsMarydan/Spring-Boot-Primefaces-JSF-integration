package com.mashsoft.springbootprimefaces;

import java.util.Arrays;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootprimefacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootprimefacesApplication.class, args);
	}
 @Bean
  ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
      //spring boot only works if this is set
      servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
      servletContext.setInitParameter("primefaces.THEME", "nova-light");
      //registration
      ServletRegistrationBean srb = new ServletRegistrationBean();
      srb.setServlet(new FacesServlet());
      srb.setUrlMappings(Arrays.asList("*.xhtml"));
      srb.setLoadOnStartup(1);
      return srb;
}
}
