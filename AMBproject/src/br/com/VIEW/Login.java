package br.com.VIEW;

import br.com.Controler.SHA256;
import br.com.Controler.TeclasMaiusculas;
import br.com.JDBC.Oracle;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.sql.Statement;
import javax.swing.ImageIcon;

/**
 *
 * @author Denner
 */
public class Login extends javax.swing.JFrame {

    /**
     * Criação Jframe View
     */
    public Login() {
        setIcon();
        initComponents();
        login.setDocument(new TeclasMaiusculas());
    }

    private void setIcon() {
        URL url = this.getClass().getResource("/br/com/IMG/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    /**
     * Método para limpar o campo de texto login e senha quando tiver alguma
     * invalidação
     *///O(1)
    private void limparCampo() {
        this.login.setText(null);
        this.senha.setText(null);
    }

    /**
     * Método para verificar se existe caracteres especiais no nome do login
     *
     * @param text palavra a ser verificada
     * @return caso exista espaços ou caracteres especiais fora numeros e letras
     * retorn falso
     *
     */// O(n)
//    boolean verificadorCaractere(String text) {
//        boolean alfa = true;
//        for (int i = 0; i < text.length(); i++) {
//            if (((byte) text.charAt(i) >= 48 && (byte) text.charAt(i) <= 57) || ((byte) text.charAt(i) >= 65 && (byte) text.charAt(i) <= 90)
//                    || ((byte) text.charAt(i) >= 97 && (byte) text.charAt(i) <= 122)); else {
//                alfa = false;
//            }
//        }
//        return alfa;
//    }
    /**
     * Método que verifica a quantidade de tentativas e bloqueia o log quando
     * for igual a 5 tentativas, o log é bloqueado por 3 minutos
     */
    private void bloquearCampo() {

        if (this.contadorChances == 5) {
            btnEntrar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Você excedeu o número de tentativas!" + '\n' + "Aguarde 3 minutos para fazer login novamente!", "Várias tentativas de login",
                    JOptionPane.INFORMATION_MESSAGE);
            new Thread() {
                public void run() {
                    try {
                        sleep(30000);
                        btnEntrar.setEnabled(true);
                        login.requestFocus();
                        contadorChances = 0;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }.start();
        }
    }

    /* Método para iniciar a conexão com o banco de dados, e verificar o usuário e senha 
     */
    private void logar() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //inicia a conexão jdbc
        Oracle con = new Oracle("10.9.1.210", "amb", "arquivo");
        con.connect(); //faz a conexão
        ResultSet rs = null; // resultado de query
        Statement st;
        String _senha = new SHA256().criptografar(String.valueOf(this.senha.getPassword()));// pega a senha digitada pelo usuário e faz uma criptografia
        String sql = "select * from usuarios where login ='" + this.login.getText() + "' and senha ='" + _senha + "'"; // código sql
        try {
            st = con.c.createStatement();
            rs = st.executeQuery(sql); // caso não entrar no if acima, ele aceitará o código sql e compilará
            if (rs.next()) { // se existir resultados em query
                this.dispose();
                Progresso p = new Progresso(login.getText());
                p.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Login e/ou senha incorreto(s)", "Informação", JOptionPane.INFORMATION_MESSAGE);
                limparCampo(); //limpa campo de login e senha
                this.login.requestFocus();//mandará o foco para login
                this.contadorChances++; //conta as chances de tentativas
                bloquearCampo();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão: \n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textLogin = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        textSenha = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setName("Login"); // NOI18N
        setResizable(false);

        textLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        textLogin.setText("LOGIN");

        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loginKeyReleased(evt);
            }
        });

        textSenha.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        textSenha.setText("SENHA");

        btnEntrar.setText("Entrar");
        getRootPane().setDefaultButton(btnEntrar);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/IMG/logo.png"));
        icon.setImage(icon.getImage().getScaledInstance(190, 180, 1));
        img.setIcon(icon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(117, Short.MAX_VALUE)
                        .addComponent(textSenha)))
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(login)
                        .addComponent(senha)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(textLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        try {
            logar();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyReleased
        //login.setText(login.getText().replaceAll(" ",""));
    }//GEN-LAST:event_loginKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                    Login.setDefaultLookAndFeelDecorated(true);
                } catch (Exception e) {
                    System.err.print("Não Carregado");
                }
                new Login().setVisible(true);

            }
        });
    }
    private int contadorChances = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel img;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField senha;
    private javax.swing.JLabel textLogin;
    private javax.swing.JLabel textSenha;
    // End of variables declaration//GEN-END:variables
}
