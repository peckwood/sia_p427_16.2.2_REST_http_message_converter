function addUser() {
	var user = {
			name : "raiden",
			age : 18
		};
	
	$.ajax({
		type : 'POST',
		url : 'users/withResponseHeader',
		data : JSON.stringify(user),
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			console.log(data);
		}
	});
}