package com.dating_app.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dating_app.model.UserAccount;

public class UserAccountDAOImpl implements UserAccountDAO {

//	use map as a in memory address
	Map<Integer, UserAccount> userAccounts = new HashMap<Integer, UserAccount>();
	
	@Override
	public void save(UserAccount userAccount) {
		userAccounts.put(userAccount.getId(), userAccount);

	}

	@Override
	public UserAccount findById(int id) {
		
		return userAccounts.get(id);
	}

	@Override
	public List<UserAccount> findAll() {
		
		return new ArrayList<UserAccount>(userAccounts.values());
	}

	@Override
	public List<UserAccount> findMatches(int age, String city) {
		Collection<UserAccount> account = userAccounts.values();
		ArrayList<UserAccount> matche = new ArrayList<>();
		for(UserAccount userAccount : account) {
			if(userAccount.getAge() == age && userAccount.getCity().equals(city)) {
				matche.add(userAccount);
			}
		}
		return matche;
	}

	@Override
	public void delete(int id) {
		userAccounts.remove(id);		
	}
	
	

}
