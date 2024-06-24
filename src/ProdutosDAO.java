/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    conectaDAO conexao = new conectaDAO();
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
       try{
           conexao.conectar();
           String sql = "INSERT INTO produtos (nome, valor, status) values (?, ?, ?)";
           PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
           stmt.setString(1, produto.getNome());
           stmt.setInt(2, produto.getValor());
           stmt.setString(3, produto.getStatus());
           
           int verificacao = stmt.executeUpdate();
           if(verificacao > 0){
               JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO.");
           }else{
               JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR PRODUTO.", "Erro", JOptionPane.ERROR_MESSAGE);
           }
           
           

       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro : " + e.getMessage());
       }finally{
           conexao.desconectar();
       }
        
       
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

