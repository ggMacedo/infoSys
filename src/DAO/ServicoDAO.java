
package DAO;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Servico;
public class ServicoDAO implements Persistencia<Servico>{
    @Override
    public int create(Servico c){
        
        int id=0;
        DBConnection      db        = new DBConnection();
        Connection        con;
        PreparedStatement pst        = null;
        ResultSet rs = null;
        String            sqlString = "INSERT INTO Servicos(Nome, Descr, Tec, Val) VALUES (?, ?, ?, ?)";
        
        try{
            con = db.conectar();
            pst = con.prepareStatement(sqlString, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getDesc());
            pst.setString(3, c.getTec());
            pst.setDouble(4, c.getVal());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            con.close();
            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            id=0;
        }
        return id;  
    }
    
    @Override
    public List <Servico> read(){
        DBConnection      db        = new DBConnection();
        Connection        con;
        PreparedStatement pst        = null;
        ResultSet rs = null;
        String            sqlString = "SELECT * FROM Servicos ORDER BY CodServ";
        List lista = new ArrayList<Servico>();
        try{
           con = db.conectar();
           pst = con.prepareStatement(sqlString);
           rs = pst.executeQuery();
           while(rs.next()){
               int codigo = rs.getInt("CodServ");
               String nome = rs.getString("Nome");
               String descricao = rs.getString("Descr");
               String tec = rs.getString("Tec");
               double val = rs.getDouble("Val");
               lista.add(new Servico(codigo, nome, descricao, tec, val)); 
           }
           con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("ERRO no Select.");
            
        }
        return lista;
    }
    
    @Override
    public boolean update(Servico obj){
        throw new UnsupportedOperationException("Não implementado.");
    }
    
    @Override
    public boolean delete(Servico obj){
        throw new UnsupportedOperationException("Não implementado.");
    }
    
    @Override
    public Servico findByCodigo(int id){
        throw new UnsupportedOperationException("Não implementado.");
    }

    
    
}
