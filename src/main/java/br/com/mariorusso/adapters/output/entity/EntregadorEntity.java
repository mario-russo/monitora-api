package br.com.mariorusso.adapters.output.entity;

import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.model.Entregador;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EntregadorEntity extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private EmpresaEntity empresa;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String telefone;

    @Column(unique = true, nullable = false)
    private String email;

    private String veiculo;
    private String placa;


    public EntregadorEntity() {
    }

    public static EntregadorEntity fromEntregador(Entregador entregador) {
        return new EntregadorEntity()
                .setEmpresa( EmpresaEntity.fromDomain(entregador.getEmpresa()) != null ? EmpresaEntity.fromDomain(entregador.getEmpresa()) :null)
                .setNomeCompleto(entregador.getNomeCompleto())
                .setCpf(entregador.getCpf())
                .setTelefone(entregador.getTelefone())
                .setEmail(entregador.getEmail())
                .setVeiculo(entregador.getVeiculo())
                .setPlaca(entregador.getPlaca());

    }
    public Entregador toDomain (){

        return  new Entregador()
                .setId(id)
                .setEmpresa(empresa.toDomain())
                .setNomeCompleto(getNomeCompleto())
                .setCpf(getCpf())
                .setTelefone(getTelefone())
                .setEmail(getEmail())
                .setVeiculo(getVeiculo())
                .setPlaca(getPlaca());
    }


    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public EntregadorEntity setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
        return this;
    }

    public EntregadorEntity setEmpresa(Empresa empresa) {
        this.empresa = EmpresaEntity.fromDomain(empresa);
        return this;
    }


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public EntregadorEntity setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public EntregadorEntity setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public EntregadorEntity setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EntregadorEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public EntregadorEntity setVeiculo(String veiculo) {
        this.veiculo = veiculo;
        return this;
    }

    public String getPlaca() {
        return placa;
    }

    public EntregadorEntity setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    @Override
    public String toString() {
        return "EntregadorEntity{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", veiculo='" + veiculo + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", empresa=" + empresa +
                '}';
    }

}
