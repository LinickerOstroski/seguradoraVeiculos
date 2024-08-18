package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.entidade.Sinistro;
import com.mycompany.seguradora.servico.ConverteData;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class SinistroDao extends GenericoDao<Sinistro> {
    
     public void salvar(Sinistro s) {
        String insert = "INSERT INTO SINISTRO(dataOcorrenciaSinistro,descricaoSinistro, valorReparacaoSinistro, fkIdSeguroSinistro) VALUES (?, ?, ?, ?)";
        save(insert, s.getDataOcorrenciaSinistro(),s.getDescricaoSinistro(),s.getValorReparacaoSinistro(),s.getSeguroSinistro().getIdSeguro());
    }
    
    public void alterar(Sinistro s) {
        String update = "UPDATE SINISTRO SET dataOcorrenciaSinistro = ?, descricaoSinistro = ?, valorReparacaoSinistro = ?, fkIdSeguroSinistro = ? WHERE idSinistro=?";
        save(update, convertCalendarToSqlDate(s.getDataOcorrenciaSinistro()),s.getDescricaoSinistro(), s.getValorReparacaoSinistro(), s.getSeguroSinistro().getIdSeguro());
    }

    public void excluir(Sinistro s) {
        String delete = "DELETE FROM SINISTRO WHERE idSinistro=?";
        save(delete, s.getIdSinistro());
    }
    
    public Sinistro buscarPorId(int id) {
        String select = "SELECT * FROM SINISTRO WHERE idSinistro=?";
        return buscarPorId(select, new SeguradoRowMapper(), id);
    }

    public List<Sinistro> buscarTodos() {
        String select = "SELECT * FROM SINISTRO";
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
    
    public static class SeguradoRowMapper implements RowMapper<Sinistro> {

        ConverteData converte = new ConverteData();

        @Override
        public Sinistro mapRow(ResultSet rs) throws SQLException {
            Sinistro sinistro = new Sinistro();
            SeguroDao seguroDao = new SeguroDao();

            sinistro.setIdSinistro(rs.getInt("idSinistro"));
            sinistro.setDataOcorrenciaSinistro(converte.converteCalendario(rs.getDate("dataOcorrenciaSinistro")));
            sinistro.setDescricaoSinistro(rs.getString("descricaoSinistro"));
            sinistro.setValorReparacaoSinistro(rs.getDouble("valorReparacaoSinistro"));
            sinistro.setSeguroSinistro(seguroDao.buscarPorId(rs.getInt("fkIdSeguroSinistro")));
            
            return sinistro;
        }
    }
}
