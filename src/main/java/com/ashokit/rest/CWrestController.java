package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.DashBoard;
import com.ashokit.binding.LoginCwBinding;
import com.ashokit.binding.ViewProfile;
import com.ashokit.cwservice.CWservice;

@RestController
public class CWrestController {

	@Autowired
	private CWservice cwservice;
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginCwBinding binding)
	{
		String login = cwservice.login(binding);
		return new ResponseEntity<>(login,HttpStatus.OK);
	}
	@GetMapping("/view/{email}")
	public ResponseEntity<ViewProfile> viewcw( @PathVariable String email) {
		
		ViewProfile viewCw = cwservice.viewCw(email);
return new ResponseEntity<>(viewCw,HttpStatus.OK);
	}
	@GetMapping("/board")
	public ResponseEntity<DashBoard> dash()
	{
		DashBoard board = cwservice.board();
		return new ResponseEntity<>(board,HttpStatus.OK);
	}
	
}
