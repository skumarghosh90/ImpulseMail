package in.net.impulsetech.ImpulseMail.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Path("properties")
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PropertiesEndpoint {
	
	private Properties appProperties;
	
	@PostConstruct
	public void initialize() throws FileNotFoundException, IOException {
		appProperties = new Properties();
		appProperties.load(PropertiesEndpoint.class.getClassLoader().getResourceAsStream("application.properties"));
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Properties getAllProperties() {
		return appProperties; 
	}
	
	@GET
	@Path("/{propName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProperty(@PathParam("propName") String propName) {
		return appProperties.getProperty(propName);
	}
}
