package modelos;

import java.sql.Date;

public class Aluguel {



    private Integer id;
    private Integer idCliente;
    private Integer idVeiculo;
    private Date feitoEm;
    private Date dataRetirada;
    private Date dataDevolucao;
    private String localRetirada;
    private String localDevolucao;
    private Float combustivel;
    private Float jaqueta;
    private Float seguro;
    private Float valorTotal;

    public Aluguel() {
    }

    public Aluguel(Integer idCliente, Integer idVeiculo, Date feitoEm, Date dataRetirada, Date dataDevolucao, String localRetirada, String localDevolucao, Float combustivel, Float jaqueta, Float seguro, Float valorTotal) {
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.feitoEm = feitoEm;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.localRetirada = localRetirada;
        this.localDevolucao = localDevolucao;
        this.combustivel = combustivel;
        this.jaqueta = jaqueta;
        this.seguro = seguro;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Date getFeitoEm() {
        return feitoEm;
    }

    public void setFeitoEm(Date feitoEm) {
        this.feitoEm = feitoEm;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

    public Float getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Float combustivel) {
        this.combustivel = combustivel;
    }

    public Float getJaqueta() {
        return jaqueta;
    }

    public void setJaqueta(Float jaqueta) {
        this.jaqueta = jaqueta;
    }

    public Float getSeguro() {
        return seguro;
    }

    public void setSeguro(Float seguro) {
        this.seguro = seguro;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}

