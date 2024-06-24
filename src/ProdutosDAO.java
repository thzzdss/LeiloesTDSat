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

    PreparedStatement stmt = null;
    ResultSet rs = null;
    conectaDAO conexao = new conectaDAO();
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        try {
            conexao.conectar();
            String sql = "INSERT INTO produtos (nome, valor, status) values (?, ?, ?)";
            stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());

            int verificacao = stmt.executeUpdate();
            if (verificacao > 0) {
                JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO.");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR PRODUTO.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e.getMessage());
        } finally {
            conexao.desconectar();
        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        try {
            conexao.conectar();

            String sql = "SELECT * FROM produtos";
            stmt = conexao.getConexao().prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                listagem.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }
        return listagem;
    }

}
