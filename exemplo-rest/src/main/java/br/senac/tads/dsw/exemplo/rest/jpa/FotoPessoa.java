package br.senac.tads.dsw.exemplo.rest.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class FotoPessoa {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeArquivo;

    @OneToOne
    @MapsId("id")
    //@JoinColumn(name = "pessoa_id")
    private DadosPessoais pessoa;

    public FotoPessoa() {
    }

    public FotoPessoa(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

}
