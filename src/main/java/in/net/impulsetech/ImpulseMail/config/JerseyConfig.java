package in.net.impulsetech.ImpulseMail.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import in.net.impulsetech.ImpulseMail.api.PropertiesEndpoint;

@Component
@ApplicationPath("restapi")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(PropertiesEndpoint.class);
	}

}