package com.mycompany.seguradora.modelo.dao;

import com.mycompany.seguradora.modelo.entidade.Veiculo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class VeiculoDao extends GenericoDao<Veiculo>{
    
    public void salvar(Veiculo v){
        String insert = "INSERT INTO VEICULO(PLACA,MARCA,MODELO,ANO,CHASSI,CAPACIDADE,CATEGORIA,COR,FIPE) VALUES (?,?,?,?,?,?,?,?,?)";
        save(insert, v.getPlacaVeiculo(),v.getMarcaVeiculo(),v.getModeloVeiculo(),v.getAnoVeiculo(),v.getChassiVeiculo(),v.getCapacidadeVeiculo(),
                v.getCategoriaVeiculo(),v.getCorVeiculo(), v.getFipeVeiculo());
    }
    
    public void alterar(Veiculo v){
        String update = "UPDATE VEICULO SET PLACA=?,MARCA=?, MODELO=?, ANO=?, CHASSI=?, CAPACIDADE=?,CATEGORIA=?, COR=?, FIPE=? WHERE idVeiculo=?";
        save(update, v.getPlacaVeiculo(),v.getMarcaVeiculo(),v.getModeloVeiculo(),v.getAnoVeiculo(),v.getChassiVeiculo(),v.getCapacidadeVeiculo(),
                v.getCategoriaVeiculo(),v.getCorVeiculo(), v.getFipeVeiculo(), v.getIdVeiculo());
    }
    
    public void excluir(Veiculo v){
        String delete="DELETE FROM VEICULO WHERE idVeiculo=?";
        save(delete, v.getIdVeiculo());
    }
    
    public Veiculo buscarPorId(int id){
        String select = "SELECT * FROM VEICULO WHERE idVeiculo=?";
        return buscarPorId(select, new VeiculoRowMapper(), id);
    }
    
    public List<Veiculo> buscarTodas(){
         String select = "SELECT * FROM VEICULO";
        return buscarTodos(select, new VeiculoRowMapper());
    }
    
    public static class VeiculoRowMapper implements RowMapper<Veiculo>{

        @Override
        public Veiculo mapRow(ResultSet rs) throws SQLException {
            Veiculo veiculo = new Veiculo();
            veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
            veiculo.setPlacaVeiculo(rs.getString("PLACA"));
            veiculo.setMarcaVeiculo(rs.getString("MARCA"));
            veiculo.setModeloVeiculo(rs.getString("MODELO"));
            veiculo.setAnoVeiculo(rs.getString("ANO"));
            veiculo.setChassiVeiculo(rs.getString("CHASSI"));
            veiculo.setCapacidadeVeiculo(rs.getString("CAPACIDADE"));
            veiculo.setCategoriaVeiculo(rs.getString("CATEGORIA"));
            veiculo.setCorVeiculo(rs.getString("COR"));
            veiculo.setFipeVeiculo(rs.getDouble("FIPE"));
            return veiculo;
        }
        
    }
    
}
