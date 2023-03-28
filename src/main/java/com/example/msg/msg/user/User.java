package com.example.msg.msg.user;


import com.example.msg.msg.chave.Chave;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name="tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @NonNull
    private String username;

    @Column
    private String identifier;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Chave> code;

}

