
package controller;

import Util.Configura;
import view.TelaCadastro;
import DAO.DBConnection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class Principal {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBConnection con = new DBConnection();
        try{
            Configura.LookAndFeel("Windows Classic");
            new TelaCadastro().setVisible(true);
            con.conectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
    

