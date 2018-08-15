package in.net.impulsetech.ImpulseMail.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/inbox")
	public List<Message> getInboxMessages(@HeaderParam("username") String username){
		List<Message> userMessages= new ArrayList<Message>();
		for(Message message: MessagesEndpoint.messageList) {
			if(message.receiver.equalsIgnoreCase(username)){
				userMessages.add(message);
			}
		}
		return userMessages;
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
	public String receiver;
	public String message;
}