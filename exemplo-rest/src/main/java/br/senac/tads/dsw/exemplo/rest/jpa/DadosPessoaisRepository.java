package br.senac.tads.dsw.exemplo.rest.jpa;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;


public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Integer> {

    // Premissa: apelido é único
    Optional<DadosPessoais> findByApelido(String apelido);

    List<DadosPessoais> findByNomeIgnoreCaseStartingWith(String inicioNome);

    List<DadosPessoais> findByNomeEndingWith(String finalNome);

    List<DadosPessoais> findByInteresses_NomeIgnoreCase(String nomeInteresse);

    @Modifying
    void deleteByApelido(String apelido);

    // Uso do @Query + JPQL
    @Query("SELECT p FROM DadosPessoais p WHERE p.id = :id")
    Optional<DadosPessoais> buscaJpql(Integer id);

    @NativeQuery("SELECT * FROM dados_pessoais WHERE id = :id")
    Optional<DadosPessoais> buscaSqlNativo(Integer id);



}
