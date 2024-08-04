package com.mycompany.seguradora.modelo.entidade;


public class Assistencia {
    
    private Integer idAssistencia;
    private String tipoAssistencia;
    private String descricao;
    
    public Assistencia(){
        
    }

    public Assistencia(String tipoAssistencia, String descricao) {
        this.tipoAssistencia = tipoAssistencia;
        this.descricao = descricao;
    }
    

    public Integer getIdAssistencia() {
        return idAssistencia;
    }

    public void setIdAssistencia(Integer idAssistencia) {
        this.idAssistencia = idAssistencia;
    }

    public String getTipoAssistencia() {
        return tipoAssistencia;
    }

    public void setTipoAssistencia(String tipoAssistencia) {
        this.tipoAssistencia = tipoAssistencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
