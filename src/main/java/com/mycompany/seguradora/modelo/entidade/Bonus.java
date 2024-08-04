package com.mycompany.seguradora.modelo.entidade;

public class Bonus {
    
    private Integer idBonus;
    private double valorBonus;
    private String descricaoBonus;
    
    public Bonus(){
        
    }

    public Bonus(double valorBonus, String descricaoBonus) {
        this.valorBonus = valorBonus;
        this.descricaoBonus = descricaoBonus;
    }

    public Integer getIdBonus() {
        return idBonus;
    }

    public void setIdBonus(Integer idBonus) {
        this.idBonus = idBonus;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    public String getDescricaoBonus() {
        return descricaoBonus;
    }

    public void setDescricaoBonus(String descricaoBonus) {
        this.descricaoBonus = descricaoBonus;
    }
    
    
    
}
