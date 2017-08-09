<html>
<body>
	<ul>
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/users">Produce JSON output with @ResponseBody</a>
		</li>
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/saveUser.html">Receiving resource state in the request body(browser debug)</a>
		</li>
		<br />
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/users">@RestController: Produce JSON output with @ResponseBody</a>
		</li>
		
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/saveUserRestController.html">@RestController: Receiving resource state in the request body(browser debug)</a>
		</li>
		<br />
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/users/1">Serve more than resource: use ResponseEntity to return resource and status code if FOUND</a>
		</li>
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/users/2">Serve more than resource: use ResponseEntity to return error and status code if NOT FOUND</a>
		</li>
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/usersRestfulController/1">Serve more than resource(FOUND): return resource with @ExceptionHandler inside @RestController, no @ReponseBody or ResponseEnity</a>
		</li>
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/usersRestfulController/2">Serve more than resource: return error with @ExceptionHandler inside @RestController, no @ReponseBody or ResponseEnity</a>
		</li>
		<li>
			<a href="http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/saveUserWithResponseHeaders.html">Serve more than resource: return response headers(browser debug)</a>
		</li>
	</ul>
</body>
</html>
