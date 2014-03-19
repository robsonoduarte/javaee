package br.com.mystudies.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint("/server")
public class ServerEndPoint {

	@OnMessage
	public String receiveMessage(String msg){
		return msg.toUpperCase();
	}
	
}
