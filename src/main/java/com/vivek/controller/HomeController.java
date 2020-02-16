	package com.vivek.controller;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.vivek.exception.UserNotFoundException;
import com.vivek.model.User;
import com.vivek.service.UserService;

@CrossOrigin
@RestController
public class HomeController {
	
	@Autowired
	private UserService usrService;
	
	@Autowired
	private MessageSource messageSource;
	
	//@CrossOrigin
	@GetMapping("/api/welcome")
	public String message(String message) {
		return "hello";
	}
	/*//@CrossOrigin
	@GetMapping("/api/users/{id}")
	public Resource<User> getUser(@PathVariable String id) {
		int identity = Integer.parseInt(id);
		User usr = usrService.getUser(identity);
		if(usr==null)
			throw new UserNotFoundException("id-"+id);
		
		Resource<User> resource =  new Resource<User>(usr);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(linkTo.withRel("all-users"));		
		return resource;		
	}*/
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		return usrService.getUserList();		
	} 
	
	@PostMapping("/api/user")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User usr) {
		usrService.addUser(usr);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		buildAndExpand(usr.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/api/users/{id}")
	public void deleteById(@PathVariable int id) {		
		User usr = usrService.deleteUser(id);
		if(usr==null)
			throw new UserNotFoundException("id-"+id);				
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String  helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null,locale);
	}
	
	@GetMapping(path="/hello-world-internationalized-v1")
	public String  helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale() );
	}
}	
