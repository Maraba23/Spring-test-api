package com.example.msg.msg.chave;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chave")
public class ChaveController {

    @Autowired
    private ChaveService msgService;

    @GetMapping
    public List<Chave> getMsgs() {
        return msgService.getMsgs();
    }

    @GetMapping("/{id}")
    public Chave getMsg(@PathVariable String id) {
            return msgService.getMsg(id);
        }


    @GetMapping("/{id}/user")
    public List<Chave> getMsgUser(@PathVariable String id) {
        return msgService.getMsgs(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Chave salvarMsg(@RequestBody @Valid Chave msg) {
        return msgService.salvarMsg(msg);
    }
}
