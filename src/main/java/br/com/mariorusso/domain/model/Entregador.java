package br.com.mariorusso.domain.model;

import java.util.Objects;

public class Entregador {

    private Long id;
    private Empresa empresa;
    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private String email;
    private String veiculo;
    private String placa;

    private String senha;

    public Entregador() {
    }

    public Entregador(Long id, String nomeCompleto, String cpf, String telefone, String email, String veiculo, String placa) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.veiculo = veiculo;
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public Entregador setId(Long id) {
        this.id = id;
        return this;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Entregador setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Entregador setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Entregador setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Entregador setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Entregador setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public Entregador setVeiculo(String veiculo) {
        this.veiculo = veiculo;
        return this;
    }

    public String getPlaca() {
        return placa;
    }

    public Entregador setPlaca(String placa) {
        this.placa = placa;
        return this;
    }
    public String getSenha() {
        return senha;
    }

    public Entregador setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "id=" + id +
                ", empresa=" + empresa +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", veiculo='" + veiculo + '\'' +
                ", placa='" + placa + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entregador that = (Entregador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
