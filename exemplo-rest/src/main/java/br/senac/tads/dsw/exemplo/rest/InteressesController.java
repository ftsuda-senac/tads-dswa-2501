package br.senac.tads.dsw.exemplo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.tads.dsw.exemplo.rest.jpa.InteresseService;

@RestController
@RequestMapping("/api/interesses")
public class InteressesController {

  @Autowired
  private InteresseService service;

  @GetMapping
  public List<InteresseDto> findAll() {
    return service.findAll();
  }

}
