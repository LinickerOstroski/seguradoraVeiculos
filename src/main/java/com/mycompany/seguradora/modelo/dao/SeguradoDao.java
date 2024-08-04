package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.entidade.Segurado;
import com.mycompany.seguradora.servico.ConverteData;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class SeguradoDao extends GenericoDao<Segurado> {

    public void salvar(Segurado s) {
        String insert = "INSERT INTO SEGURADO(nome, dataNascimento, cep, estado, endereco, bairro, cidade, telefone, email, fk_idBonus, fk_idVeiculo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        save(insert, s.getNomeSegurado(), convertCalendarToSqlDate(s.getDataNascimentoSegurado()), s.getCepSegurado(), s.getEstadoSegurado(), s.getEnderecoSegurado(), s.getBairroSegurado(),
                s.getCidadeSegurado(), s.getTelefoneSegurado(), s.getEmailSegurado(), s.getFkIdBonusSegurado(), s.getFkIdVeiculoSegurado());
    }

    public void alterar(Segurado s) {
        String update = "UPDATE SEGURADO SET nome=?, dataNascimento=?, cep=?, estado=?, endereco=?, bairro=?, cidade=?, telefone=?, email=?, fk_idBonus=?, fk_idVeiculo=? WHERE idSegurado=?";
        save(update, s.getNomeSegurado(), convertCalendarToSqlDate(s.getDataNascimentoSegurado()), s.getCepSegurado(), s.getEstadoSegurado(), s.getEnderecoSegurado(), s.getBairroSegurado(),
                s.getCidadeSegurado(), s.getTelefoneSegurado(), s.getEmailSegurado(), s.getFkIdBonusSegurado(), s.getFkIdVeiculoSegurado(), s.getIdSegurado());
    }

    public void excluir(Segurado s) {
        String delete = "DELETE FROM SEGURADO WHERE idSegurado=?";
        save(delete, s.getIdSegurado());
    }

    public Segurado buscarPorId(int id) {
        String select = "SELECT * FROM SEGURADO WHERE idSegurado=?";
        return buscarPorId(select, new SeguradoRowMapper(), id);
    }

    public List<Segurado> buscarTodos() {
        String select = "SELECT * FROM SEGURADO";
        return buscarTodos(select, new SeguradoRowMapper());
    }

    private Date convertCalendarToSqlDate(Calendar calendar) {
        return new Date(calendar.getTimeInMillis());
    }

    private Calendar convertSqlDateToCalendar(Date sqlDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sqlDate);
        return calendar;
    }

    public static class SeguradoRowMapper implements RowMapper<Segurado> {

        ConverteData converte = new ConverteData();

        @Override
        public Segurado mapRow(ResultSet rs) throws SQLException {
            Segurado segurado = new Segurado();
            VeiculoDao veiculoDao = new VeiculoDao();
            BonusDao bonusDao = new BonusDao();

            segurado.setIdSegurado(rs.getInt("idSegurado"));
            segurado.setNomeSegurado(rs.getString("nome"));
            segurado.setDataNascimentoSegurado(converte.converteCalendario(rs.getDate("dataNascimento"))); // Convertendo java.sql.Date para Calendar
            segurado.setCepSegurado(rs.getString("cep"));
            segurado.setEstadoSegurado(rs.getString("estado"));
            segurado.setEnderecoSegurado(rs.getString("endereco"));
            segurado.setBairroSegurado(rs.getString("bairro"));
            segurado.setCidadeSegurado(rs.getString("cidade"));
            segurado.setTelefoneSegurado(rs.getString("telefone"));
            segurado.setEmailSegurado(rs.getString("email"));
            segurado.setFkIdBonusSegurado(rs.getInt("fk_idBonus"));
            segurado.setFkIdVeiculoSegurado(rs.getInt("fk_idVeiculo"));
            return segurado;
        }
    }
}
