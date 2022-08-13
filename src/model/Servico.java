
package model;

import javax.swing.table.DefaultTableModel;
import DAO.ServicoDAO;
import java.util.List;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class Servico {
    private int codigo = 0;
    private String nome = null;
    private String desc = null;
    private String tec = null;
    private double val = 0;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTec() {
        return tec;
    }

    public void setTec(String tec) {
        this.tec = tec;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
    
    public Servico(String nome, String desc, String tec, double val) {
        setNome(nome);
        setDesc(desc);
        setTec(tec);
        setVal(val);
        gravar();
      
    }
    
    public Servico(int codigo, String nome, String desc, String tec, double val) {
        setCodigo(codigo);
        setNome(nome);
        setDesc(desc);
        setTec(tec);
        setVal(val);
    }
    
    private void gravar(){
        ServicoDAO dao = new ServicoDAO();
        int codigo = dao.create(this);
        if(codigo > 0) setCodigo(codigo);
        
    }
    
    public static DefaultTableModel getTableModel(){
        ServicoDAO d = new ServicoDAO();
        List<Servico> lista = d.read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        modelo.addColumn("Técnico");
        modelo.addColumn("Valor");
        
        for(Servico c: lista){
            String [] reg = {c.getNome(), c.getDesc(), c.getTec(), String.valueOf(c.getVal())};
            modelo.addRow(reg);
        }
        return modelo;   
    }
    
    @Override
    public String toString(){
        String ret = null;
        ret = "Serviço....: [" + getNome() + "]\n" + 
              "Descrição........: [" + getDesc()+ "]\n" + 
              "Técnico...: [" + getTec() + "]\n" + 
              "Valor....: [" + getVal() + "]\n";
 
                
        return ret;
    }   
    
    
    

    
}
