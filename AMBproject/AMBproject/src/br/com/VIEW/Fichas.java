/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.VIEW;

import br.com.Controler.FichasCadastro;
import br.com.Controler.TeclasMaiusculasEspacos;
import br.com.JDBC.Oracle;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author User
 */
public class Fichas extends javax.swing.JFrame {

    /**
     * Contrutor de inicializa o padrão desejado pelo programador
     */
    public Fichas(String user) {
        setIcon();
        initComponents();
        campoNome.setDocument(new TeclasMaiusculasEspacos());
        this.user = user;
        btnOK.setVisible(false);
        this.campoCadastrado.setEnabled(false);
        this.campoCadastro.setEnabled(false);
        atualizar();
        this.btnExcluir.setEnabled(false);
    }

    public Fichas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        txtNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoDataNasc = new javax.swing.JFormattedTextField();
        txtNascimento = new javax.swing.JLabel();
        txtAtendimento = new javax.swing.JLabel();
        campoDataAtend = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        painel = new javax.swing.JPanel();
        txtCadastro = new javax.swing.JLabel();
        campoCadastro = new javax.swing.JTextField();
        txtCadastrado = new javax.swing.JLabel();
        campoCadastrado = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastramento de fichas ambulatoriais");
        setResizable(false);

        tabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOME", "DATA_NASCIMENTO", "DATA_ATENDIMMENTO", "ULTIMA ATUALIZAÇÂO", "USUÁRIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.setText("Nome completo");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtNascimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNascimento.setText("Data de Nascimento");

        txtAtendimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAtendimento.setText("Data de Atendimento");

