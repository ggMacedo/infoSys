/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Cliente;
import model.Produto;
import Util.Mascaras;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.PlainDocument;
import model.Servico;
import model.Tecnico;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class TelaCadastro extends javax.swing.JFrame {
    private int telaH = 0;
    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    
    public static boolean validarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    /**
     * Creates new form TelaCadastro
     */
    
   
    public TelaCadastro() {
        initComponents();
        setMask();
        setLocationRelativeTo(this);
        setResizable(false);
        jsEstoque.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        txtNome.requestFocus();
    }
    
    private void limpaCliente(){
        txtNome.setText("");
        txtCPF.setText("");
        txtTel.setText("");
        txtCell.setText("");
        txtEmail.setText("");
        txtNome.requestFocus();
    }
    
    private void gravaCliente(){
        try{
          
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();
            String tel = txtTel.getText();
            String cell = txtCell.getText();
            String email = txtEmail.getText();
            
            if(nome.trim().equals("") ||cpf.trim().equals("") || cpf.equals("___.___.___-__") || tel.trim().equals("") || tel.equals("(__) ____-____") || cell.trim().equals("") || cell.equals("(__) _ ____-____") || email.trim().equals("")){
                JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }else if(!validarEmail(email)){
                JOptionPane.showMessageDialog(null, "Digite um E-mail válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                new Cliente(nome, cpf, tel, cell, email);
                limpaCliente();
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparProduto(){
        txtDes.setText("");
        jsEstoque.setValue(0);
        cbAtivo.setSelected(true);
        txtCusto.setText("0");
        txtVenda.setText("0");
        txtDes.requestFocus();
    }
    
    private void gravarProduto(){
        try{
            String descricao = txtDes.getText();
            int estoque = (int) jsEstoque.getValue();
            double custo = Double.parseDouble(txtCusto.getText());
            double venda = Double.parseDouble(txtVenda.getText());
            
            if(descricao.trim().equals("")){
                JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                new Produto(descricao, estoque, true, custo, venda);
                limparProduto();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpaTec(){
        txtNomeTec.setText("");
        txtCPFTec.setText("");
        txtTellTec.setText("");
        txtCellTec.setText("");
        txtEmailTec.setText("");
        txtProfTec.setText("");
        txtSetorTec.setText("");
        txtNomeTec.requestFocus();
    }
    
    private void gravaTec(){

        try{
            String nome = txtNomeTec.getText();
            String cpf = txtCPFTec.getText();
            String tel = txtTellTec.getText();
            String cell = txtCellTec.getText();
            String email = txtEmailTec.getText();
            String profissao = txtProfTec.getText();
            String setor = txtSetorTec.getText();
            
            
            if(nome.trim().equals("") || cpf.trim().equals("") || cpf.equals("___.___.___-__") || tel.trim().equals("") || tel.equals("(__) ____-____") || cell.trim().equals("") || cell.equals("(__) _ ____-____") || email.trim().equals("") || profissao.trim().equals("") || setor.trim().equals("")){
                JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }else if(!validarEmail(email)){
                JOptionPane.showMessageDialog(null, "Digite um E-mail válido!", "Erro", JOptionPane.ERROR_MESSAGE);   
            }else{
                new Tecnico(nome, cpf, tel, cell, email, profissao, setor);
                limpaTec();
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpaServ(){
        txtNomeServico.setText("");
        txtDescServico.setText("");
        txtTecServico.setText("");
        txtValorServico.setText("0");
        txtNomeServico.requestFocus();
    }
    
    private void gravaServ(){
        try{
            String nome = txtNomeServico.getText();
            String desc = txtDescServico.getText();
            String tec = txtTecServico.getText();
            double val = Double.parseDouble(txtValorServico.getText());
            if(nome.trim().equals("") || desc.trim().equals("") || tec.trim().equals("")){
                JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                new Servico(nome, desc, tec, val);
                limpaServ();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setMask(){
        Mascaras mascara = new Mascaras();
        txtCPF.setFormatterFactory(mascara.getCpfMask());
        txtTel.setFormatterFactory(mascara.getFoneMask());
        txtCell.setFormatterFactory(mascara.getCellMask());
        txtCPFTec.setFormatterFactory(mascara.getCpfMask());
        txtTellTec.setFormatterFactory(mascara.getFoneMask());
        txtCellTec.setFormatterFactory(mascara.getCellMask());
        txtCusto.setFormatterFactory(mascara.getValorMask());
        txtVenda.setFormatterFactory(mascara.getValorMask());
        txtValorServico.setFormatterFactory(mascara.getValorMask());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        pnButtons = new javax.swing.JPanel();
        btGrvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btConsulta = new javax.swing.JButton();
        tbTela = new javax.swing.JTabbedPane();
        pnClientes = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        lbTel = new javax.swing.JLabel();
        lbCell = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtTel = new javax.swing.JFormattedTextField();
        txtCell = new javax.swing.JFormattedTextField();
        pnProdutos = new javax.swing.JPanel();
        lbDes = new javax.swing.JLabel();
        txtDes = new javax.swing.JTextField();
        lbEstoque = new javax.swing.JLabel();
        jsEstoque = new javax.swing.JSpinner();
        cbAtivo = new javax.swing.JCheckBox();
        pnPreco = new javax.swing.JPanel();
        lbCusto = new javax.swing.JLabel();
        lbVenda = new javax.swing.JLabel();
        txtCusto = new javax.swing.JFormattedTextField();
        txtVenda = new javax.swing.JFormattedTextField();
        pnServicos = new javax.swing.JPanel();
        lbNomeServico = new javax.swing.JLabel();
        lbDescServico = new javax.swing.JLabel();
        lbTecServico = new javax.swing.JLabel();
        lbValorServico = new javax.swing.JLabel();
        txtNomeServico = new javax.swing.JTextField();
        txtDescServico = new javax.swing.JTextField();
        txtTecServico = new javax.swing.JTextField();
        txtValorServico = new javax.swing.JFormattedTextField();
        pnTecnicos = new javax.swing.JPanel();
        lbNomeTec = new javax.swing.JLabel();
        lbCpfTec = new javax.swing.JLabel();
        lbCellTec = new javax.swing.JLabel();
        lbTellTec = new javax.swing.JLabel();
        lbEmailTec = new javax.swing.JLabel();
        lbProfTec = new javax.swing.JLabel();
        lbSetorTec = new javax.swing.JLabel();
        txtCPFTec = new javax.swing.JFormattedTextField();
        txtCellTec = new javax.swing.JFormattedTextField();
        txtTellTec = new javax.swing.JFormattedTextField();
        txtNomeTec = new javax.swing.JTextField();
        txtEmailTec = new javax.swing.JTextField();
        txtProfTec = new javax.swing.JTextField();
        txtSetorTec = new javax.swing.JTextField();
        lbAutor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastros");

        pnTitulo.setBackground(new java.awt.Color(255, 255, 255));
        pnTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lbTitulo.setText("Cadastro");
        pnTitulo.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N
        pnTitulo.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        pnButtons.setBackground(new java.awt.Color(204, 204, 204));
        pnButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btGrvar.setBackground(new java.awt.Color(255, 255, 255));
        btGrvar.setForeground(new java.awt.Color(0, 0, 0));
        btGrvar.setText("Gravar");
        btGrvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrvarActionPerformed(evt);
            }
        });

        btLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btLimpar.setForeground(new java.awt.Color(0, 0, 0));
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btConsulta.setBackground(new java.awt.Color(255, 255, 255));
        btConsulta.setForeground(new java.awt.Color(0, 0, 0));
        btConsulta.setText("Consultar");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnButtonsLayout = new javax.swing.GroupLayout(pnButtons);
        pnButtons.setLayout(pnButtonsLayout);
        pnButtonsLayout.setHorizontalGroup(
            pnButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnButtonsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btGrvar)
                .addGap(18, 18, 18)
                .addComponent(btLimpar)
                .addGap(12, 12, 12))
        );
        pnButtonsLayout.setVerticalGroup(
            pnButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnButtonsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGrvar)
                    .addComponent(btLimpar)
                    .addComponent(btConsulta))
                .addGap(20, 20, 20))
        );

        tbTela.setBackground(new java.awt.Color(255, 255, 255));
        tbTela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbTela.setForeground(new java.awt.Color(0, 0, 0));

        pnClientes.setToolTipText("Clientes");

        lblNome.setText("Nome:");

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lbCPF.setText("CPF:");

        lbTel.setText("Telefone:");

        lbCell.setText("Celular:");

        lbEmail.setText("E-mail:");

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));

        txtCPF.setBackground(new java.awt.Color(255, 255, 255));
        txtCPF.setForeground(new java.awt.Color(0, 0, 0));

        txtTel.setBackground(new java.awt.Color(255, 255, 255));
        txtTel.setForeground(new java.awt.Color(0, 0, 0));

        txtCell.setBackground(new java.awt.Color(255, 255, 255));
        txtCell.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnClientesLayout = new javax.swing.GroupLayout(pnClientes);
        pnClientes.setLayout(pnClientesLayout);
        pnClientesLayout.setHorizontalGroup(
            pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnClientesLayout.createSequentialGroup()
                        .addComponent(lbCell)
                        .addGap(21, 21, 21)
                        .addComponent(txtCell))
                    .addGroup(pnClientesLayout.createSequentialGroup()
                        .addComponent(lbEmail)
                        .addGap(24, 24, 24)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnClientesLayout.createSequentialGroup()
                        .addComponent(lbTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTel))
                    .addGroup(pnClientesLayout.createSequentialGroup()
                        .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCPF)
                            .addComponent(lblNome))
                        .addGap(24, 24, 24)
                        .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtCPF))))
                .addGap(34, 34, 34))
        );
        pnClientesLayout.setVerticalGroup(
            pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClientesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(17, 17, 17)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTel)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCell)
                    .addComponent(txtCell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        tbTela.addTab("Clientes", pnClientes);
        pnClientes.getAccessibleContext().setAccessibleName("Clienets");

        lbDes.setText("Descrição:");

        txtDes.setBackground(new java.awt.Color(255, 255, 255));
        txtDes.setForeground(new java.awt.Color(0, 0, 0));

        lbEstoque.setText("Estoque:");

        cbAtivo.setSelected(true);
        cbAtivo.setText("Ativo");

        pnPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço"));

        lbCusto.setText("Custo:");

        lbVenda.setText("Venda:");

        txtCusto.setBackground(new java.awt.Color(255, 255, 255));
        txtCusto.setForeground(new java.awt.Color(0, 0, 0));

        txtVenda.setBackground(new java.awt.Color(255, 255, 255));
        txtVenda.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnPrecoLayout = new javax.swing.GroupLayout(pnPreco);
        pnPreco.setLayout(pnPrecoLayout);
        pnPrecoLayout.setHorizontalGroup(
            pnPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCusto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(lbVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        pnPrecoLayout.setVerticalGroup(
            pnPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrecoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCusto)
                    .addComponent(lbVenda)
                    .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnProdutosLayout = new javax.swing.GroupLayout(pnProdutos);
        pnProdutos.setLayout(pnProdutosLayout);
        pnProdutosLayout.setHorizontalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProdutosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnProdutosLayout.createSequentialGroup()
                                .addComponent(lbDes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnProdutosLayout.createSequentialGroup()
                                .addComponent(lbEstoque)
                                .addGap(32, 32, 32)
                                .addComponent(jsEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(cbAtivo))))
                    .addGroup(pnProdutosLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(pnPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnProdutosLayout.setVerticalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDes)
                    .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstoque)
                    .addComponent(jsEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAtivo))
                .addGap(18, 18, 18)
                .addComponent(pnPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        tbTela.addTab("Produtos", pnProdutos);

        lbNomeServico.setText("Nome do serviço:");

        lbDescServico.setText("Descrição do serviço:");

        lbTecServico.setText("Técnico que executou o serviço:");

        lbValorServico.setText("Valor do serviço:");

        txtNomeServico.setBackground(new java.awt.Color(255, 255, 255));
        txtNomeServico.setForeground(new java.awt.Color(0, 0, 0));

        txtDescServico.setBackground(new java.awt.Color(255, 255, 255));
        txtDescServico.setForeground(new java.awt.Color(0, 0, 0));
        txtDescServico.setToolTipText("");

        txtTecServico.setBackground(new java.awt.Color(255, 255, 255));
        txtTecServico.setForeground(new java.awt.Color(0, 0, 0));

        txtValorServico.setBackground(new java.awt.Color(255, 255, 255));
        txtValorServico.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnServicosLayout = new javax.swing.GroupLayout(pnServicos);
        pnServicos.setLayout(pnServicosLayout);
        pnServicosLayout.setHorizontalGroup(
            pnServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnServicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnServicosLayout.createSequentialGroup()
                        .addComponent(lbValorServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorServico))
                    .addGroup(pnServicosLayout.createSequentialGroup()
                        .addComponent(lbNomeServico)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeServico))
                    .addGroup(pnServicosLayout.createSequentialGroup()
                        .addComponent(lbTecServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTecServico, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                    .addGroup(pnServicosLayout.createSequentialGroup()
                        .addComponent(lbDescServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescServico)))
                .addContainerGap())
        );
        pnServicosLayout.setVerticalGroup(
            pnServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnServicosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeServico)
                    .addComponent(txtNomeServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescServico)
                    .addComponent(txtDescServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTecServico)
                    .addComponent(txtTecServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValorServico)
                    .addComponent(txtValorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        tbTela.addTab("Serviços", pnServicos);

        pnTecnicos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNomeTec.setText("Nome:");
        pnTecnicos.add(lbNomeTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, -1));

        lbCpfTec.setText("CPF:");
        pnTecnicos.add(lbCpfTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, -1, -1));

        lbCellTec.setText("Celular:");
        pnTecnicos.add(lbCellTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, -1, -1));

        lbTellTec.setText("Telefone:");
        pnTecnicos.add(lbTellTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 93, -1, -1));

        lbEmailTec.setText("E-mail:");
        pnTecnicos.add(lbEmailTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 127, -1, -1));

        lbProfTec.setText("Profissão:");
        pnTecnicos.add(lbProfTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 161, -1, -1));

        lbSetorTec.setText("Setor:");
        pnTecnicos.add(lbSetorTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 195, -1, -1));

        txtCPFTec.setBackground(new java.awt.Color(255, 255, 255));
        txtCPFTec.setForeground(new java.awt.Color(0, 0, 0));
        pnTecnicos.add(txtCPFTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 34, 490, -1));

        txtCellTec.setBackground(new java.awt.Color(255, 255, 255));
        txtCellTec.setForeground(new java.awt.Color(0, 0, 0));
        pnTecnicos.add(txtCellTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 62, 492, -1));

        txtTellTec.setBackground(new java.awt.Color(255, 255, 255));
        txtTellTec.setForeground(new java.awt.Color(0, 0, 0));
        pnTecnicos.add(txtTellTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 490, -1));

        txtNomeTec.setBackground(new java.awt.Color(255, 255, 255));
        txtNomeTec.setForeground(new java.awt.Color(0, 0, 0));
        pnTecnicos.add(txtNomeTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 6, 490, -1));

        txtEmailTec.setBackground(new java.awt.Color(255, 255, 255));
        txtEmailTec.setForeground(new java.awt.Color(0, 0, 0));
        pnTecnicos.add(txtEmailTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 124, 495, -1));

        txtProfTec.setBackground(new java.awt.Color(255, 255, 255));
        txtProfTec.setForeground(new java.awt.Color(0, 0, 0));
        pnTecnicos.add(txtProfTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 158, 487, -1));

        txtSetorTec.setBackground(new java.awt.Color(255, 255, 255));
        txtSetorTec.setForeground(new java.awt.Color(0, 0, 0));
        pnTecnicos.add(txtSetorTec, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 192, 508, -1));

        tbTela.addTab("Técnicos", pnTecnicos);

        lbAutor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbAutor.setForeground(new java.awt.Color(0, 0, 0));
        lbAutor.setText("Gabriel Gomes Macedo N6598A-4 CC4P33");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbTela)
                    .addComponent(pnTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbAutor)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbTela, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAutor)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        if(tbTela.getSelectedComponent() == pnClientes){
            limpaCliente();
        }else if(tbTela.getSelectedComponent() == pnProdutos){
            limparProduto();
        }else if(tbTela.getSelectedComponent() == pnTecnicos){
            limpaTec();
        }else if(tbTela.getSelectedComponent() == pnServicos){
            limpaServ();
        }
        
    }//GEN-LAST:event_btLimparActionPerformed

    private void btGrvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrvarActionPerformed
        // TODO add your handling code here:
        if(tbTela.getSelectedComponent() == pnClientes){
            gravaCliente();
        }else if(tbTela.getSelectedComponent() == pnProdutos){
            gravarProduto();
        }else if(tbTela.getSelectedComponent() == pnTecnicos){
            gravaTec();
        }else if(tbTela.getSelectedComponent() == pnServicos){
            gravaServ();
        }
        
    }//GEN-LAST:event_btGrvarActionPerformed

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        // TODO add your handling code here:
        if(tbTela.getSelectedComponent() == pnClientes){
           TelaConsultas tela = new TelaConsultas(1);
            tela.setVisible(true);
        }else if(tbTela.getSelectedComponent() == pnProdutos){
            TelaConsultas tela = new TelaConsultas(2);
            tela.setVisible(true);
        }else if(tbTela.getSelectedComponent() == pnTecnicos){
            TelaConsultas tela = new TelaConsultas(3);
            tela.setVisible(true);
        }else if(tbTela.getSelectedComponent() == pnServicos){
            TelaConsultas tela = new TelaConsultas(4);
            tela.setVisible(true);
        }
    }//GEN-LAST:event_btConsultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btGrvar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JSpinner jsEstoque;
    private javax.swing.JLabel lbAutor;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCell;
    private javax.swing.JLabel lbCellTec;
    private javax.swing.JLabel lbCpfTec;
    private javax.swing.JLabel lbCusto;
    private javax.swing.JLabel lbDes;
    private javax.swing.JLabel lbDescServico;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEmailTec;
    private javax.swing.JLabel lbEstoque;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbNomeServico;
    private javax.swing.JLabel lbNomeTec;
    private javax.swing.JLabel lbProfTec;
    private javax.swing.JLabel lbSetorTec;
    private javax.swing.JLabel lbTecServico;
    private javax.swing.JLabel lbTel;
    private javax.swing.JLabel lbTellTec;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbValorServico;
    private javax.swing.JLabel lbVenda;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnClientes;
    private javax.swing.JPanel pnPreco;
    private javax.swing.JPanel pnProdutos;
    private javax.swing.JPanel pnServicos;
    private javax.swing.JPanel pnTecnicos;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTabbedPane tbTela;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPFTec;
    private javax.swing.JFormattedTextField txtCell;
    private javax.swing.JFormattedTextField txtCellTec;
    private javax.swing.JFormattedTextField txtCusto;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtDescServico;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailTec;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeServico;
    private javax.swing.JTextField txtNomeTec;
    private javax.swing.JTextField txtProfTec;
    private javax.swing.JTextField txtSetorTec;
    private javax.swing.JTextField txtTecServico;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JFormattedTextField txtTellTec;
    private javax.swing.JFormattedTextField txtValorServico;
    private javax.swing.JFormattedTextField txtVenda;
    // End of variables declaration//GEN-END:variables
}


