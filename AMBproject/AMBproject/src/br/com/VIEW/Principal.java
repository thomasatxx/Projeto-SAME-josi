/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.VIEW;

import br.com.JDBC.Oracle;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal(String data, String hora, String login) {
        setIcon();
        initComponents();
        this.data.setText(data);
        this.msgVindas.setText(hora);
        user.setText(login);
        verificarPermissao();
    }

    private void setIcon() {
        URL caminhoIcone = getClass().getResource("/br/com/IMG/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }

    private Principal() {
        initComponents(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msgVindas = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        btnCadastroFichas = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txtCadastroFichas = new javax.swing.JLabel();
        txtPesqusa = new javax.swing.JLabel();
        txtSair = new javax.swing.JLabel();
        txtLogout = new javax.swing.JLabel();
        txtRelatórios = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();
        btnCadastrosAtividades = new javax.swing.JButton();
        txtCadastroAtividades = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        cadastroFichas = new javax.swing.JMenuItem();
        solitacao = new javax.swing.JMenuItem();
        cadastroUsr = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();
        Ajuda = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAME - Sistema de gestão para arquivo");
        setResizable(false);

        msgVindas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        msgVindas.setText("Mensagem");

        user.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        user.setText("user");

        data.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        data.setText("data");

        ImageIcon fichas = new ImageIcon(getClass().getResource("/br/com/IMG/prescription-icon.png"));
        fichas.setImage(fichas.getImage().getScaledInstance(120,120,1));
        btnCadastroFichas.setIcon(fichas);
        btnCadastroFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroFichasActionPerformed(evt);
            }
        });

        ImageIcon print = new ImageIcon(getClass().getResource("/br/com/IMG/print.png"));
        print.setImage(print.getImage().getScaledInstance(120,120,1));
        btnRelatorios.setIcon(print);
        btnRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatoriosActionPerformed(evt);
            }
        });

        ImageIcon reset = new ImageIcon(getClass().getResource("/br/com/IMG/reset.png"));
        reset.setImage(reset.getImage().getScaledInstance(120,120,1));
        btnLogout.setIcon(reset);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        ImageIcon sair = new ImageIcon(getClass().getResource("/br/com/IMG/sair.png"));
        sair.setImage(sair.getImage().getScaledInstance(120,120,1));
        btnSair.setIcon(sair);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txtCadastroFichas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCadastroFichas.setText("Cadastro de Fichas");

        txtPesqusa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPesqusa.setText("Pesquisa de Fichas");

        txtSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSair.setText("Sair");

        txtLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLogout.setText("Logout");

        txtRelatórios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRelatórios.setText("Relatórios");

        ImageIcon pesquisa = new ImageIcon(getClass().getResource("/br/com/IMG/search-icon.png"));
        pesquisa.setImage(pesquisa.getImage().getScaledInstance(120,120,1));
        btnPesquisa.setIcon(pesquisa);
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        ImageIcon atividades = new ImageIcon(getClass().getResource("/br/com/IMG/atividades.png"));
        atividades.setImage(atividades.getImage().getScaledInstance(120, 120, 1));
        btnCadastrosAtividades.setIcon(atividades);
        btnCadastrosAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrosAtividadesActionPerformed(evt);
            }
        });

        txtCadastroAtividades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCadastroAtividades.setText("Controle de Solicitação");

        menuCadastro.setText("Cadastros");

        cadastroFichas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        cadastroFichas.setText("Fichas");
        cadastroFichas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastroFichasMouseClicked(evt);
            }
        });
        cadastroFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroFichasActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastroFichas);

        solitacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        solitacao.setText("Solicitação");
        solitacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                solitacaoMouseClicked(evt);
            }
        });
        solitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solitacaoActionPerformed(evt);
            }
        });
        menuCadastro.add(solitacao);

        cadastroUsr.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        cadastroUsr.setText("Usuários");
        cadastroUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroUsrActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastroUsr);

        jMenuBar1.add(menuCadastro);

        menuRelatorio.setText("Relatórios");
        menuRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRelatorioMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuRelatorio);

        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSobre);

        Ajuda.setText("Ajuda");
        Ajuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AjudaMouseClicked(evt);
            }
        });
        jMenuBar1.add(Ajuda);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(msgVindas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(user)
                        .addGap(428, 428, 428)
                        .addComponent(data))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCadastroFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(txtCadastroFichas)))
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCadastrosAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(txtCadastroAtividades)))
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesqusa)
                                .addGap(47, 47, 47)))))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(txtRelatórios)
                .addGap(343, 343, 343)
                .addComponent(txtLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSair)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCadastroFichas)
                            .addComponent(txtPesqusa, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastroFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCadastroAtividades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrosAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSair)
                    .addComponent(txtRelatórios)
                    .addComponent(txtLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msgVindas)
                    .addComponent(user)
                    .addComponent(data))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastroUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroUsrActionPerformed
        new CadastroUser(this.user.getText()).setVisible(true);
    }//GEN-LAST:event_cadastroUsrActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        new Sobre().setVisible(true);
    }//GEN-LAST:event_menuSobreMouseClicked

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        int x = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuSairMouseClicked

    private void btnCadastroFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroFichasActionPerformed
        new Fichas(this.user.getText()).setVisible(true);
    }//GEN-LAST:event_btnCadastroFichasActionPerformed

    private void cadastroFichasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastroFichasMouseClicked
        new Fichas(this.user.getText()).setVisible(true);
    }//GEN-LAST:event_cadastroFichasMouseClicked

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        new Pesquisa().setVisible(true);
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void cadastroFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroFichasActionPerformed
        new Fichas(this.user.getText()).setVisible(true);
    }//GEN-LAST:event_cadastroFichasActionPerformed

    private void btnRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatoriosActionPerformed
        new Switch().setVisible(true);
    }//GEN-LAST:event_btnRelatoriosActionPerformed

    private void menuRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRelatorioMouseClicked
        new Switch().setVisible(true);
    }//GEN-LAST:event_menuRelatorioMouseClicked

    private void AjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjudaMouseClicked
        new Ajuda().setVisible(true);
    }//GEN-LAST:event_AjudaMouseClicked

    private void btnCadastrosAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrosAtividadesActionPerformed
        new Atividades(this.user.getText(),flag).setVisible(true);
    }//GEN-LAST:event_btnCadastrosAtividadesActionPerformed

    private void solitacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solitacaoMouseClicked
        new Atividades(this.user.getText(),flag).setVisible(true);
    }//GEN-LAST:event_solitacaoMouseClicked

    private void solitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solitacaoActionPerformed
        new Atividades(this.user.getText(),flag).setVisible(true);
    }//GEN-LAST:event_solitacaoActionPerformed
    /**
     * Método verifica se o usuário logado é administrador
     */
    private void verificarPermissao() {
        Oracle con = new Oracle("10.9.1.210", "amb", "arquivo");//cria conexão
        con.connect();//estabelece a conexão    
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st = con.c.prepareStatement("select * from USUARIOS where LOGIN = ? and Perfil = ?");//prepara a query
            st.setString(1, this.user.getText());//no lugar de "?" é setado uma String
            st.setString(2, "ADMINISTRADOR");
            rs = st.executeQuery();//executa o sql
            if (!rs.next()) {//se não tiver resultado é porque o usuário é padrão
                cadastroUsr.setEnabled(false);//então desativa a permissão de cadastro de usuários
                this.flag = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.disconnect();
        }
    }
    private boolean flag = true;
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ajuda;
    private javax.swing.JButton btnCadastroFichas;
    private javax.swing.JButton btnCadastrosAtividades;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnSair;
    private javax.swing.JMenuItem cadastroFichas;
    private javax.swing.JMenuItem cadastroUsr;
    private javax.swing.JLabel data;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JLabel msgVindas;
    private javax.swing.JMenuItem solitacao;
    private javax.swing.JLabel txtCadastroAtividades;
    private javax.swing.JLabel txtCadastroFichas;
    private javax.swing.JLabel txtLogout;
    private javax.swing.JLabel txtPesqusa;
    private javax.swing.JLabel txtRelatórios;
    private javax.swing.JLabel txtSair;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
