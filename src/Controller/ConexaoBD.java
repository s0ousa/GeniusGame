package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {

    public Connection conectaBD () {
    	
    	Connection conn= null;
    	try {
    		
    		String url="jdbc:sqlite:BancoGeniusGame.db";
    		
    		conn=DriverManager.getConnection(url);
			
		} catch (SQLException erro) {
			
			 JOptionPane.showMessageDialog(null, "  ConexaoDAO  " + erro.getMessage());
		}
    	
    	return conn;
    }

    public static void main(String[] args) {
        ConexaoBD conexaoBD = new ConexaoBD();

        // Teste de conexão
        Connection conn = conexaoBD.conectaBD();
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados.");
        }

        // Fechando a conexão
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
        }
    }

}