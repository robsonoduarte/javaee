/**
 *
 */


var connection = new WebSocket('ws://localhost:8080/jsr356-api-websocket/systemsInformations');

connection.onmessage = function(e) {
	
		x = eval(e.data);
		
		$("#sys1").text(x[0].numberAccess);				
		$("#sys2").text(x[1].numberAccess);				
		$("#sys3").text(x[2].numberAccess);				

};

