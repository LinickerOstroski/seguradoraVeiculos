package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.entidade.FormularioSegurado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FormularioSeguradoDao extends GenericoDao<FormularioSegurado> {

    public void salvar(FormularioSegurado f) {
        String insert = "INSERT INTO FORMULARIOSEGURADO(NOME,EMAIL,TELEFONE) VALUES (?,?,?)";
        save(insert, f.getNomeFormularioSegurado(),f.getEmailFormularioSegurado(),f.getTelefoneFormularioSegurado());
    }

    public void alterar(FormularioSegurado f) {
        String update = "UPDATE FORMULARIOSEGURADO SET NOME=?, EMAIL=?, TELEFONE=? WHERE idFormularioSegurado=?";
        save(update, f.getNomeFormularioSegurado(),f.getTelefoneFormularioSegurado(),f.getTelefoneFormularioSegurado()
        ,f.getIdFormularioSegurado());
    }

    public void excluir(FormularioSegurado f) {
        String delete = "DELETE FROM FORMULARIOSEGURADO WHERE idFormularioSegurado=?";
        save(delete, f.getIdFormularioSegurado());
    }

    public FormularioSegurado buscarPorId(int id) {
        String select = "SELECT * FROM FORMULARIOSEGURADO WHERE idFormularioSegurado=?";
        return buscarPorId(select, new FormularioSeguradoRowMapper(), id);
    }

    public List<FormularioSegurado> buscarTodas() {
        String select = "SELECT * FROM FORMULARIOSEGURADO";
        return buscarTodos(select, new FormularioSeguradoRowMapper());
    }

    public static class FormularioSeguradoRowMapper implements RowMapper<FormularioSegurado> {

        @Override
        public FormularioSegurado mapRow(ResultSet rs) throws SQLException {
            FormularioSegurado formularioSegurado = new FormularioSegurado();
            formularioSegurado.setIdFormularioSegurado(rs.getInt("idFormularioSegurado"));
            formularioSegurado.setNomeFormularioSegurado(rs.getString("NOME"));
            formularioSegurado.setEmailFormularioSegurado(rs.getString("EMAIL"));
            formularioSegurado.setTelefoneFormularioSegurado(rs.getString("TELEFONE"));
           
            return formularioSegurado;
        }

    }

}
