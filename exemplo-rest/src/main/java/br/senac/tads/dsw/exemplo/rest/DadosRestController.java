package br.senac.tads.dsw.exemplo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dados")
public class DadosRestController {

    @GetMapping
    public String findAll() {
        return "findAll com @RestController";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Integer id) {
        return "findById-" + id + "  com @RestController";
    }
    
    
    @GetMapping("/json")
    public Dados findJson() {
        return new Dados("Fulano da Silva", "fulano@email.com");
    }

}
