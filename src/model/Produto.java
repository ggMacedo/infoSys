
package model;

import DAO.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class Produto {
    private int codigo = 0;
    private String descricao;
    private int estoque;
    private boolean ativo;
    private double valor;
    private double custo;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;    
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
        
    }
    
    public Produto(int codigo, String descricao, int estoque, boolean ativo, double valor, double custo) {
        setCodigo(codigo);
        setDescricao(descricao);
        setEstoque(estoque);
        setAtivo(ativo);
        setValor(valor);
        setCusto(custo);
        
    }

    public Produto(String descricao, int estoque, boolean ativo, double valor, double custo) {
        setDescricao(descricao);
        setEstoque(estoque);
        setAtivo(ativo);
        setValor(valor);
        setCusto(custo);
        gravar();

    }
    
    
    private void gravar(){
        ProdutoDAO dao = new ProdutoDAO();
        int codigo = dao.create(this);
        if(codigo > 0) setCodigo(codigo);
        
    }
    
    public static DefaultTableModel getTableModel(){
        ProdutoDAO d = new ProdutoDAO();
        List<Produto> lista = d.read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Descrição");
        modelo.addColumn("Estoque");
        modelo.addColumn("Custo");
        modelo.addColumn("Valor");
        for(Produto c: lista){
            String [] reg = {String.valueOf(c.getCodigo()), String.valueOf(c.getDescricao()), String.valueOf(c.getEstoque()), String.valueOf(c.getCusto()), String.valueOf(c.getValor())};
            modelo.addRow(reg);
        }
        return modelo;   
    }
   
    @Override
    public String toString(){
        String ret = null;
        ret = "Descrição.: [" + getDescricao() + "]\n" + 
              "Estoque...: [" + getEstoque() + "]\n" + 
              "Ativo ?...: [" + isAtivo() + "]\n" + 
              "Valor.....: [" + getValor() + "]\n" + 
              "Custo.....: [" + getCusto() + "]\n";
        
        return ret;
    }   
    
    
    
    
}
