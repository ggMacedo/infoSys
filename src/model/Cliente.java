
package model;

import DAO.ClienteDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class Cliente {
    private int codigo = 0;
    private String nome = null;
    private String cpf = null;
    private String telefone = null;
    private String celular = null;
    private String email = null;
    
    public Cliente(String nome, String cpf, String fone, String celular, String email) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(fone);
        setCelular(celular);
        setEmail(email);
        gravar();

    }
    
    public Cliente(int codigo, String nome, String cpf, String fone, String celular, String email) {
        setCodigo(codigo);
        setNome(nome);
        setCpf(cpf);
        setTelefone(fone);
        setCelular(celular);
        setEmail(email);
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    private void gravar(){
        ClienteDAO dao = new ClienteDAO();
        int codigo = dao.create(this);
        if(codigo > 0) setCodigo(codigo);
        
    }
    
    public static DefaultTableModel getTableModel(){
        ClienteDAO d = new ClienteDAO();
        List<Cliente> lista = d.read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        modelo.addColumn("Celular");
        modelo.addColumn("E-mail");
        for(Cliente c: lista){
            String [] reg = {c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail()};
            modelo.addRow(reg);
        }
        return modelo;   
    }
    
    @Override
    public String toString(){
        String ret = null;
        ret = "Cliente.: [" + getNome() + "]\n" + 
              "CPF.....: [" + getCpf() + "]\n" + 
              "Telefone: [" + getTelefone() + "]\n" + 
              "Celular.: [" + getCelular() + "]\n" + 
              "E-mail..: [" + getEmail() + "]\n";
        
        return ret;
    }   
}
