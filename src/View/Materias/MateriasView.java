/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Materias;

import Model.BO.MateriasBO;
import Model.Data.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JVM
 */
public class MateriasView extends javax.swing.JInternalFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form Materias
     */
    public MateriasView() {
        initComponents();
        
        Atualizar();
        bt_salvar.setEnabled(false);
        
    }
    
    //usado no botão salvar / editar
    //seta as informações
    MateriasBO materiasBO = new MateriasBO();
    //usado no botão salvar / editar
    //seta as informações
    Model.Entity.Materias materias = new Model.Entity.Materias();
    
    //Metodo de limpa tela, botão novo
    //seto texto vazio para todos os campos
    public void LimpaTela(){
        txt_id.setText("");
        txt_nome.setText("");
        txt_ch.setText("");
    }
    
    //Metodo que atualiza a tabela
    public void Atualizar(){
        try {
            String sql = "select * from materias";
            conn = ConexaoBanco.ConectaDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tb_materias.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_campos = new javax.swing.JPanel();
        lb_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lb_ch = new javax.swing.JLabel();
        txt_ch = new javax.swing.JTextField();
        lb_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        pn_botoes = new javax.swing.JPanel();
        bt_novo = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        lb_pesquisar = new javax.swing.JLabel();
        txt_pesquisar = new javax.swing.JTextField();
        pn_tab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_materias = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro de Materias Academicas");

        pn_campos.setBackground(new java.awt.Color(255, 255, 255));
        pn_campos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_nome.setText("Nome");

        lb_ch.setText("Carga Horaria");

        lb_id.setText("ID");

        txt_id.setEditable(false);

        javax.swing.GroupLayout pn_camposLayout = new javax.swing.GroupLayout(pn_campos);
        pn_campos.setLayout(pn_camposLayout);
        pn_camposLayout.setHorizontalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nome)
                    .addComponent(lb_ch)
                    .addComponent(lb_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_id)
                    .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(txt_ch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_camposLayout.setVerticalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_id)
                    .addGroup(pn_camposLayout.createSequentialGroup()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(21, 21, 21)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nome)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ch)
                    .addComponent(txt_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn_botoes.setBackground(new java.awt.Color(255, 255, 255));
        pn_botoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_editar.setText("Atualizar");
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });

        bt_excluir.setText("Excluir");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        lb_pesquisar.setText("Pesquisar");

        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pn_botoesLayout = new javax.swing.GroupLayout(pn_botoes);
        pn_botoes.setLayout(pn_botoesLayout);
        pn_botoesLayout.setHorizontalGroup(
            pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_botoesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_novo)
                    .addGroup(pn_botoesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_pesquisar)))
                .addGap(18, 18, 18)
                .addGroup(pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_botoesLayout.createSequentialGroup()
                        .addComponent(bt_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(bt_excluir)
                        .addGap(18, 18, 18)
                        .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_pesquisar))
                .addGap(27, 27, 27))
        );
        pn_botoesLayout.setVerticalGroup(
            pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novo)
                    .addComponent(bt_editar)
                    .addComponent(bt_excluir)
                    .addComponent(bt_salvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_pesquisar)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pn_tab.setBackground(new java.awt.Color(255, 255, 255));
        pn_tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tb_materias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_materias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_materiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_materias);

        javax.swing.GroupLayout pn_tabLayout = new javax.swing.GroupLayout(pn_tab);
        pn_tab.setLayout(pn_tabLayout);
        pn_tabLayout.setHorizontalGroup(
            pn_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pn_tabLayout.setVerticalGroup(
            pn_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tabLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_tab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        LimpaTela();
        bt_salvar.setEnabled(true);
        bt_editar.setEnabled(false);
        bt_excluir.setEnabled(false);
        bt_novo.setEnabled(false);
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        materias.setId(txt_id.getText());
        materias.setNome(txt_nome.getText());
        materias.setCarga_horaria(txt_ch.getText());
        
        materiasBO.EditarMaterias(materias);
        Atualizar();
        LimpaTela();
        
        bt_salvar.setEnabled(false);
        bt_editar.setEnabled(false);
        bt_excluir.setEnabled(true);
        bt_novo.setEnabled(true);
    }//GEN-LAST:event_bt_editarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Deseja Excluir esse Cadastro?");

        if (op == 0) {
            materias.setId(txt_id.getText());
            materiasBO.RemoverMaterias(materias);

            Atualizar();
            LimpaTela();
        }
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
            materias.setNome(txt_nome.getText());
            materias.setCarga_horaria(txt_ch.getText());

            //validações dos campos de inserção de informação
            //recebo os textos informados nos campos e jogo para variaveis
            String valida_nome = txt_nome.getText();
            String valida_ch = txt_ch.getText();

            if(valida_nome.equals("")){
                JOptionPane.showMessageDialog(null, "Insira o campo NOME");
            }else if( valida_ch.equals("")){
                JOptionPane.showMessageDialog(null, "Selecione a Carga Horaria da Disciplina");
            }else{//fim das validações dos campos de inserção de informação

            materiasBO.CadastrarMaterias(materias);
            LimpaTela();
            Atualizar();

            bt_salvar.setEnabled(false);
            bt_editar.setEnabled(true);
            bt_excluir.setEnabled(true);
            bt_novo.setEnabled(true);
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased
        String sql = "select * from materias where nome like ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_pesquisar.getText()+"%");
            rs = pst.executeQuery();
            tb_materias.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        
        bt_salvar.setEnabled(false);
        bt_editar.setEnabled(true);
        bt_excluir.setEnabled(true);
        bt_novo.setEnabled(true);
    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void tb_materiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_materiasMouseClicked
        int linha = tb_materias.getSelectedRow();
        String aoClicar = (tb_materias.getModel().getValueAt(linha, 0).toString());

        try {
            String sql = "select * from materias where id = '"+aoClicar+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next()){
                String materias_id = rs.getString("id");
                txt_id.setText(materias_id);

                String materias_nome = rs.getString("nome");
                txt_nome.setText(materias_nome);
                
                String materias_ch = rs.getString("carga_horaria");
                txt_ch.setText(materias_ch);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        bt_salvar.setEnabled(false);
        bt_editar.setEnabled(true);
        bt_excluir.setEnabled(true);
        bt_novo.setEnabled(true);
    }//GEN-LAST:event_tb_materiasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ch;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_pesquisar;
    private javax.swing.JPanel pn_botoes;
    private javax.swing.JPanel pn_campos;
    private javax.swing.JPanel pn_tab;
    private javax.swing.JTable tb_materias;
    private javax.swing.JTextField txt_ch;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pesquisar;
    // End of variables declaration//GEN-END:variables
}
