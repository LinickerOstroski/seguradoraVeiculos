package com.mycompany.seguradora.modelo.entidade;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Sinistro {
    
    private Integer idSinistro;
    private Calendar dataOcorrenciaSinistro;
    private String descricaoSinistro;
    private Double valorReparacaoSinistro;
    private Integer fkIdSeguroSinistro;
    
    private Seguro seguroSinistro = new Seguro();
    
    public Sinistro(){
        
    }
    
    public String getSinistroFormatado() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataOcorrenciaSinistro.getTime());
    }

    public Integer getIdSinistro() {
        return idSinistro;
    }

    public void setIdSinistro(Integer idSinistro) {
        this.idSinistro = idSinistro;
    }

    public Calendar getDataOcorrenciaSinistro() {
        return dataOcorrenciaSinistro;
    }

    public void setDataOcorrenciaSinistro(Calendar dataOcorrenciaSinistro) {
        this.dataOcorrenciaSinistro = dataOcorrenciaSinistro;
    }

    public String getDescricaoSinistro() {
        return descricaoSinistro;
    }

    public void setDescricaoSinistro(String descricaoSinistro) {
        this.descricaoSinistro = descricaoSinistro;
    }

    public Double getValorReparacaoSinistro() {
        return valorReparacaoSinistro;
    }

    public void setValorReparacaoSinistro(Double valorReparacaoSinistro) {
        this.valorReparacaoSinistro = valorReparacaoSinistro;
    }

    public Integer getFkIdSeguroSinistro() {
        return fkIdSeguroSinistro;
    }

    public void setFkIdSeguroSinistro(Integer fkIdSeguroSinistro) {
        this.fkIdSeguroSinistro = fkIdSeguroSinistro;
    }

    public Seguro getSeguroSinistro() {
        return seguroSinistro;
    }

    public void setSeguroSinistro(Seguro seguroSinistro) {
        this.seguroSinistro = seguroSinistro;
    }
    
    
}
