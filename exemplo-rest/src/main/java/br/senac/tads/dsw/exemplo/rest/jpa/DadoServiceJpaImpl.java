package br.senac.tads.dsw.exemplo.rest.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.senac.tads.dsw.exemplo.rest.DadosDto;
import br.senac.tads.dsw.exemplo.rest.DadosService;

@Service
@Primary
public class DadoServiceJpaImpl implements DadosService {

    @Autowired
    private DadosJpaRepository repository;

    private DadosDto entityToDto(DadosPessoais entity) {
        DadosDto dto = new DadosDto();
        dto.setId(entity.getId());
        dto.setApelido(entity.getApelido());
        dto.setNome(entity.getNome());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        List<String> interesses = new ArrayList<>();
        for (Interesse interesse : entity.getInteresses()) {
            interesses.add(interesse.getNome());
        }
        dto.setInteresses(interesses);
        return dto;
    }

    @Override
    public List<DadosDto> findAll() {
        List<DadosPessoais> dadosBd = repository.findAll();
        List<DadosDto> resultados = new ArrayList<>();
        for (DadosPessoais entity : dadosBd) {
            DadosDto dto = entityToDto(entity);
            resultados.add(dto);
        }
        return resultados;
    }

    @Override
    public Optional<DadosDto> findById(Integer id) {
        Optional<DadosPessoais> optDados = repository.findById(id);
        if (optDados.isEmpty()) {
            return Optional.empty();
        }
        DadosPessoais entity = optDados.get();
        return Optional.of(entityToDto(entity));
    }

    @Override
    public DadosDto save(DadosDto dto) {
        DadosPessoais entity = new DadosPessoais();
        entity.setId(dto.getId());
        entity.setApelido(dto.getApelido());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setSenha(dto.getSenha());

        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
