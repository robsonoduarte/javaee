/**
 * 
 */


var connection = new WebSocket('ws://localhost:8080/jsr356-api-websocket/server');


connection.onmessage = function(e) {
		$("#test").append(e.data + "<br>");
};	

