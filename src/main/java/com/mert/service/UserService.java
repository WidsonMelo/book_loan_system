package com.mert.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mert.model.Role;
import com.mert.model.Task;
import com.mert.model.User;
import com.mert.repository.RoleRepository;
import com.mert.repository.UserRepository;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }
    
    public List<User> findAllFriends() {
    	Role role = new Role();
    	role.setId(2);
    	role.setRole("USER");
    	return  findUserbyRole(role);
    }
    
    public List<User> findByUserId(int userid){
		List<User> users = this.findAll();
		
		List<User> userFinal = new ArrayList<>();
		
		for (User user : users) {
			if(user.getUserid() == userid) {
				userFinal.add(user);
			}
		}
		
		return userFinal;
	}

    public User findUser(int id) {
        return userRepository.findOne(id);
    }

    public void delete(int id) {
        userRepository.delete(id);

    }

    public void save(User user) {
        userRepository.save(user);
    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveFriend(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRole(userRole);
        user.setPassword("000");
        user.setActive(1);
        //user.setTelefone(user.getTelefone());
        userRepository.save(user);
    }
    
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRole(userRole);
        userRepository.save(user);
    }

    public List<User> findUserbyRole(Role role) {
        return userRepository.findByRole(role);
    }
}
