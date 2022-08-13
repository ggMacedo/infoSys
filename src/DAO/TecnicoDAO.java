
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
import model.Tecnico;
public class TecnicoDAO implements Persistencia<Tecnico>{
    
    @Override
    public int create(Tecnico c){
        
        int id=0;
        DBConnection      db        = new DBConnection();
        Connection        con;
        PreparedStatement pst        = null;
        ResultSet rs = null;
        String            sqlString = "INSERT INTO Tecnicos(Nome, CPF, Fone, Celular, Email, Prof, Setor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            con = db.conectar();
            pst = con.prepareStatement(sqlString, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCpf());
            pst.setString(3, c.getTelefone());
            pst.setString(4, c.getCelular());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getProf());
            pst.setString(7, c.getSetor());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            con.close();
            JOptionPane.showMessageDialog(null, "Técnico cadastrado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            id=0;
        }
        return id;  
    }
    
    @Override
    public List <Tecnico> read(){
        DBConnection      db        = new DBConnection();
        Connection        con;
        PreparedStatement pst        = null;
        ResultSet rs = null;
        String            sqlString = "SELECT * FROM Tecnicos ORDER BY Nome";
        List lista = new ArrayList<Tecnico>();
        try{
           con = db.conectar();
           pst = con.prepareStatement(sqlString);
           rs = pst.executeQuery();
           while(rs.next()){
               int codigo = rs.getInt("Cod");
               String nome = rs.getString("Nome");
               String cpf = rs.getString("CPF");
               String fone = rs.getString("Fone");
               String celular = rs.getString("Celular");
               String email = rs.getString("Email");
               String profissao = rs.getString("Prof");
               String setor = rs.getString("Setor");
               lista.add(new Tecnico(codigo, nome, cpf, fone, celular, email, profissao, setor)); 
           }
           con.close();
          
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("ERRO no Select.");
            
        }
        return lista;
        
    }
    
    @Override
    public boolean update(Tecnico obj){
        throw new UnsupportedOperationException("Não implementado.");
    }
    
    @Override
    public boolean delete(Tecnico obj){
        throw new UnsupportedOperationException("Não implementado.");
    }
    
    @Override
    public Tecnico findByCodigo(int id){
        throw new UnsupportedOperationException("Não implementado.");
    }
}
