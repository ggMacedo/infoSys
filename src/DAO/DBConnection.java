
package DAO;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    // atributos
    private final String servidor;
    private final String sgbd;
    private final String porta;
    private final String banco;
    private final String usuario;
    private final String senha;
    private final String strCnx;
    // construtor
    public DBConnection() {
        
        sgbd     = "mysql";
        servidor = "localhost";
        porta    = "3306";
        banco    = "InfoSysDB";
        usuario  = "root";
        senha    = "";
        strCnx   = "jdbc:" + sgbd +
                   "://"   + servidor +
                   ":"     + porta +
                   "/"     + banco;
    }    
    // retorna a conexao
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(strCnx, usuario, senha);
        
    }
}
    
