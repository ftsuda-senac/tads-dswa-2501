package br.senac.tads.dsw.exemplo.rest.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class DadosJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<DadosPessoais> findAll() {
        String jpql = "SELECT p FROM DadosPessoais p";
        TypedQuery<DadosPessoais> query = entityManager.createQuery(
                jpql, DadosPessoais.class);
        List<DadosPessoais> resultados = query.getResultList();
        return resultados;
    }

    public Optional<DadosPessoais> findById(Integer id) {
        String jpql = "SELECT p FROM DadosPessoais p WHERE p.id = :id";
        TypedQuery<DadosPessoais> query = entityManager.createQuery(jpql, DadosPessoais.class);
        query.setParameter("id", id);
        try {
            DadosPessoais dados = query.getSingleResult();
            return Optional.ofNullable(dados);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
        
    }

    @Transactional
    public DadosPessoais save(DadosPessoais dados) {
        // Se ID for nulo -> inclui um novo
        // Se ID existir -> atualiza
        if (dados.getId() == null) {
            entityManager.persist(dados);
        } else {
            dados = entityManager.merge(dados);
        }
        return dados;
    }

    @Transactional
    public void deleteById(Integer id) {
        DadosPessoais p = entityManager.find(DadosPessoais.class, id);
        entityManager.remove(p);
    }

}
