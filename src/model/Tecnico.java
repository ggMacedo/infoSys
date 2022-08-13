
package model;

import DAO.TecnicoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class Tecnico {
    private int codigo = 0;
    private String nome = null;
    private String cpf = null;
    private String telefone = null;
    private String celular = null;
    private String email = null;
    private String prof = null;
    private String Setor = null;

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

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    public Tecnico(String nome, String cpf, String fone, String celular, String email, String prof, String setor) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(fone);
        setCelular(celular);
        setEmail(email);
        setProf(prof);
        setSetor(setor);
        gravar();
      
    }
    
    public Tecnico(int codigo, String nome, String cpf, String fone, String celular, String email, String prof, String setor) {
        setCodigo(codigo);
        setNome(nome);
        setCpf(cpf);
        setTelefone(fone);
        setCelular(celular);
        setEmail(email);
        setProf(prof);
        setSetor(setor); 
    }
    
    private void gravar(){
        TecnicoDAO dao = new TecnicoDAO();
        int codigo = dao.create(this);
        if(codigo > 0) setCodigo(codigo);
        
    }
    
    public static DefaultTableModel getTableModel(){
        TecnicoDAO d = new TecnicoDAO();
        List<Tecnico> lista = d.read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        modelo.addColumn("Celular");
        modelo.addColumn("E-mail");
        modelo.addColumn("Profissão");
        modelo.addColumn("Setor");
        
        for(Tecnico c: lista){
            String [] reg = {c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail(), c.getProf(), c.getSetor()};
            modelo.addRow(reg);
        }
        return modelo;   
    }
    
    @Override
    public String toString(){
        String ret = null;
        ret = "Técnico....: [" + getNome() + "]\n" + 
              "CPF........: [" + getCpf() + "]\n" + 
              "Telefone...: [" + getTelefone() + "]\n" + 
              "Celular....: [" + getCelular() + "]\n" + 
              "E-mail.....: [" + getNome() + "]\n" +
              "Profissão..: [" + getProf() + "]\n" +
              "Setor......: [" + getSetor() + "]\n";
                
        return ret;
    }   
    
    
    
}
