package br.senac.tads.dsw.exemplo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dados")
public class DadosRestController {

  @Autowired
  private DadosService service;

  @GetMapping
  public List<DadosDto> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public DadosDto findById(@PathVariable("id") Integer id) {
    Optional<DadosDto> optDados = service.findById(id);
    if (!optDados.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return optDados.get();
    // OU
    // return service.findById(id).orElseThrow(
    // () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/exemplo-parametros")
  public String exemploParametros(
      @RequestParam("apelido") String apelido,
      @RequestParam(name = "nome", required = false) String nome,
      @RequestParam(name = "email", defaultValue = "contato@email.com") String email,
      @RequestHeader("user-agent") String userAgent
      ) {
    if (nome == null) {
      nome = "[Não informado]";
    }
    return "Apelido: " + apelido + 
        ", Nome: " + nome + 
        ", E-mail: " + email + 
        ", User-agent: " + userAgent;
  }

  // @PostMapping
  // public DadosDto incluirNovo(@RequestBody @Valid DadosDto input) {
  //   return service.save(input);
  // }

  @PostMapping
  public ResponseEntity<Void> incluirNovo(@RequestBody @Valid DadosDto input) {
    input.setId(null);
    DadosDto resposta = service.save(input);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(resposta.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> alterar(
      @PathVariable("id") Integer id,
      @RequestBody @Valid DadosDto input) {
    input.setId(id);
    service.save(input);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
