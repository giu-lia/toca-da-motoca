package modelos;

public class Veiculo {

    private Integer id;
    private Boolean disponivel;
    private Integer categoria;
    private String marca;
    private String modelo;
    private Integer ano;
    private Float altura;
    private Float largura;
    private Float peso;
    private String tipoDoMotor;
    private Float capacidadeDoTanque;
    private Float consumoMedio;
    private Boolean portaDeEnegia;
    private Boolean radio;
    private Boolean cdPlayer;
    private Boolean escudoDeVento;
    private Float aluguelDiario;

    public Veiculo(Boolean disponivel, Integer categoria, String marca, String modelo, Integer ano, Float altura, Float largura, Float peso, String tipoDoMotor, Float capacidadeDoTanque, Float consumoMedio, Boolean portaDeEnegia, Boolean radio, Boolean cdPlayer, Boolean escudoDeVento, Float aluguelDiario) {
        this.disponivel = disponivel;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.altura = altura;
        this.largura = largura;
        this.peso = peso;
        this.tipoDoMotor = tipoDoMotor;
        this.capacidadeDoTanque = capacidadeDoTanque;
        this.consumoMedio = consumoMedio;
        this.portaDeEnegia = portaDeEnegia;
        this.radio = radio;
        this.cdPlayer = cdPlayer;
        this.escudoDeVento = escudoDeVento;
        this.aluguelDiario = aluguelDiario;
    }

    public Veiculo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getLargura() {
        return largura;
    }

    public void setLargura(Float largura) {
        this.largura = largura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getTipoDoMotor() {
        return tipoDoMotor;
    }

    public void setTipoDoMotor(String tipoDoMotor) {
        this.tipoDoMotor = tipoDoMotor;
    }

    public Float getCapacidadeDoTanque() {
        return capacidadeDoTanque;
    }

    public void setCapacidadeDoTanque(Float capacidadeDoTanque) {
        this.capacidadeDoTanque = capacidadeDoTanque;
    }

    public Float getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(Float consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public Boolean getPortaDeEnegia() {
        return portaDeEnegia;
    }

    public void setPortaDeEnegia(Boolean portaDeEnegia) {
        this.portaDeEnegia = portaDeEnegia;
    }

    public Boolean getRadio() {
        return radio;
    }

    public void setRadio(Boolean radio) {
        this.radio = radio;
    }

    public Boolean getCdPlayer() {
        return cdPlayer;
    }

    public void setCdPlayer(Boolean cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    public Boolean getEscudoDeVento() {
        return escudoDeVento;
    }

    public void setEscudoDeVento(Boolean escudoDeVento) {
        this.escudoDeVento = escudoDeVento;
    }

    public Float getAluguelDiario() {
        return aluguelDiario;
    }

    public void setAluguelDiario(Float aluguelDiario) {
        this.aluguelDiario = aluguelDiario;
    }

}
