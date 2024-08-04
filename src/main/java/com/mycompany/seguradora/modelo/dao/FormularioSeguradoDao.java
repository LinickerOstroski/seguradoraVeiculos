package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.entidade.FormularioSegurado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FormularioSeguradorDao extends GenericoDao<FormularioSegurado> {

    public void salvar(Seguradora s) {
        String insert = "INSERT INTO SEGURADORA(NOME,CNPJ,ENDERECO,TELEFONE,EMAIL) VALUES (?,?,?,?,?)";
        save(insert, s.getNomeSeguradora(), s.getCnpjSeguradora(), s.getEnderecoSeguradora(), s.getTelefoneSeguradora(),
                s.getEmailSeguradora());
    }

    public void alterar(Seguradora s) {
        String update = "UPDATE SEGURADORA SET NOME=?, CNPJ=?, ENDERECO=?, TELEFONE=?, EMAIL=? WHERE idSeguradora=?";
        save(update, s.getNomeSeguradora(), s.getCnpjSeguradora(), s.getEnderecoSeguradora(), s.getTelefoneSeguradora(), s.getEmailSeguradora(), s.getIdSeguradora());
    }

    public void excluir(Seguradora s) {
        String delete = "DELETE FROM SEGURADORA WHERE idSeguradora=?";
        save(delete, s.getIdSeguradora());
    }

    public Seguradora buscarPorId(int id) {
        String select = "SELECT * FROM SEGURADORA WHERE idSeguradora=?";
        return buscarPorId(select, new SeguradoraRowMapper(), id);
    }

    public List<Seguradora> buscarTodas() {
        String select = "SELECT * FROM SEGURADORA";
        return buscarTodos(select, new SeguradoraRowMapper());
    }

    public static class SeguradoraRowMapper implements RowMapper<Seguradora> {

        @Override
        public Seguradora mapRow(ResultSet rs) throws SQLException {
            Seguradora seguradora = new Seguradora();
            seguradora.setIdSeguradora(rs.getInt("idSeguradora"));
            seguradora.setNomeSeguradora(rs.getString("NOME"));
            seguradora.setCnpjSeguradora(rs.getString("CNPJ"));
            seguradora.setEnderecoSeguradora(rs.getString("ENDERECO"));
            seguradora.setTelefoneSeguradora(rs.getString("TELEFONE"));
            seguradora.setEmailSeguradora(rs.getString("EMAIL"));

            return seguradora;
        }

    }

}
