package br.com.sapataria.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class BDConfig {
 
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque_db?useTimezone=true&serverTimezone=UTC", "root", "root");
    }
    
}