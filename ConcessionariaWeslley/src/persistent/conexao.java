/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WeslleyS
 */
public class conexao {
    
    private Connection conexao;
    
    public Connection abrirConexão() {
        String url = "jdbc:mysql://localhost:3306/concessionaria?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";
        
        try {
            conexao = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return conexao;
    }
    
    public void fecharConexão() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

