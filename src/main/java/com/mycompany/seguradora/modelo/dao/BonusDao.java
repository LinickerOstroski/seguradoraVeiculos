package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.dao.GenericoDao;
import com.mycompany.seguradora.modelo.dao.RowMapper;
import com.mycompany.seguradora.modelo.entidade.Bonus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BonusDao extends GenericoDao<Bonus> {

    public void salvar(Bonus b) {
        String insert = "INSERT INTO BONUS(VALOR, DESCRICAO) VALUES (?, ?)";
        save(insert, b.getValorBonus(), b.getDescricaoBonus());
    }

    public void alterar(Bonus b) {
        String update = "UPDATE BONUS SET VALOR=?, DESCRICAO=? WHERE idBonus=?";
        save(update, b.getValorBonus(), b.getDescricaoBonus(), b.getIdBonus());
    }

    public void excluir(Bonus b) {
        String delete = "DELETE FROM BONUS WHERE idBonus=?";
        save(delete, b.getIdBonus());
    }

    public Bonus buscarPorId(int id) {
        String select = "SELECT * FROM BONUS WHERE idBonus=?";
        return buscarPorId(select, new BonusRowMapper(), id);
    }

    public List<Bonus> buscarTodos() {
        String select = "SELECT * FROM BONUS";
        return buscarTodos(select, new BonusRowMapper());
    }

    public static class BonusRowMapper implements RowMapper<Bonus> {

        @Override
        public Bonus mapRow(ResultSet rs) throws SQLException {
            Bonus bonus = new Bonus();
            bonus.setIdBonus(rs.getInt("idBonus"));
            bonus.setValorBonus(rs.getDouble("VALOR"));
            bonus.setDescricaoBonus(rs.getString("DESCRICAO"));
            return bonus;
        }
    }
}
