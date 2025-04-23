package br.senac.tads.dsw.exemplo.rest.jpa;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    // OU
    // @NotBlank
    private String apelido;

    @Column(nullable = false)
    private String nome;

    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String email;

    private String telefone;

    private String senha;

    @ManyToMany
    @JoinTable(name = "pessoa_interesse",
        joinColumns = @JoinColumn(name = "pessoa_id"),
        inverseJoinColumns = @JoinColumn(name = "interesse_id"))
    private Set<Interesse> interesses;

    @OneToOne(mappedBy = "pessoa", optional = true)
    private FotoPessoa foto;

    public DadosPessoais() {
    }

    public DadosPessoais(String apelido, String nome, LocalDate dataNascimento, String email, String telefone,
            String senha) {
        this.apelido = apelido;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(Set<Interesse> interesses) {
        this.interesses = interesses;
    }

    public FotoPessoa getFoto() {
        return foto;
    }

    public void setFoto(FotoPessoa foto) {
        this.foto = foto;
    }


}
