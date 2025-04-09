package br.senac.tads.dsw.exemplo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interesses")
public class InteressesController {

  List<InteresseDto> interesses = List.of(
    new InteresseDto(1, "Java"),
    new InteresseDto(2, "Javascript"),
    new InteresseDto(3, "HTML"),
    new InteresseDto(4, "CSS"),
    new InteresseDto(5, "Angular"),
    new InteresseDto(6, "React"),
    new InteresseDto(7, "SQL"),
    new InteresseDto(8, "Spring Boot")
  );

  @GetMapping
  public List<InteresseDto> findAll() {
    return interesses;
  }

}
