package br.com.mariorusso.adapters.output.entity;

import br.com.mariorusso.domain.model.*;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class EntregaEntity extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    public EmpresaEntity empresa;

    @ManyToOne
    @JoinColumn(name = "entregador_id")
    public EntregadorEntity entregador;

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

    public  static EntregaEntity fromEntrega(Entrega entrega){
        return new EntregaEntity()
                .setEmpresa(entrega.empresa() != null ? entrega.empresa(): null)
                .setEntregador(entrega.entregador()!= null ? entrega.entregador() : null)
                .setClienteNome(entrega.clienteNome())
                .setClienteTelefone(entrega.clienteTelefone())
                .setEndereco(entrega.endereco())
                .setLocalizacaoAtual(entrega.localizacaoAtual())
                .setNumeroCupom(entrega.numeroCupom())
                .setStatus(entrega.status())
                .setCriadoEm(entrega.criadoEm())
                .setAceitoEm(entrega.aceitoEm())
                .setIniciadoEm(entrega.iniciadoEm())
                .setEntregueEm(entrega.entregueEm());

    }
    public Entrega toDomain(){
        return new Entrega()
                .setId(id)
                .setEmpresa(empresa.toDomain())
                .setEntregador( entregador.toDomain())
                .setClienteNome(clienteNome())
                .setClienteTelefone(clienteTelefone())
                .setEndereco(endereco())
                .setLocalizacaoAtual(localizacaoAtual())
                .setNumeroCupom(numeroCupom())
                .setStatus(status())
                .setCriadoEm(criadoEm())
                .setAceitoEm(aceitoEm())
                .setIniciadoEm(iniciadoEm())
                .setEntregueEm(entregueEm());

    }



    public EmpresaEntity empresa() {
        return empresa;
    }

    public EntregaEntity setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
        return this;
    }
    public EntregaEntity setEmpresa(Empresa empresa) {
        this.empresa = EmpresaEntity.fromDomain(empresa);
        return this;
    }

    public EntregadorEntity entregador() {
        return entregador;
    }

    public EntregaEntity setEntregador(EntregadorEntity entregador) {
        this.entregador = entregador;
        return this;
    }

    public EntregaEntity setEntregador(Entregador entregador) {
        this.entregador = EntregadorEntity.fromEntregador(entregador);
        return this;
    }

    public String clienteNome() {
        return clienteNome;
    }

    public EntregaEntity setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
        return this;
    }

    public String clienteTelefone() {
        return clienteTelefone;
    }

    public EntregaEntity setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
        return this;
    }

    public Endereco endereco() {
        return endereco;
    }

    public EntregaEntity setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Localizacao localizacaoAtual() {
        return localizacaoAtual;
    }

    public EntregaEntity setLocalizacaoAtual(Localizacao localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
        return this;
    }

    public String numeroCupom() {
        return numeroCupom;
    }

    public EntregaEntity setNumeroCupom(String numeroCupom) {
        this.numeroCupom = numeroCupom;
        return this;
    }

    public String status() {
        return status;
    }

    public EntregaEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime criadoEm() {
        return criadoEm;
    }

    public EntregaEntity setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
        return this;
    }

    public LocalDateTime aceitoEm() {
        return aceitoEm;
    }

    public EntregaEntity setAceitoEm(LocalDateTime aceitoEm) {
        this.aceitoEm = aceitoEm;
        return this;
    }

    public LocalDateTime iniciadoEm() {
        return iniciadoEm;
    }

    public EntregaEntity setIniciadoEm(LocalDateTime iniciadoEm) {
        this.iniciadoEm = iniciadoEm;
        return this;
    }

    public LocalDateTime entregueEm() {
        return entregueEm;
    }

    public EntregaEntity setEntregueEm(LocalDateTime entregueEm) {
        this.entregueEm = entregueEm;
        return this;
    }

    @Override
    public String toString() {
        return "EntregaEntity{" +
                "empresa=" + empresa +
                ", id=" + id +
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
}
