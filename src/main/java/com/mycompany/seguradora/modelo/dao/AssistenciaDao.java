package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.entidade.Assistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AssistenciaDao extends GenericoDao<Assistencia> {

    public void salvar(Assistencia a) {
        String insert = "INSERT INTO ASSISTENCIA(TIPO, DESCRICAO) VALUES (?, ?)";
        save(insert, a.getTipoAssistencia(), a.getDescricao());
    }

    public void alterar(Assistencia a) {
        String update = "UPDATE ASSISTENCIA SET TIPO=?, DESCRICAO=? WHERE idAssistencia=?";
        save(update, a.getTipoAssistencia(), a.getDescricao(), a.getIdAssistencia());
    }

    public void excluir(Assistencia a) {
        String delete = "DELETE FROM ASSISTENCIA WHERE idAssistencia=?";
        save(delete, a.getIdAssistencia());
    }

    public Assistencia buscarPorId(int id) {
        String select = "SELECT * FROM ASSISTENCIA WHERE idAssistencia=?";
        return buscarPorId(select, new AssistenciaRowMapper(), id);
    }

    public List<Assistencia> buscarTodas() {
        String select = "SELECT * FROM ASSISTENCIA";
        return buscarTodos(select, new AssistenciaRowMapper());
    }

    public static class AssistenciaRowMapper implements RowMapper<Assistencia> {

        @Override
        public Assistencia mapRow(ResultSet rs) throws SQLException {
            Assistencia assistencia = new Assistencia();
            assistencia.setIdAssistencia(rs.getInt("idAssistencia"));
            assistencia.setTipoAssistencia(rs.getString("TIPO"));
            assistencia.setDescricao(rs.getString("DESCRICAO"));

            return assistencia;
        }

    }

}
