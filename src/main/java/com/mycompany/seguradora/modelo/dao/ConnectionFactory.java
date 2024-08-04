/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seguradora.modelo.dao;



/**
 *
 * @author tulio
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/estudocaso3sistema?useSSL=false&serverTimezone=UTC";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin";
    // Variável estática que mantém a instância única da ConnectionFactory.
    private static ConnectionFactory instance;

    /*O construtor é privado para impedir a criação direta de instâncias da classe fora dela mesma. 
    Dentro do construtor, o driver JDBC é carregado usando Class.forName(DB_DRIVER). 
    Se o driver não for encontrado, uma exceção ClassNotFoundException é capturada e uma nova RuntimeException 
    é lançada, indicando que o driver do banco de dados não foi encontrado.*/
    private ConnectionFactory() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do banco de dados não encontrado.", e);
        }
    }
/*
 public static ConnectionFactory getInstance(): Método público estático que permite o acesso à instância única 
 da ConnectionFactory. Se instance é null (ou seja, se ainda não foi criada), uma nova instância é criada e 
 retornada. Isso garante que apenas uma instância da ConnectionFactory seja usada em toda a aplicação, 
 seguindo o padrão Singleton.   
    */
    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }
/*
    public Connection getConnection() throws SQLException: Método que usa DriverManager.getConnection() 
    com as constantes de URL, usuário e senha para criar e retornar uma nova conexão com o banco de dados. 
    Este método pode lançar uma SQLException se a conexão não puder ser estabelecida.
    */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
/*public PreparedStatement getPreparedStatement(String sql) throws SQLException: Método que obtém uma conexão 
    chamando getConnection() e cria um PreparedStatement para executar uma consulta SQL. O argumento sql 
    é a consulta que será preparada. O método configura o PreparedStatement para retornar chaves geradas 
    automaticamente, o que é útil em operações de inserção onde você pode querer recuperar IDs gerados pelo 
    banco de dados após a inserção de registros.*/
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection con = getConnection();
        return con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    }
}

/*
Uso e Benefícios
Gerenciamento Centralizado de Conexões: Com esta classe, todas as operações que necessitam de uma conexão 
com o banco de dados passam pelo mesmo ponto, facilitando a manutenção e eventuais alterações nas configurações de conexão.
Padrão Singleton: A implementação garante que a sobrecarga de criação de instâncias múltiplas seja evitada e que recursos
sejam gerenciados de forma mais eficiente.
Segurança e Manutenção: Ao encapsular a lógica de conexão, a classe ajuda a evitar erros comuns e facilita a atualização 
de credenciais ou detalhes do driver em um único local.
Essa classe é um exemplo típico de como gerenciar conexões de banco de dados em aplicações Java, seguindo boas práticas 
de design de software.

*/
