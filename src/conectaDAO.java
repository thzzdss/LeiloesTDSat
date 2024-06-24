
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
public class conectaDAO {

    Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public final boolean conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "Thzinho#@!#@!");
            return true;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("CLASSE INEXISTENTE.");
        } catch (SQLException se) {
            System.out.println("ERRO AO CONECTAR NO BANCO DE DADOS.");
            
        }
        return false;
    }

    public final void desconectar() {
        try {
            if (conexao != null) {
                conexao.close();

            } else {
                System.out.println("O BANCO DE DADOS JA ESTA FECHADO.");
            }
        } catch (SQLException se) {
            System.out.println("ERRO AO FECHAR O BANCO DE DADOS.");
        }

    }

}
