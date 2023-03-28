package com.example.msg.msg.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User getUser(String id) 
    {
        return userRepository.findByIdentifier(id);
    }

    public User salvarUser(User user) 
    {
        user.setIdentifier(UUID.randomUUID().toString());
        return userRepository.save(user);
    }


}
