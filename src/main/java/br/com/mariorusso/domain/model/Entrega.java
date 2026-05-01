package br.com.mariorusso.domain.model;


import java.time.LocalDateTime;

public class Entrega {

    private Long id;
    private Empresa empresa;
    private Entregador entregador;

    private String clienteNome;
    private String clienteTelefone;

    private Endereco endereco;

    private Localizacao localizacaoAtual;

    private String numeroCupom;
    private String status;

    private LocalDateTime criadoEm;
    private LocalDateTime aceitoEm;
    private LocalDateTime iniciadoEm;
    private LocalDateTime entregueEm;

    public Entrega() {
    }

    public Long id() {
        return id;
    }

    public Entrega setId(Long id) {
        this.id = id;
        return this;
    }

    public Empresa empresa() {
        return empresa;
    }

    public Entrega setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        return this;
    }

    public Entregador entregador() {
        return entregador;
    }

    public Entrega setEntregador(Entregador entregador) {
        this.entregador = entregador;
        return this;
    }

    public String clienteNome() {
        return clienteNome;
    }

    public Entrega setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
        return this;
    }

    public String clienteTelefone() {
        return clienteTelefone;
    }

    public Entrega setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
        return this;
    }

    public Endereco endereco() {
        return endereco;
    }

    public Entrega setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Localizacao localizacaoAtual() {
        return localizacaoAtual;
    }

    public Entrega setLocalizacaoAtual(Localizacao localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
        return this;
    }

    public String numeroCupom() {
        return numeroCupom;
    }

    public Entrega setNumeroCupom(String numeroCupom) {
        this.numeroCupom = numeroCupom;
        return this;
    }

    public String status() {
        return status;
    }

    public Entrega setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime criadoEm() {
        return criadoEm;
    }

    public Entrega setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
        return this;
    }

    public LocalDateTime aceitoEm() {
        return aceitoEm;
    }

    public Entrega setAceitoEm(LocalDateTime aceitoEm) {
        this.aceitoEm = aceitoEm;
        return this;
    }

    public LocalDateTime iniciadoEm() {
        return iniciadoEm;
    }

    public Entrega setIniciadoEm(LocalDateTime iniciadoEm) {
        this.iniciadoEm = iniciadoEm;
        return this;
    }

    public LocalDateTime entregueEm() {
        return entregueEm;
    }

    public Entrega setEntregueEm(LocalDateTime entregueEm) {
        this.entregueEm = entregueEm;
        return this;
    }
}
