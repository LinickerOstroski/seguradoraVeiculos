package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.entidade.Seguro;
import com.mycompany.seguradora.servico.ConverteData;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class SeguroDao extends GenericoDao<Seguro>{
    
    public void salvar(Seguro s) {
        String insert = "INSERT INTO SEGURO(tipoSeguro, inicioVigenciaSeguro, fimVigenciaSeguro, assistenciaSeguro, valorSeguro, fkIdSeguradoSeguro, fkIdVeiculoSeguro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        save(insert, s.getTipoSeguro(), convertCalendarToSqlDate(s.getInicioVigenciaSeguro()), convertCalendarToSqlDate(s.getFimVigenciaSeguro()), s.getAssistenciaSeguro(),s.getValorSeguro(),
                s.getSeguradoSeguro().getIdSegurado(),s.getVeiculoSeguro().getIdVeiculo());
    }
     public void alterar(Seguro s) {
        String update = "UPDATE SEGURO SET tipoSeguro=?, inicioVigenciaSeguro=?, fimVigenciaSeguro=?, assistenciaSeguro=?, valorSeguro=?, fkIdSeguradoSeguro=?, fkIdVeiculoSeguro=? WHERE idSeguro=?";
        save(update,s.getTipoSeguro(), convertCalendarToSqlDate(s.getInicioVigenciaSeguro()), convertCalendarToSqlDate(s.getFimVigenciaSeguro()), s.getAssistenciaSeguro(),s.getValorSeguro(),
                s.getSeguradoSeguro().getIdSegurado(),s.getVeiculoSeguro().getIdVeiculo(), s.getIdSeguro());
    }
    
      public void excluir(Seguro s) {
        String delete = "DELETE FROM SEGURO WHERE idSeguro=?";
        save(delete, s.getIdSeguro());
    }

    public Seguro buscarPorId(int id) {
        String select = "SELECT * FROM SEGURO WHERE idSeguro=?";
        return buscarPorId(select, new SeguroRowMapper(), id);
    }

    public List<Seguro> buscarTodos() {
        String select = "SELECT * FROM SEGURO";
        return buscarTodos(select, new SeguroRowMapper());
    }
    
    private Date convertCalendarToSqlDate(Calendar calendar) {
        return new Date(calendar.getTimeInMillis());
    }
    
    private Calendar convertSqlDateToCalendar(Date sqlDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sqlDate);
        return calendar;
    }
    
    public static class SeguroRowMapper implements RowMapper<Seguro> {

        ConverteData converte = new ConverteData();

        @Override
        public Seguro mapRow(ResultSet rs) throws SQLException {
            Seguro seguro = new Seguro();
            VeiculoDao veiculoDao = new VeiculoDao();
            SeguradoDao seguradoDao = new SeguradoDao();

            seguro.setIdSeguro(rs.getInt("idSeguro"));
            seguro.setTipoSeguro(rs.getString("tipoSeguro"));
            seguro.setInicioVigenciaSeguro(converte.converteCalendario(rs.getDate("inicioVigenciaSeguro"))); // Convertendo java.sql.Date para Calendar
            seguro.setFimVigenciaSeguro(converte.converteCalendario(rs.getDate("fimVigenciaSeguro")));
            seguro.setAssistenciaSeguro(rs.getString("assistenciaSeguro")); // Convertendo java.sql.Date para Calendar
            seguro.setValorSeguro(rs.getDouble("valorSeguro"));
            seguro.setSeguradoSeguro(seguradoDao.buscarPorId(rs.getInt("fkIdSeguradoSeguro")));
            seguro.setVeiculoSeguro(veiculoDao.buscarPorId(rs.getInt("fkIdVeiculoSeguro")));
            
            return seguro;
        }
    }
}
