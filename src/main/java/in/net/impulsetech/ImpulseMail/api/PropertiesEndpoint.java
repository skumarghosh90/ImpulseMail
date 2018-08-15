package in.net.impulsetech.ImpulseMail.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
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
	@Produces(MediaType.TEXT_PLAIN)
	public String getProperty(@PathParam("propName") String propName) {
		return appProperties.getProperty(propName);
	}

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/query")
    public String getPropertyQuery(@QueryParam("propNameQuery") String propName) {
        return appProperties.getProperty(propName);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{propName}")
    public String deleteProperty(@PathParam("propName") String propName){
	    if(appProperties.remove(propName) != null){
	        return "Deleted "+propName;
        }
        else{
            throw new RuntimeException(propName+" does not exist");
        }
    }


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addProperty(PropBean[] jsonBody) {
        for(PropBean pb: jsonBody){
            appProperties.put(pb.name,pb.value);
        }
	}


    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{propName}")
    public void updateProperty(@PathParam("propName") String propName, String value1) {
	    if(appProperties.containsKey(propName)){
	        appProperties.put(propName,value1);
        }else{
            throw new RuntimeException(propName+" does not exist");
        }
    }

}

class PropBean {
    public String name;
    public String value;
}