package br.com.mariorusso.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Empresa {

    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String senha;
    private LocalDateTime criadoEm;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String cnpj, String email, String telefone, String senha, LocalDateTime criadoEm) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public Empresa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Empresa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Empresa setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Empresa setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Empresa setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Empresa setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public Empresa setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
        return this;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