        try {
            campoDataAtend.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ImageIcon salvar = new ImageIcon(getClass().getResource("/br/com/IMG/salvar.png"));
        salvar.setImage(salvar.getImage().getScaledInstance(75,75,1));
        btnSalvar.setIcon(salvar);
        getRootPane().setDefaultButton(btnSalvar);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        ImageIcon editar = new ImageIcon(getClass().getResource("/br/com/IMG/alterar.png"));
        editar.setImage(editar.getImage().getScaledInstance(80,80,1));
        btnEditar.setIcon(editar);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        ImageIcon ex = new ImageIcon(getClass().getResource("/br/com/IMG/excluir.png"));
        ex.setImage(ex.getImage().getScaledInstance(70, 65, 1));
        btnExcluir.setIcon(ex);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        ImageIcon cancel = new ImageIcon(getClass().getResource("/br/com/IMG/cancelar.png"));
        cancel.setImage(cancel.getImage().getScaledInstance(60, 60, 1));
        btnCancelar.setIcon(cancel);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCadastro.setText("Data cadastro");

        campoCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtCadastrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCadastrado.setText("Cadastrado por");

        campoCadastrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCadastro)
                    .addComponent(txtCadastrado)
                    .addComponent(campoCadastrado, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(campoCadastro))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCadastrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnOK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome)
                    .addComponent(txtNascimento)
                    .addComponent(txtAtendimento)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(campoDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtAtendimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(btnOK)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //if (campoDataNasc.getText().matches("\\d{2}/\\d{2}/\\d{4}")) <-- significa que é valido se contiver 2 digitos + 2 digitos + 4 digitos formando uma data completa xx/xx/xxxx
        if (isDateValid(campoDataAtend.getText()) && isDateValid(campoDataNasc.getText()) && !campoNome.getText().isEmpty() && campoNome.getText().length() > 6) {//se as datas forem válidas, e o nome for verdadeiro
            new FichasCadastro(campoNome.getText(), campoDataNasc.getText(), campoDataAtend.getText(), this.user);//insere através do construtor
            atualizar();//atualiza a tabela
            btnCancelarActionPerformed(evt);//retorna padrão
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente", "Info", JOptionPane.INFORMATION_MESSAGE);//se tiver pendências, msg de erro 
            campoNome.requestFocus();//retorna o foco para o nome novamente
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * Este método retorna tudo como padrão
     *
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        campoNome.setText(null);
        campoDataNasc.setValue(null);
        campoDataAtend.setValue(null);
        campoCadastrado.setText(null);
        campoCadastro.setText(null);
        btnOK.setVisible(false);
        tabela.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(true);
        campoNome.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        tabela.setEnabled(true);
        btnOK.setVisible(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (isDateValid(campoDataAtend.getText()) && isDateValid(campoDataNasc.getText()) && campoNome.getText().contains(" ") && campoNome.getText().length() > 6) {
            new FichasCadastro(campoNome.getText(), campoDataNasc.getText(), campoDataAtend.getText(), this.user, this.cod);//faz o update pelo construtor acrescentando o cod como "where"
            atualizar();
            btnCancelarActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente", "Info", JOptionPane.INFORMATION_MESSAGE);
            campoNome.requestFocus();
        }
    }//GEN-LAST:event_btnOKActionPerformed
    /**
     *
     * Este método ao clicar na linha se a tabela estiver habilitada, ele
     * preeche os campos adequadamente
     */
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.isEnabled()) {
            this.cod = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            campoNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            campoDataNasc.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            campoDataAtend.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
            campoCadastro.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
            campoCadastrado.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
        }

    }//GEN-LAST:event_tabelaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar a exclusão?", "Atenção", JOptionPane.YES_NO_OPTION);//pergunta de confirmação
        if (x == JOptionPane.YES_OPTION) {//se sim
            new FichasCadastro(this.cod);//chama o construtor da classe fichas e chama automaticamente o método exluir
            atualizar();//atualiza 
            btnCancelarActionPerformed(evt);//retorna ao padrão
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * Método que verifica a data se realmente existe no calendário
     *
     * @param strDate data a ser comparada
     * @return
     */
    private static boolean isDateValid(String strDate) {
        String dateFormat = "dd/MM/uuuu";//formato data de 8 digitos

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter // cria objeto da classe 
                .ofPattern(dateFormat)//adiciona o padrão
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);// se a data estiver certa retorna true
            return true;
        } catch (DateTimeParseException e) {//caso não exisitr no calendário, ocorrerá uma Exception e retorna falso
            return false;
        }
    }

    /**
     * Método para atualizar a tabela
     */
    private void atualizar() {
        Oracle con = new Oracle("10.9.1.210", "amb", "arquivo");//cria conexão
        con.connect();//estabelece conexão
        ResultSet rs = null;
        String sql = "select CODIGO as COD, NOME, to_char(DATA_NASCIMENTO,'DD/MM/YYYY') as NASCIMENTO,to_char(DATA_ATENDIMENTO,'DD/MM/YYYY') as ATENDIMENTO,concat(to_char(DATA_CADASTRO,'DD/MM/YY HH24:MI'),'H') as ATUALIZAÇÃO,LOGIN as USUÁRIO from ATENDIMENTOS join USUARIOS ON (ATENDIMENTOS.ID_LOGIN = usuarios.ID_LOGIN) order by DATA_CADASTRO desc";
        try {//acima está o sql
            PreparedStatement st = con.c.prepareStatement(sql);// prepara a query
            rs = st.executeQuery();//execulta
            tabela.setModel(DbUtils.resultSetToTableModel(rs));//o resultado é transferido para a tabela 
            tabela.setEnabled(false);//desabilita a tabela não permitindo clicks
            tabela.getColumnModel().getColumn(0).setPreferredWidth(25);// formata a coluna com o tamanho de 25px
            tabela.getColumnModel().getColumn(0).setResizable(false);//não permite redimensionar
            tabela.getColumnModel().getColumn(1).setPreferredWidth(300);// formata a coluna com o tamanho de 300px
            tabela.getColumnModel().getColumn(2).setPreferredWidth(70);// formata a coluna com o tamanho de 70px
            tabela.getColumnModel().getColumn(5).setPreferredWidth(50);// formata a coluna com o tamanho de 50px
            tabela.getTableHeader().setReorderingAllowed(false); // não permitir trocar as colunas de lugar
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Fichas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.disconnect();
        }
    }

    private void setIcon() {
        URL caminhoIcone = getClass().getResource("/br/com/IMG/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }

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
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fichas().setVisible(true);
            }
        });
    }
    private int cod;
    private String user;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoCadastrado;
    private javax.swing.JTextField campoCadastro;
    private javax.swing.JFormattedTextField campoDataAtend;
    private javax.swing.JFormattedTextField campoDataNasc;
    private javax.swing.JTextField campoNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel txtAtendimento;
    private javax.swing.JLabel txtCadastrado;
    private javax.swing.JLabel txtCadastro;
    private javax.swing.JLabel txtNascimento;
    private javax.swing.JLabel txtNome;
    // End of variables declaration//GEN-END:variables
}
