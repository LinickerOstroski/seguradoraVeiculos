/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seguradora.modelo.dao;


import com.mycompany.seguradora.modelo.entidade.Funcionario;
import com.mycompany.seguradora.servico.ConverteData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tulio
 */
public class FuncionarioDao extends GenericoDao<Funcionario> {
    
     
    public void salvar(Funcionario c){
        String insert = "INSERT INTO FUNCIONARIO(NOME,SALARIO,NASCIMENTO,CIDADE) VALUES (?,?,?,?)";
        save(insert, c.getNomeFuncionario(), c.getSalarioFuncionario(), c.getNascimentoFuncionario(),c.getCidadeFuncionario().getCodigoCidade());
    }
    
    public void alterar(Funcionario c){
        String update = "UPDATE FUNCIONARIO SET NOME=?,SALARIO=?,NASCIMENTO=?,CIDADE=? WHERE CODIGO=?";
        save(update,c.getNomeFuncionario(),  c.getSalarioFuncionario(), c.getNascimentoFuncionario(),c.getCidadeFuncionario().getCodigoCidade(),c.getCodigoFuncionario());
    }
    
    public void excluir(Funcionario c){
        String delete="DELETE FROM FUNCIONARIO WHERE CODIGO=?";
        save(delete, c.getCodigoFuncionario());
    }
    
    public Funcionario buscarPorId(int id){
        String select = "SELECT * FROM FUNCIONARIO WHERE CODIGO=?";
        return buscarPorId(select, new FuncionarioRowMapper(), id);
    }
    
    public List<Funcionario> buscarTodas(){
         String select = "SELECT * FROM FUNCIONARIO";
        return buscarTodos(select, new FuncionarioRowMapper());
    }
    
    public static class FuncionarioRowMapper implements RowMapper<Funcionario>{
       ConverteData converte = new ConverteData();
       CidadeDao cidadeDao = new CidadeDao();
        @Override
        public Funcionario mapRow(ResultSet rs) throws SQLException {
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigoFuncionario(rs.getInt("CODIGO"));
            funcionario.setNomeFuncionario(rs.getString("NOME"));
            funcionario.setSalarioFuncionario(rs.getDouble("SALARIO"));
            funcionario.setNascimentoFuncionario(converte.converteCalendario(rs.getDate("NASCIMENTO")));
            funcionario.setCidadeFuncionario(cidadeDao.buscarPorId(rs.getInt("CIDADE")));
            return funcionario;
        }
        
    }
    
}
