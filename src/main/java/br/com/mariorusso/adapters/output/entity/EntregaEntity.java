package br.com.mariorusso.adapters.output.entity;

import br.com.mariorusso.domain.model.Endereco;
import br.com.mariorusso.domain.model.Entrega;
import br.com.mariorusso.domain.model.Localizacao;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class EntregaEntity extends PanacheEntity {

    // IDs simples ao invés de relacionamentos JPA
    public Long empresaId;
    public Long entregadorId;

    public String clienteNome;
    public String clienteTelefone;

    @Embedded
    public Endereco endereco;

    @Embedded
    public Localizacao localizacaoAtual;

    public String numeroCupom;
    public String status;

    public LocalDateTime criadoEm;
    public LocalDateTime aceitoEm;
    public LocalDateTime iniciadoEm;
    public LocalDateTime entregueEm;

    public EntregaEntity() {
    }

    public static EntregaEntity fromEntrega(Entrega entrega) {
        return new EntregaEntity()
                .setEmpresaId(entrega.getEmpresa())
                .setEntregadorId(entrega.getEntregador())
                .setClienteNome(entrega.getClienteNome())
                .setClienteTelefone(entrega.getClienteTelefone())
                .setEndereco(entrega.getEndereco())
                .setLocalizacaoAtual(entrega.getLocalizacaoAtual())
                .setNumeroCupom(entrega.getNumeroCupom())
                .setStatus(entrega.getStatus())
                .setCriadoEm(entrega.getCriadoEm())
                .setAceitoEm(entrega.getAceitoEm())
                .setIniciadoEm(entrega.getIniciadoEm())
                .setEntregueEm(entrega.getEntregueEm());
    }

    public Entrega toDomain() {
        return new Entrega()
                .setId(id)
                .setEmpresa(empresaId)
                .setEntregador(entregadorId)
                .setClienteNome(clienteNome)
                .setClienteTelefone(clienteTelefone)
                .setEndereco(endereco)
                .setLocalizacaoAtual(localizacaoAtual)
                .setNumeroCupom(numeroCupom)
                .setStatus(status)
                .setCriadoEm(criadoEm)
                .setAceitoEm(aceitoEm)
                .setIniciadoEm(iniciadoEm)
                .setEntregueEm(entregueEm);
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public EntregaEntity setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
        return this;
    }

    public Long getEntregadorId() {
        return entregadorId;
    }

    public EntregaEntity setEntregadorId(Long entregadorId) {
        this.entregadorId = entregadorId;
        return this;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public EntregaEntity setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
        return this;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public EntregaEntity setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public EntregaEntity setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Localizacao getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public EntregaEntity setLocalizacaoAtual(Localizacao localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
        return this;
    }

    public String getNumeroCupom() {
        return numeroCupom;
    }

    public EntregaEntity setNumeroCupom(String numeroCupom) {
        this.numeroCupom = numeroCupom;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public EntregaEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public EntregaEntity setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
        return this;
    }

    public LocalDateTime getAceitoEm() {
        return aceitoEm;
    }

    public EntregaEntity setAceitoEm(LocalDateTime aceitoEm) {
        this.aceitoEm = aceitoEm;
        return this;
    }

    public LocalDateTime getIniciadoEm() {
        return iniciadoEm;
    }

    public EntregaEntity setIniciadoEm(LocalDateTime iniciadoEm) {
        this.iniciadoEm = iniciadoEm;
        return this;
    }

    public LocalDateTime getEntregueEm() {
        return entregueEm;
    }

    public EntregaEntity setEntregueEm(LocalDateTime entregueEm) {
        this.entregueEm = entregueEm;
        return this;
    }

    @Override
    public String toString() {
        return "EntregaEntity{" +
                "empresaId=" + empresaId +
                ", entregadorId=" + entregadorId +
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
}