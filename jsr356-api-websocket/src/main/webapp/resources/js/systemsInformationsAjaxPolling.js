
function poll() {
	$.ajax({
		url: '/jsr356-api-websocket/systemsInformations',
		data:$('form').serialize(),
		dataType: 'html',
		complete: function(data){
			
			
			if( data.responseText != ""){
				x = eval(data.responseText);
				$("#sys1").text(x[0].numberAccess);				
				$("#sys2").text(x[1].numberAccess);				
				$("#sys3").text(x[2].numberAccess);				
			}
						
		}
	});
}


setInterval(poll, 1000);

