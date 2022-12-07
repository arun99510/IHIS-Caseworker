package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.enitity.CWAccountEntity;

public interface CWAccountRepo extends JpaRepository<CWAccountEntity, Integer> {

public CWAccountEntity findByEmailAndPwd(String email,String pwd);
	
	public CWAccountEntity findByEmail(String email);
}
