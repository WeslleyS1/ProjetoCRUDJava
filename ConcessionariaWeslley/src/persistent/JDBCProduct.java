/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistent;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author WeslleyS
 */
public class JDBCProduct {
    
    Connection conexao;

    public JDBCProduct(Connection conexao) {
        this.conexao = conexao;
    }

    public JDBCProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   public void inserirVeiculo(Veiculo v){
       String sql = "insert into veiculo(modelo, marca, ano, valor) values (?, ?, ?, ?)";
       PreparedStatement vs;
       
       try {
           vs = this.conexao.prepareStatement(sql);
           vs.setString(1, v.getModelo());
           vs.setString(2, v.getMarca());
           vs.setInt(3, v.getAno());
           vs.setInt(4, v.getValor());
           vs.execute();
       } catch (SQLException e){
           e.printStackTrace();
       }
   }
    
   public ArrayList<Veiculo> listarVeiculos(){
       ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
       String sql = "select * from veiculo";
       
       try {
           Statement declaração = conexao.createStatement();
           ResultSet resposta = declaração.executeQuery(sql);
           
           
           while(resposta.next()) {
               
               int id = resposta.getInt("id");
               String modelo = resposta.getString("modelo");
               String marca = resposta.getString("marca");
               int ano = resposta.getInt("ano");
               int valor = resposta.getInt("valor");
               
               Veiculo v = new Veiculo(id, modelo, marca, ano, valor);
               veiculos.add(v);
           }
                 
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return veiculos;    
   }

   public void apagarTudo(){
       String sql = "delete from veiculo";
       
       PreparedStatement vs;
       
       try{
           vs = this.conexao.prepareStatement(sql);
           vs.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   } 
}
