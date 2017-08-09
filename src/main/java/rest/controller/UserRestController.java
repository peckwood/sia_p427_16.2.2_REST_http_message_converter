package rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import rest.entity.User;
import rest.error.Error;
import rest.exception.UserNotFoundException;
import rest.repository.UserRepository;

@RestController
@RequestMapping("/usersRestfulController")
public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;
	
	//method only handles requests that expect JSON output
	@RequestMapping(method=RequestMethod.GET, produces={"application/json"})
	//@REsponseBody tells that 
	public List<User> users(@RequestParam(value="max", defaultValue="9223372036854775807") long max, 
			@RequestParam(value="count", defaultValue="20") int count){
		return userRepository.findUsers();
	}
	
	//receive resource representation from the client
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User user){
		return user;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	//no need for @ResponseBody, ResponseEntity implies the semantics of @ResponseBody
	public User userById(@PathVariable Long id){
		User user;
		if(id==1L){
			user = new User("reaper", 32);
		}else{
			user = null;
		}
		if(user==null){
			throw new UserNotFoundException(id);
		}else{
			return user;
		}
	}
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error userNotFound(UserNotFoundException e){
		return new Error(4, "User " + e.getUserId()+" not found");
	}
}
