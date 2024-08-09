package com.mycompany.seguradora.modelo.entidade;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Segurado {

    private Integer idSegurado;
    private String nomeSegurado;
    private Calendar dataNascimentoSegurado;
    private String cepSegurado;
    private String estadoSegurado;
    private String enderecoSegurado;
    private String bairroSegurado;
    private String cidadeSegurado;
    private String telefoneSegurado;
    private String emailSegurado;
    private Integer fkIdBonusSegurado;
    private Integer fkIdVeiculoSegurado;
    private Veiculo veiculoSegurado = new Veiculo();
    private Bonus bonusSegurado = new Bonus();

    public Segurado() {

    }

    public Veiculo getVeiculoSegurado() {
        return veiculoSegurado;
    }

    public void setVeiculoSegurado(Veiculo veiculoSegurado) {
        this.veiculoSegurado = veiculoSegurado;
    }

    public Bonus getBonusSegurado() {
        return bonusSegurado;
    }

    public void setBonusSegurado(Bonus bonusSegurado) {
        this.bonusSegurado = bonusSegurado;
    }

   

    public Segurado(String nomeSegurado, Calendar dataNascimentoSegurado, String cepSegurado, String estadoSegurado, String enderecoSegurado, String bairroSegurado, String cidadeSegurado, String telefoneSegurado, String emailSegurado, Integer fkIdBonusSegurado, Integer fkIdVeiculoSegurado) {
        this.nomeSegurado = nomeSegurado;
        this.dataNascimentoSegurado = dataNascimentoSegurado;
        this.cepSegurado = cepSegurado;
        this.estadoSegurado = estadoSegurado;
        this.enderecoSegurado = enderecoSegurado;
        this.bairroSegurado = bairroSegurado;
        this.cidadeSegurado = cidadeSegurado;
        this.telefoneSegurado = telefoneSegurado;
        this.emailSegurado = emailSegurado;
        this.fkIdBonusSegurado = fkIdBonusSegurado;
        this.fkIdVeiculoSegurado = fkIdVeiculoSegurado;
    }

    public Integer getIdSegurado() {
        return idSegurado;
    }

    public void setIdSegurado(Integer idSegurado) {
        this.idSegurado = idSegurado;
    }

    public String getNomeSegurado() {
        return nomeSegurado;
    }

    public void setNomeSegurado(String nomeSegurado) {
        this.nomeSegurado = nomeSegurado;
    }

    public Calendar getDataNascimentoSegurado() {
        return dataNascimentoSegurado;
    }

    public void setDataNascimentoSegurado(Calendar dataNascimentoSegurado) {
        this.dataNascimentoSegurado = dataNascimentoSegurado;
    }

    public String getCepSegurado() {
        return cepSegurado;
    }

    public void setCepSegurado(String cepSegurado) {
        this.cepSegurado = cepSegurado;
    }

    public String getEstadoSegurado() {
        return estadoSegurado;
    }

    public void setEstadoSegurado(String estadoSegurado) {
        this.estadoSegurado = estadoSegurado;
    }

    public String getEnderecoSegurado() {
        return enderecoSegurado;
    }

    public void setEnderecoSegurado(String enderecoSegurado) {
        this.enderecoSegurado = enderecoSegurado;
    }

    public String getBairroSegurado() {
        return bairroSegurado;
    }

    public void setBairroSegurado(String bairroSegurado) {
        this.bairroSegurado = bairroSegurado;
    }

    public String getCidadeSegurado() {
        return cidadeSegurado;
    }

    public void setCidadeSegurado(String cidadeSegurado) {
        this.cidadeSegurado = cidadeSegurado;
    }

    public String getTelefoneSegurado() {
        return telefoneSegurado;
    }

    public void setTelefoneSegurado(String telefoneSegurado) {
        this.telefoneSegurado = telefoneSegurado;
    }

    public String getEmailSegurado() {
        return emailSegurado;
    }

    public void setEmailSegurado(String emailSegurado) {
        this.emailSegurado = emailSegurado;
    }

    public Integer getFkIdBonusSegurado() {
        return fkIdBonusSegurado;
    }

    public void setFkIdBonusSegurado(Integer fkIdBonusSegurado) {
        this.fkIdBonusSegurado = fkIdBonusSegurado;
    }

    public Integer getFkIdVeiculoSegurado() {
        return fkIdVeiculoSegurado;
    }

    public void setFkIdVeiculoSegurado(Integer fkIdVeiculoSegurado) {
        this.fkIdVeiculoSegurado = fkIdVeiculoSegurado;
    }
    
     public String getNascimentoFormatado() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataNascimentoSegurado.getTime());
    }
}
