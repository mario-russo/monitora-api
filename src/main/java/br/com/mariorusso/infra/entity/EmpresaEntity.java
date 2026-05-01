package br.com.mariorusso.infra.entity;

import br.com.mariorusso.domain.model.Empresa;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class EmpresaEntity extends PanacheEntity {


    public String nome;
    @Column(unique = true, nullable = false)
    public String cnpj;

    @Column(unique = true, nullable = false)
    public String email;

    public String telefone;
    public String senha;
    public LocalDateTime criadoEm;

    public EmpresaEntity() {
    }

    public static  EmpresaEntity fromDomain(Empresa empresa){
        return  new EmpresaEntity()
                .setNome(empresa.getNome())
                .setCnpj(empresa.getCnpj())
                .setEmail(empresa.getEmail())
                .setTelefone(empresa.getTelefone())
                .setSenha(empresa.getSenha())
                .setCriadoEm(empresa.getCriadoEm());

    }

    public  Empresa toDomain(){
        return  new Empresa().setId(id)
                .setNome(nome)
                .setCnpj(cnpj)
                .setEmail(email)
                .setTelefone(telefone)
                .setSenha(senha)
                .setCriadoEm(criadoEm);
    }



    public String getNome() {
        return nome;
    }

    public EmpresaEntity setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public EmpresaEntity setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmpresaEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public EmpresaEntity setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public EmpresaEntity setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public EmpresaEntity setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
        return this;
    }

    @Override
    public String toString() {
        return "EmpresaEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
