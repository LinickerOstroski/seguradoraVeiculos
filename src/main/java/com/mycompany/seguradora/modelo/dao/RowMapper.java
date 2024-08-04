/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seguradora.modelo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tulio
 */


public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}

/*

A interface RowMapper<T>  é um exemplo de um padrão de projeto comumente usado em frameworks de 
acesso a banco de dados, especialmente em Java. O propósito principal dessa interface é abstrair a maneira como os 
dados de um ResultSet (conjunto de resultados de uma consulta SQL) são mapeados para objetos de um tipo específico T. 
Isso é particularmente útil em frameworks como o Spring JDBC, onde RowMapper é extensivamente utilizado para converter 
as linhas retornadas de um banco de dados em objetos Java.

Estrutura e Uso da Interface RowMapper<T>
1. Definição da Interface:
A interface RowMapper é genérica com um parâmetro de tipo T. Isso significa que você pode definir mapeadores de 
linha que trabalhem com qualquer classe Java, fazendo com que o código seja reutilizável e adaptável a diferentes tipos de entidades ou dados.

2. Método mapRow:
O método mapRow é o único método na interface RowMapper e é responsável por converter uma linha do ResultSet em um 
objeto do tipo T. A interface é definida para lançar uma SQLException, o que indica que o método pode lidar com exceções SQL que podem ser lançadas enquanto se trabalha com o ResultSet.


T mapRow(ResultSet rs) throws SQLException;
Exemplo de Implementação
Imagine que você tem uma tabela de usuários em um banco de dados e uma classe User correspondente em Java. Aqui 
está como você poderia implementar a RowMapper para mapear linhas dessa tabela para instâncias da classe User:


public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        // mais atributos podem ser definidos aqui
        return user;
    }
}

Vantagens do Uso de RowMapper<T>
Desacoplamento: O uso de RowMapper ajuda a separar a lógica de acesso ao banco de dados da lógica de mapeamento de 
dados, tornando o código mais limpo e mais fácil de manter.
Reutilização: Uma vez que você define um RowMapper para um tipo específico, você pode reutilizá-lo em várias partes 
do seu código sempre que precisar mapear dados daquela tabela específica.
Flexibilidade: Você pode criar implementações específicas do RowMapper que podem incluir lógica complexa para lidar 
com casos especiais, conversões, etc., tudo isso enquanto mantém essa complexidade isolada do seu código principal 
de acesso a dados.
Este padrão é especialmente útil em cenários onde você deseja obter uma representação de objeto de dados recuperados 
de um banco de dados de maneira flexível e configurável, sem acoplar seu código de acesso a dados a um modelo de objeto 
específico.

*/