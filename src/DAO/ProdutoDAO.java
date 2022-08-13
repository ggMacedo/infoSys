
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
import model.Produto;
public class ProdutoDAO implements Persistencia<Produto>{
    @Override
    public int create(Produto c){
        
        int id=0;
        DBConnection      db        = new DBConnection();
        Connection        con;
        PreparedStatement pst        = null;
        ResultSet rs = null;
        String            sqlString = "INSERT INTO Produtos(Descr, Estoque, Ativo, Custo, Venda) VALUES (?, ?, ?, ?, ?)";
        
        try{
            con = db.conectar();
            pst = con.prepareStatement(sqlString, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getDescricao());
            pst.setInt(2, c.getEstoque());
            pst.setBoolean(3, c.isAtivo());
            pst.setDouble(4, c.getCusto());
            pst.setDouble(5, c.getValor());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            con.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            id=0;
        }
        return id;  
    }
    
    @Override
    public List <Produto> read(){
        DBConnection      db        = new DBConnection();
        Connection        con;
        PreparedStatement pst        = null;
        ResultSet rs = null;
        String            sqlString = "SELECT * FROM Produtos ORDER BY CodProd";
        List lista = new ArrayList<Produto>();
        try{
           con = db.conectar();
           pst = con.prepareStatement(sqlString);
           rs = pst.executeQuery();
           while(rs.next()){
               int codigo = rs.getInt("CodProd");
               String descricao = rs.getString("Descr");
               int estoque = rs.getInt("Estoque");
               boolean ativo = rs.getBoolean("Ativo");
               double custo = rs.getDouble("Custo");
               double venda = rs.getDouble("Venda");
               lista.add(new Produto(codigo, descricao, estoque, ativo, custo, venda)); 
           }
           con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("ERRO no Select.");
            
        }
        return lista;
    }
    
    @Override
    public boolean update(Produto obj){
        throw new UnsupportedOperationException("Não implementado.");
    }
    
    @Override
    public boolean delete(Produto obj){
        throw new UnsupportedOperationException("Não implementado.");
    }
    
    @Override
    public Produto findByCodigo(int id){
        throw new UnsupportedOperationException("Não implementado.");
    }

    
    
}
