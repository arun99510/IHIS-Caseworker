package com.ashokit.cwservice;

import java.util.List;

import com.ashokit.binding.DashBoard;
import com.ashokit.binding.LoginCwBinding;
import com.ashokit.binding.ViewProfile;

public interface CWservice {

	public String login(LoginCwBinding cwBinding);
	
	ViewProfile viewCw(String email);
	
	public DashBoard board();
}
