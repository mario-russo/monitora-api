package br.com.mariorusso.domain.model;


import java.time.LocalDateTime;
import java.util.Objects;

public class Entrega {

    private Long id;
    private Long empresa;
    private Long entregador;

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

    public Long getId() {
        return id;
    }

    public Entrega setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public Entrega setEmpresa(Long empresa) {
        this.empresa = empresa;
        return this;
    }

    public Long getEntregador() {
        return entregador;
    }

    public Entrega setEntregador(Long entregador) {
        this.entregador = entregador;
        return this;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public Entrega setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
        return this;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public Entrega setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Entrega setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Localizacao getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public Entrega setLocalizacaoAtual(Localizacao localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
        return this;
    }

    public String getNumeroCupom() {
        return numeroCupom;
    }

    public Entrega setNumeroCupom(String numeroCupom) {
        this.numeroCupom = numeroCupom;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Entrega setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public Entrega setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
        return this;
    }

    public LocalDateTime getAceitoEm() {
        return aceitoEm;
    }

    public Entrega setAceitoEm(LocalDateTime aceitoEm) {
        this.aceitoEm = aceitoEm;
        return this;
    }

    public LocalDateTime getIniciadoEm() {
        return iniciadoEm;
    }

    public Entrega setIniciadoEm(LocalDateTime iniciadoEm) {
        this.iniciadoEm = iniciadoEm;
        return this;
    }

    public LocalDateTime getEntregueEm() {
        return entregueEm;
    }

    public Entrega setEntregueEm(LocalDateTime entregueEm) {
        this.entregueEm = entregueEm;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrega entrega = (Entrega) o;
        return Objects.equals(id, entrega.id);
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", empresa=" + empresa +
                ", entregador=" + entregador +
                ", clienteNome='" + clienteNome + '\'' +
                ", clienteTelefone='" + clienteTelefone + '\'' +
                ", endereco=" + endereco +
                ", localizacaoAtual=" + localizacaoAtual +
                ", numeroCupom='" + numeroCupom + '\'' +
                ", status='" + status + '\'' +
                ", criadoEm=" + criadoEm +
                ", aceitoEm=" + aceitoEm +
                ", iniciadoEm=" + iniciadoEm +
                ", entregueEm=" + entregueEm +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
