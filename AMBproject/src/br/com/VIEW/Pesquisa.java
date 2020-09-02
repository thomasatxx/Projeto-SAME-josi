/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.VIEW;

import br.com.Controler.TeclasMaiusculasEspacos;
import br.com.JDBC.Oracle;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class Pesquisa extends javax.swing.JFrame {

    /**
     * O Construtor que cria a conexão no objeto declarado no escopo global,
     * coloca o campo de nome para só maiusculas, e desabilita as caixas de
     * seleção por padrão
     */
    public Pesquisa() {
        setIcon();
        initComponents();
        this.con = new Oracle("10.9.1.210", "amb", "arquivo");
        this.campoNome.setDocument(new TeclasMaiusculasEspacos());
        selNome.setEnabled(false);
        selAtendimento.setEnabled(false);
        selAtualizacao.setEnabled(false);
    }

   private void setIcon() {
        URL caminhoIcone = getClass().getResource("/br/com/IMG/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }
    private Oracle con;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selecao = new javax.swing.ButtonGroup();
        campoNome = new javax.swing.JTextField();
        txtOrdenar = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        selNome = new javax.swing.JRadioButton();
        selAtendimento = new javax.swing.JRadioButton();
        selAtualizacao = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Fichas");
        setResizable(false);

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNomeKeyReleased(evt);
            }
        });

        txtOrdenar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOrdenar.setText("Ordenar por:");

        ImageIcon pesquisar = new ImageIcon(getClass().getResource("/br/com/IMG/pesquisa.png"));
        btnPesquisar.setIcon(pesquisar);
        btnPesquisar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getRootPane().setDefaultButton(btnPesquisar);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Digite para pesquisar:");

        tabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NOME", "DATA NASCIMENTO", "DATA ATENDIMENTO", "ULTIMA ATUALIZAÇÃO", "CADASTRADO POR"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        selecao.add(selNome);
        selNome.setText("NOME");
        selNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNomeActionPerformed(evt);
            }
        });

        selecao.add(selAtendimento);
        selAtendimento.setText("ATENDIMENTO");
        selAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selAtendimentoActionPerformed(evt);
            }
        });

        selecao.add(selAtualizacao);
        selAtualizacao.setText("ATUALIZAÇÃO");
        selAtualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selAtualizacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selNome)
                .addGap(69, 69, 69)
                .addComponent(selAtendimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(selAtualizacao)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selNome)
                    .addComponent(selAtendimento)
                    .addComponent(selAtualizacao))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrdenar)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtOrdenar))
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        selNome.setEnabled(true);//habilita as caixas de seleção
        selAtendimento.setEnabled(true);
        selAtualizacao.setEnabled(true);
        this.con.connect();
        ResultSet rs = null;
        try {//sql para listar tudo por padrão que sai na tabela 
            PreparedStatement st = con.c.prepareStatement("select NOME,to_char(DATA_NASCIMENTO,'DD/MM/YYYY') as DATA_NASCIMENTO,to_char(DATA_ATENDIMENTO,'DD/MM/YYYY') as DATA_ATENDIMENTO,concat(to_char(DATA_CADASTRO,'DD/MM/YYYY HH24:MI'),'H') as ULTIMA_ATUALIZAÇÃO, LOGIN as CADASTRADO_POR from ATENDIMENTOS A JOIN USUARIOS U on(A.ID_LOGIN = U.ID_LOGIN)");
            rs = st.executeQuery();//em select usamos o executeQuery por retorna Informações. para DML usamos excuteUpdate que retorna maior que 0 se for inserido,deletado,modificado com sucesso ou uma exception sql de dml
            tabela.setModel(DbUtils.resultSetToTableModel(rs));//seta o modelo com o resultado sql
            tabela.getColumnModel().getColumn(0).setPreferredWidth(190);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Pesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void selNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNomeActionPerformed
        this.con.connect();
        ResultSet rs = null;
        try {                                                          //to_char(para formatar a data PARA 8 DIGITOS                                                                        //CONCATENAR A DATA FORMATADA EM 8 DIGITOS E HORA E MENUTO COM UM H(HORAS)                                                                  //JOIN SIMPLES         //ORDENADO PELO NOME
            PreparedStatement st = con.c.prepareStatement("select NOME,to_char(DATA_NASCIMENTO,'DD/MM/YYYY') as DATA_NASCIMENTO,to_char(DATA_ATENDIMENTO,'DD/MM/YYYY') as DATA_ATENDIMENTO,concat(to_char(DATA_CADASTRO,'DD/MM/YYYY HH24:MI'),'H') as ULTIMA_ATUALIZAÇÃO, LOGIN as CADASTRADO_POR from ATENDIMENTOS A JOIN USUARIOS U on(A.ID_LOGIN = U.ID_LOGIN) order by NOME");
            rs = st.executeQuery();
            tabela.setModel(DbUtils.resultSetToTableModel(rs));//seta o modelo com o resultado sql
            tabela.getColumnModel().getColumn(0).setPreferredWidth(190);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Pesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selNomeActionPerformed
    /**
     * KeyRelease é ativado quando reconhece 1 byte do teclado (1 caractere)
     *
     */
    private void campoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyReleased
        campoNome.setText(campoNome.getText().replaceAll("[0-9]", ""));//ignora números
        selNome.setEnabled(false);//desabilita as seleções 
        selAtendimento.setEnabled(false);
        selAtualizacao.setEnabled(false);
        this.con.connect();
        ResultSet rs = null;
        try { // este sql faz a pesquisa avançada de letra a letra com operador like para cada letra a mais digitada
            PreparedStatement st = con.c.prepareStatement("select NOME,to_char(DATA_NASCIMENTO,'DD/MM/YYYY') as DATA_NASCIMENTO,to_char(DATA_ATENDIMENTO,'DD/MM/YYYY') as DATA_ATENDIMENTO,concat(to_char(DATA_CADASTRO,'DD/MM/YYYY HH24:MI'),'H') as ULTIMA_ATUALIZAÇÃO, LOGIN as CADASTRADO_POR from ATENDIMENTOS A JOIN USUARIOS U on(A.ID_LOGIN = U.ID_LOGIN) where NOME like ?");
            st.setString(1, campoNome.getText() + "%");
            rs = st.executeQuery();
            tabela.setModel(DbUtils.resultSetToTableModel(rs));//seta o modelo com o resultado sql
            tabela.getColumnModel().getColumn(0).setPreferredWidth(190);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Pesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_campoNomeKeyReleased

    private void selAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selAtendimentoActionPerformed
        this.con.connect();
        ResultSet rs = null;
        try {//esta sql é o mesmo que os de cima, porém ordena por ANO depois por MÊS e depois por DIA (MAIS RECENTES) usando o substr(equivalente ao método subString em java) que é dado dois indices de uma String para cortá-la
            PreparedStatement st = con.c.prepareStatement("select NOME,to_char(DATA_NASCIMENTO,'DD/MM/YYYY') as DATA_NASCIMENTO,to_char(DATA_ATENDIMENTO,'DD/MM/YYYY') as DATA_ATENDIMENTO,concat(to_char(DATA_CADASTRO,'DD/MM/YYYY HH24:MI'),'H') as ULTIMA_ATUALIZAÇÃO, LOGIN as CADASTRADO_POR from ATENDIMENTOS A JOIN USUARIOS U on(A.ID_LOGIN = U.ID_LOGIN) \n"
                    + "order by substr(A.DATA_ATENDIMENTO,7,10) desc, substr(A.DATA_ATENDIMENTO,4,5) desc,substr(A.DATA_ATENDIMENTO,0,2) desc");
            rs = st.executeQuery();
            tabela.setModel(DbUtils.resultSetToTableModel(rs));//seta o modelo com o resultado sql
            tabela.getColumnModel().getColumn(0).setPreferredWidth(190);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Pesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selAtendimentoActionPerformed

    private void selAtualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selAtualizacaoActionPerformed
        this.con.connect();
        ResultSet rs = null;
        try {//esta sql é o mesmo que os de cima, mas ordena pela ultima alteração, neste caso não é preciso usar SUBSTR pois essa data foi originada do tipo DATE de SYSDATE, e não uma STRING digitada pelo java
            PreparedStatement st = con.c.prepareStatement("select NOME,to_char(DATA_NASCIMENTO,'DD/MM/YYYY') as DATA_NASCIMENTO,to_char(DATA_ATENDIMENTO,'DD/MM/YYYY') as DATA_ATENDIMENTO,concat(to_char(DATA_CADASTRO,'DD/MM/YYYY HH24:MI'),'H') as ULTIMA_ATUALIZAÇÃO, LOGIN as CADASTRADO_POR from ATENDIMENTOS A JOIN USUARIOS U on(A.ID_LOGIN = U.ID_LOGIN) order by DATA_CADASTRO desc");
            rs = st.executeQuery();
            tabela.setModel(DbUtils.resultSetToTableModel(rs));//seta o modelo com o resultado sql
            tabela.getColumnModel().getColumn(0).setPreferredWidth(190);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Pesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selAtualizacaoActionPerformed

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
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton selAtendimento;
    private javax.swing.JRadioButton selAtualizacao;
    private javax.swing.JRadioButton selNome;
    private javax.swing.ButtonGroup selecao;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel txtOrdenar;
    // End of variables declaration//GEN-END:variables

}