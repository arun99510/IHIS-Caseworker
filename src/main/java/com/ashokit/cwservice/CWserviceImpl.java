package com.ashokit.cwservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.binding.DashBoard;
import com.ashokit.binding.LoginCwBinding;
import com.ashokit.binding.ViewProfile;
import com.ashokit.enitity.CWAccountEntity;
import com.ashokit.repo.AdminPlansRepo;
import com.ashokit.repo.CWAccountRepo;

@Service
public class CWserviceImpl implements CWservice {

	@Autowired
	private AdminPlansRepo adminRepo;
	@Autowired
	private CWAccountRepo cwRepo;
	
	@Override
	public String login(LoginCwBinding cwBinding) {

		CWAccountEntity cwentity = cwRepo.findByEmailAndPwd(cwBinding.getEmail(), cwBinding.getPwd());
		if(cwentity==null)
		{
			return "Invalid user";
		}
		return "valid user";
	}

	@Override
	public ViewProfile viewCw(String email) {

		CWAccountEntity entity = cwRepo.findByEmail(email);
		ViewProfile binding=new ViewProfile();
		BeanUtils.copyProperties(entity, binding);
		return binding;
	}

	@Override
	public DashBoard board() {

		DashBoard board=new DashBoard();
		long count = adminRepo.count();
		board.setCitizensCount((int) count);
		long cwcount = cwRepo.count();
		board.setPlansCount((int) cwcount);
		
		return board;
	}

}
