package com.example.msg.msg.chave;

import com.example.msg.msg.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, Integer> {
    Chave findByIdentifier(String identifier);
    List<Chave> findByUser(User user);
}