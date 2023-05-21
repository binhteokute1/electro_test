package electro.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electro.store.entity.Account;
import electro.store.repository.AccountRepository;
import electro.store.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository dao;
	
	@Override
	public Account findById(String username) {
		return dao.findById(username).get();
	}

	public List<Account> findAll() {
		return dao.findAll();
	}
	
	public List<Account> getAdministrators() {
		return dao.getAdministrators();
	}
}
