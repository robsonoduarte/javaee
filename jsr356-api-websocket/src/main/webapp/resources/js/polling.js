/*
(function poll(){

	$.ajax({
		url: "/jsr356-api-websocket/polling",
		success: function(data){
			$("#div").append(data.responseText);
		},
		dataType: "html",
		complete: poll,
		timeout: 30000
	});
})();
*/



function poll() {
	$.ajax({
		url: '/jsr356-api-websocket/polling',
		data:$('form').serialize(),
		dataType: 'html',
		complete: function(data){
			$("#div").append(data.responseText);
		}
	});
}


setInterval(poll, 1000);













/*function poll() {
    $.ajax({
        url: "/jsr356-api-websocket/pollling",
        type: "GET",
        success: function(data) {
        	$("#div").append(data);
        },
        complete: setTimeout(function() {poll();}, 5000),
        timeout: 2000
    });
};*/
