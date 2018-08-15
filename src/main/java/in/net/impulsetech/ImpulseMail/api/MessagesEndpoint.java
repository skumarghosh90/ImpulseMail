package in.net.impulsetech.ImpulseMail.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Path("/messages")
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MessagesEndpoint {
	
	public static List<Message> messageList= new ArrayList<Message>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(){
		return MessagesEndpoint.messageList;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addMessage(Message message){
		if(message==null){
			throw new RuntimeException("Message is null");
		}
		MessagesEndpoint.messageList.add(message);
		return "success";
	}
	
}


class Message{
	public String sender;
	public String reciever;
	public String message;
}