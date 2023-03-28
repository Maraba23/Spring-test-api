package com.example.msg.msg.chave;


import com.example.msg.msg.user.User;
import com.example.msg.msg.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChaveService {

    @Autowired
    private UserService userService;

    @Autowired
    private ChaveRepository msgRepository;

    public Chave getMsg(String id) {
        return msgRepository.findByIdentifier(id);
    }

    public List<Chave> getMsgs(String user) {
        User u = userService.findByIdentifier(user);
        return msgRepository.findByUser(u);
    }

    public List<Chave> getMsgs() {
        return msgRepository.findAll();
    }

    public Chave salvarMsg(Chave msg) {
        User u = userService.findByIdentifier(msg.getUser().getIdentifier());
        msg.setUser(u);
        msg.setIdentifier(UUID.randomUUID().toString());
        return msgRepository.save(msg);
    }

}
