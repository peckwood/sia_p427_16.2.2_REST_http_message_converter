function addUserRestController() {
	var user = {
			name : "raiden",
			age : 18
		};
	
	$.ajax({
		type : 'POST',
		url : 'usersRestfulController',
		data : JSON.stringify(user),
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			console.log(data);
		}
	});
}