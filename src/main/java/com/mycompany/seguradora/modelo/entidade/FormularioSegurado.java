package com.mycompany.seguradora.modelo.entidade;

public class FormularioSegurado {

    private Integer idFormularioSegurado;
    private String nomeFormularioSegurado;
    private String emailFormularioSegurado;
    private String telefoneFormularioSegurado;

    public FormularioSegurado() {

    }

    public FormularioSegurado(String nomeFormularioSegurado, String emailFormularioSegurado, String telefoneFormularioSegurado) {
        this.nomeFormularioSegurado = nomeFormularioSegurado;
        this.emailFormularioSegurado = emailFormularioSegurado;
        this.telefoneFormularioSegurado = telefoneFormularioSegurado;
    }

    public Integer getIdFormularioSegurado() {
        return idFormularioSegurado;
    }

    public void setIdFormularioSegurado(Integer idFormularioSegurado) {
        this.idFormularioSegurado = idFormularioSegurado;
    }

    public String getNomeFormularioSegurado() {
        return nomeFormularioSegurado;
    }

    public void setNomeFormularioSegurado(String nomeFormularioSegurado) {
        this.nomeFormularioSegurado = nomeFormularioSegurado;
    }

    public String getEmailFormularioSegurado() {
        return emailFormularioSegurado;
    }

    public void setEmailFormularioSegurado(String emailFormularioSegurado) {
        this.emailFormularioSegurado = emailFormularioSegurado;
    }

    public String getTelefoneFormularioSegurado() {
        return telefoneFormularioSegurado;
    }

    public void setTelefoneFormularioSegurado(String telefoneFormularioSegurado) {
        this.telefoneFormularioSegurado = telefoneFormularioSegurado;
    }

}
