package rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import rest.entity.User;
import rest.error.Error;
import rest.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// method only handles requests that expect JSON output
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody List<User> users(@RequestParam(value = "max", defaultValue = "9223372036854775807") long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return userRepository.findUsers();
	}

	// receive resource representation from the client
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User saveUser(@RequestBody User user) {
		return user;
	}

	// receive resource representation from the client
	@RequestMapping(path="/withResponseHeader", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUserAndReturnResponseHeaders(@RequestBody User user, UriComponentsBuilder ucb) {
		HttpHeaders headers = new HttpHeaders();
		//do not use hardcoded URI
		//URI locationUri = URI.create("http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/users/1");
		//Use UriComponentsBuilder
		URI locationUri = 
				ucb.path("/users/")
				.path("1")
				.build()
				.toUri();
		headers.setLocation(locationUri);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user,headers, HttpStatus.CREATED);
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	// no need for @ResponseBody, ResponseEntity implies the semantics of
	// @ResponseBody
	public ResponseEntity<?> userById(@PathVariable Long id) {
		User user;
		if (id == 1L) {
			user = new User("reaper", 32);
		} else {
			user = null;
		}
		if (user == null) {
			Error error = new Error(4, "User " + id + " not found");
			return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

}
