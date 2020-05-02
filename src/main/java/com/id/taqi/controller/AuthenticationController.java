package com.id.taqi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.taqi.common.JwtProvider;
import com.id.taqi.dto.JwtResponse;
import com.id.taqi.dto.LoginForm;
import com.id.taqi.dto.ResponseMessage;
import com.id.taqi.dto.SignUpForm;
import com.id.taqi.entity.Role;
import com.id.taqi.entity.RoleName;
import com.id.taqi.entity.User;
import com.id.taqi.services.RoleService;
import com.id.taqi.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm req) {
		if (userService.existsByUserName(req.getUserName())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userService.existsByEmail(req.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(req.getName(), req.getUserName(), req.getEmail(),
				encoder.encode(req.getPassword()));

		Set<String> strRoles = req.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleService.findByName(RoleName.ROLE_ADMIN);
				roles.add(adminRole);
				break;
			case "pm":
				Role pmRole = roleService.findByName(RoleName.ROLE_PM);
				roles.add(pmRole);
				break;
			default:
				Role userRole = roleService.findByName(RoleName.ROLE_USER);
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userService.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){		
		try {
			List<User> user = userService.getAll();
			return ResponseEntity.ok(user);
		}catch (Exception e){			
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserBYId(@PathVariable("id") Long id){		
		try {
			User user = userService.getById(id);
			return ResponseEntity.ok(user);
		}catch (Exception e){			
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}