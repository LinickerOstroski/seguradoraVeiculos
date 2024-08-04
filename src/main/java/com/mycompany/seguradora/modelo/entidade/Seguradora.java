package com.mycompany.seguradora.modelo.entidade;

public class Seguradora {
    
    private Integer idSeguradora;
    private String nomeSeguradora;
    private String cnpjSeguradora;
    private String enderecoSeguradora;
    private String telefoneSeguradora;
    private String emailSeguradora;
    
    
    public Seguradora(){
    
    }
    
    public Seguradora(String nomeSeguradora, String cnpjSeguradora, String enderecoSeguradora, String telefoneSeguradora, String emailSeguradora){
        this.nomeSeguradora = nomeSeguradora;
        this.cnpjSeguradora = cnpjSeguradora;
        this.enderecoSeguradora = enderecoSeguradora;
        this.telefoneSeguradora = telefoneSeguradora;
        this.emailSeguradora = emailSeguradora;
    }

    public Integer getIdSeguradora() {
        return idSeguradora;
    }

    public void setIdSeguradora(Integer idSeguradora) {
        this.idSeguradora = idSeguradora;
    }

    public String getNomeSeguradora() {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(String nomeSeguradora) {
        this.nomeSeguradora = nomeSeguradora;
    }

    public String getCnpjSeguradora() {
        return cnpjSeguradora;
    }

    public void setCnpjSeguradora(String cnpjSeguradora) {
        this.cnpjSeguradora = cnpjSeguradora;
    }

    public String getEnderecoSeguradora() {
        return enderecoSeguradora;
    }

    public void setEnderecoSeguradora(String enderecoSeguradora) {
        this.enderecoSeguradora = enderecoSeguradora;
    }

    public String getTelefoneSeguradora() {
        return telefoneSeguradora;
    }

    public void setTelefoneSeguradora(String telefoneSeguradora) {
        this.telefoneSeguradora = telefoneSeguradora;
    }

    public String getEmailSeguradora() {
        return emailSeguradora;
    }

    public void setEmailSeguradora(String emailSeguradora) {
        this.emailSeguradora = emailSeguradora;
    }
}
