package project.controller;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
    private static final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jogo";
    private static final String USER = "root";
    private static final String PASSWORD = "neto0412";

    public ConexaoBancoDados() {

    }

    public static Connection conexaoBancoMySQL(){
        Connection connection = null;
        try{
            System.out.println("Carregando o driver do MySQL...");
            Class.forName(DRIVER_MYSQL);
            System.out.println("Driver carregado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro no carregamento do driver");
        }

        try{
            System.out.println("Conectando com o banco de dados...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem-sucedida");
        }catch (SQLException e){
            System.out.println("Não foi possível estabelecer conexão com o banco de dados");
            System.out.println("SQLException: " + e.getMessage() + "\n" + "SQLState: " + e.getSQLState() +
                    "\nVendorError: " + e.getErrorCode());
        }
        return connection;
    }

    public static void fazerConexao(){
        if(conexaoBancoMySQL() == null){
            conexaoBancoMySQL();
        }else{
            System.out.println("Já existe uma conexão em funcionamento");
        }
    }
}
