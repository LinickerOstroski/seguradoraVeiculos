package com.mycompany.seguradora.modelo.entidade;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Seguro {
    
    private Integer idSeguro;
    private String tipoSeguro;
    private Calendar inicioVigenciaSeguro;
    private Calendar fimVigenciaSeguro;
    private String assistenciaSeguro;
    private Double valorSeguro;
    private Integer fkIdSeguradoSeguro;
    private Integer fkIdVeiculoSeguro;
    private Segurado seguradoSeguro = new Segurado();
    private Veiculo veiculoSeguro = new Veiculo();
    
    public Seguro(){
        
    }

    public Seguro(Integer idSeguro, String tipoSeguro, Calendar inicioVigenciaSeguro, Calendar fimVigenciaSeguro, String assistenciaSeguro, Double valorSeguro, Integer fkIdSeguradoSeguro, Integer fkIdVeiculoSeguro, Segurado seguradoSeguro, Veiculo veiculoSeguro) {
        this.idSeguro = idSeguro;
        this.tipoSeguro = tipoSeguro;
        this.inicioVigenciaSeguro = inicioVigenciaSeguro;
        this.fimVigenciaSeguro = fimVigenciaSeguro;
        this.assistenciaSeguro = assistenciaSeguro;
        this.valorSeguro = valorSeguro;
        this.fkIdSeguradoSeguro = fkIdSeguradoSeguro;
        this.fkIdVeiculoSeguro = fkIdVeiculoSeguro;
        this.seguradoSeguro = seguradoSeguro;
        this.veiculoSeguro = veiculoSeguro;
    }

    

    public Segurado getSeguradoSeguro() {
        return seguradoSeguro;
    }

    public void setSeguradoSeguro(Segurado seguradoSeguro) {
        this.seguradoSeguro = seguradoSeguro;
    }

    public Veiculo getVeiculoSeguro() {
        return veiculoSeguro;
    }

    public void setVeiculoSeguro(Veiculo veiculoSeguro) {
        this.veiculoSeguro = veiculoSeguro;
    }
    

    public Integer getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Integer idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public Calendar getInicioVigenciaSeguro() {
        return inicioVigenciaSeguro;
    }

    public void setInicioVigenciaSeguro(Calendar inicioVigenciaSeguro) {
        this.inicioVigenciaSeguro = inicioVigenciaSeguro;
    }

    public Calendar getFimVigenciaSeguro() {
        return fimVigenciaSeguro;
    }

    public void setFimVigenciaSeguro(Calendar fimVigenciaSeguro) {
        this.fimVigenciaSeguro = fimVigenciaSeguro;
    }

    public String getAssistenciaSeguro() {
        return assistenciaSeguro;
    }

    public void setAssistenciaSeguro(String assistenciaSeguro) {
        this.assistenciaSeguro = assistenciaSeguro;
    }

    public Double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(Double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public Integer getFkIdSeguradoSeguro() {
        return fkIdSeguradoSeguro;
    }

    public void setFkIdSeguradoSeguro(Integer fkIdSeguradoSeguro) {
        this.fkIdSeguradoSeguro = fkIdSeguradoSeguro;
    }

    public Integer getFkIdVeiculoSeguro() {
        return fkIdVeiculoSeguro;
    }

    public void setFkIdVeiculoSeguro(Integer fkIdVeiculoSeguro) {
        this.fkIdVeiculoSeguro = fkIdVeiculoSeguro;
    }
    
    
    public String getInicioVigenciaFormatado() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(inicioVigenciaSeguro.getTime());
    }
    
    public String getFimVigenciaFormatado() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fimVigenciaSeguro.getTime());
    }
}
