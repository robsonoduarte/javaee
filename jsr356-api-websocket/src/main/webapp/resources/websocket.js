/**
 *
 */



var connection = new WebSocket('ws://10.96.237.180:8080/jsr356-api-websocket/server');


connection.onmessage = function(e) {
		$("#test").append(e.data + "<br>");
};

