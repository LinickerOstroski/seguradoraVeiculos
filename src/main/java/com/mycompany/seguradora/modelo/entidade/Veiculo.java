package com.mycompany.seguradora.modelo.entidade;

public class Veiculo {
    
    private Integer idVeiculo;
    private String placaVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String anoVeiculo;
    private String chassiVeiculo;
    private String capacidadeVeiculo;
    private String categoriaVeiculo;
    private String corVeiculo;
    private Double fipeVeiculo;

    public Veiculo(){
        
    }

    public Veiculo(String placaVeiculo, String marcaVeiculo, String modeloVeiculo, String anoVeiculo, String chassiVeiculo, String capacidadeVeiculo, String categoriaVeiculo, String corVeiculo, Double fipeVeiculo) {
        this.placaVeiculo = placaVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.chassiVeiculo = chassiVeiculo;
        this.capacidadeVeiculo = capacidadeVeiculo;
        this.categoriaVeiculo = categoriaVeiculo;
        this.corVeiculo = corVeiculo;
        this.fipeVeiculo = fipeVeiculo;
    }
    
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(String anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public String getChassiVeiculo() {
        return chassiVeiculo;
    }

    public void setChassiVeiculo(String chassiVeiculo) {
        this.chassiVeiculo = chassiVeiculo;
    }

    public String getCapacidadeVeiculo() {
        return capacidadeVeiculo;
    }

    public void setCapacidadeVeiculo(String capacidadeVeiculo) {
        this.capacidadeVeiculo = capacidadeVeiculo;
    }

    public String getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(String categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public Double getFipeVeiculo() {
        return fipeVeiculo;
    }

    public void setFipeVeiculo(Double fipeVeiculo) {
        this.fipeVeiculo = fipeVeiculo;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }
    
    public void setIdVeiculo(Integer idVeiculo){
        this.idVeiculo = idVeiculo;
    }
}
