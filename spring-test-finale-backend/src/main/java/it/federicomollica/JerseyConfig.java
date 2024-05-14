package it.federicomollica;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.ApplicationPath;

@Component
@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig(){
		
		packages("it.federicomollica");
	}
}
