package com.cafe24.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Role;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository; // JPA 버전

	public void join(User user) {
		user.setRole(Role.USER);
		userRepository.save(user);
	}

	public boolean existEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user != null;
	}

	public User getUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User getUser(Long no) {
		return userRepository.findOne(no);
	}

	public boolean modifyUser(User user) {

		return userRepository.update(user) == 1;
	}


	/*
	 * public void joinUser(User user) { userRepository.insert(user); }
	 * 
	 * public User login(User user) {
	 * 
	 * User resultUser = userRepository.getByEmailAndPassword(user);
	 * 
	 * return resultUser;
	 * 
	 * }
	 */
}
