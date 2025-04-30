package br.senac.tads.dsw.exemplo.rest.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.dsw.exemplo.rest.InteresseDto;

@Service
public class InteresseService {

    @Autowired
    private InteresseRepository interesseRepository;

    public List<InteresseDto> findAll() {
        List<Interesse> interesses = interesseRepository.findAll();
        List<InteresseDto> resultado = new ArrayList<>();
        for (Interesse interesse : interesses) {
            resultado.add(new InteresseDto(interesse.getId(), interesse.getNome()));
        }
        return resultado;
    }

}
