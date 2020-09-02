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
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RelatoriosFichas extends javax.swing.JFrame {

    /**
     * Creates new form RelatoriosFichas
     */
    private Oracle con = null;

    public RelatoriosFichas() {
        initComponents();
        comboBox.setVisible(false);
        this.con = new Oracle("10.9.1.210", "amb", "arquivo");
        this.con.connect();
        setIcon();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtVigencia = new javax.swing.JLabel();
        campoDataInicial = new javax.swing.JFormattedTextField();
        campoDataFinal = new javax.swing.JFormattedTextField();
        txtDe = new javax.swing.JLabel();
        txtAte = new javax.swing.JLabel();
        selOutro = new javax.swing.JRadioButton();
        comboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Relatórios");

        btnFechar.setText("FECHAR");
        btnFechar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        getRootPane().setDefaultButton(btnImprimir);
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        txtVigencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVigencia.setText("Vigência");

        campoDataInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        try {
            campoDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoDataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoDataInicialKeyReleased(evt);
            }
        });

        campoDataFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        try {
            campoDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoDataFinalKeyReleased(evt);
            }
        });

        txtDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDe.setText("De:");

        txtAte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAte.setText("Até:");

        selOutro.setText("Outro");
        selOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selOutroActionPerformed(evt);
            }
        });

        comboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MÊS ATUAL", "POR USUÁRIO", "TUDO", "QTD POR GRUPO", "QTD POR MÊS" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(txtVigencia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selOutro)
                                    .addComponent(txtDe))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAte)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtVigencia)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDe)
                    .addComponent(txtAte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selOutro))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selOutroActionPerformed
        if (selOutro.isSelected()) {
            comboBox.setVisible(true);
            campoDataFinal.setEnabled(false);
            campoDataInicial.setEnabled(false);
        } else {
            comboBox.setVisible(false);
            campoDataFinal.setEnabled(true);
            campoDataInicial.setEnabled(true);
        }
    }//GEN-LAST:event_selOutroActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.con.disconnect();
        new Switch().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void campoDataInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDataInicialKeyReleased
        if (isDateValid(campoDataInicial.getText())) {//se a data existir a borda fica verde
            campoDataInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 2, true));
        } else {
            campoDataInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));//se não continua vermelha
        }
    }//GEN-LAST:event_campoDataInicialKeyReleased

    private void campoDataFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDataFinalKeyReleased
        if (isDateValid(campoDataFinal.getText())) {
            campoDataFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 2, true));
        } else {
            campoDataFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        }
    }//GEN-LAST:event_campoDataFinalKeyReleased

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (isDateValid(campoDataInicial.getText()) && isDateValid(campoDataFinal.getText()) && campoDataInicial.isEnabled()) {// se a data existir nos dois campos
            if (comparar(campoDataInicial.getText(), campoDataFinal.getText())) {//e a data inicial for menor que a final
                imprimirPorData();//imprimi
            } else {
                JOptionPane.showMessageDialog(null, "A data final é inferior a data inicial!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (selOutro.isSelected()) { // se o usuário marcar a caixa de "outro"
            //Os códigos abaixo basicamente imprimir pela escolha do usuário (0 para mes atual) (1 para relatório de separado por Usuário) e por ultimo imprimir tudo
            switch (comboBox.getSelectedIndex()) {
                case 0:imprimirMesAtual();
                    break;
                case 1:
                    imprimirPorUsuario();
                    break;
                case 2:
                    imprimirTudo();
                    break;
                case 3:
                    imprimirGrupo();
                    break;
                default:
                    imprimirMes();
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!", "Info", JOptionPane.INFORMATION_MESSAGE);
            campoDataInicial.setValue(null);
            campoDataFinal.setValue(null);
            campoDataInicial.requestFocus();
        }
    }//GEN-LAST:event_btnImprimirActionPerformed
    /**
     * Método para imprimir entre duas datas
     */
    private void imprimirPorData() {
        Connection conn = this.con.c;//pega a conexão do banco
        Map<String,Object> datas = new HashMap<>();//classe MAP (collection) parecido com ArrayList, só que mais simples, e usa menos memória
        int total = 0;
        try {
            try {
                PreparedStatement st = this.con.c.prepareStatement("select count(*) from ATENDIMENTOS where DATA_ATENDIMENTO between (?) and (?)");//instrução para setar o total de ficas na págica
                st.setString(1, campoDataInicial.getText());
                st.setString(2, campoDataFinal.getText());
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("count(*)");//total recebe a soma de todas as linhas
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
            }
            //insere o segundo campo depois da virgua na variavel antes da virgula que foi feita no jaspersoft
            datas.put("dataInicial", campoDataInicial.getText());
            datas.put("dataFinal", campoDataFinal.getText());
            datas.put("total", total);
            JasperPrint print = JasperFillManager.fillReport("RELATORIOS/FICHAS/Relatorios.jasper", datas, conn);//passa o nome do carquivo, o objeto Collection, e a conexão

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para imprimir pelo Mês atual
     */
    private void imprimirMesAtual() {
        Connection conn = this.con.c;
        Map<String,Object> datas = new HashMap<>();
        int total = 0;
        SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
        Date data = new Date();
        String strData = format.format(data);
        try {
            try {
                PreparedStatement st = this.con.c.prepareStatement("select count(*) from ATENDIMENTOS where to_char(DATA_ATENDIMENTO,'MM/YYYY') = ?");
                st.setString(1, strData);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("count(*)");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
            }
            datas.put("data", strData);
            datas.put("total", total);
            JasperPrint print = JasperFillManager.fillReport("RELATORIOS/FICHAS/RelatoriosAtual.jasper", datas, conn);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para imprimir separado por usuário
     */
    private void imprimirPorUsuario() {
        Connection conn = this.con.c;
        Map<String,Object> datas = new HashMap<>();
        int total = 0;
        try {
            try {
                PreparedStatement st = this.con.c.prepareStatement("select count(*) from ATENDIMENTOS");
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("count(*)");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RelatoriosFichas.class.getName()).log(Level.SEVERE, null, ex);
            }
            datas.put("total", total);
            JasperPrint print = JasperFillManager.fillReport("RELATORIOS/FICHAS/RelatoriosUsuario.jasper", datas, conn);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para imprimir todas as fichas
     */
    private void imprimirTudo() {
        Connection conn = this.con.c;
        Map<String,Object> datas = new HashMap<>();
        int total = 0;
        try {
            try {
                PreparedStatement st = this.con.c.prepareStatement("select count(*) from ATENDIMENTOS");
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("count(*)");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RelatoriosFichas.class.getName()).log(Level.SEVERE, null, ex);
            }
            datas.put("total", total);
            JasperPrint print = JasperFillManager.fillReport("RELATORIOS/FICHAS/RelatoriosTudo.jasper", datas, conn);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Este método faz a impressão agrupado por usuario e traz a quantidade de
     * fichas por usuário
     */
    private void imprimirGrupo() {
        Connection conn = this.con.c;
        Map<String,Object> datas = new HashMap<>();
        int total = 0;
        try {
            try {
                PreparedStatement st = this.con.c.prepareStatement("select count(*) from ATENDIMENTOS");
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("count(*)");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RelatoriosFichas.class.getName()).log(Level.SEVERE, null, ex);
            }
            datas.put("total", total);
            JasperPrint print = JasperFillManager.fillReport("RELATORIOS/FICHAS/RelatoriosGrupo.jasper", datas, conn);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void imprimirMes() {
        Connection conn = this.con.c;
        Map<String,Object> datas = new HashMap<>();
        int total = 0;
        try {
            try {
                PreparedStatement st = this.con.c.prepareStatement("select count(*) from ATENDIMENTOS");
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("count(*)");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RelatoriosFichas.class.getName()).log(Level.SEVERE, null, ex);
            }
            datas.put("total", total);
            JasperPrint print = JasperFillManager.fillReport("RELATORIOS/FICHAS/RelatoriosMes.jasper", datas, conn);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro de Relatórios", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para comparar as datas
     *
     * @param inicio data inicial a ser comparada
     * @param fim data final a ser comparada com a primeira
     * @return true se a data inicial for menor ou igual a final
     */
    private boolean comparar(String inicio, String fim) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");//tipo de formato para a data
        Date data1 = null, data2 = null;
        try {
            data1 = format.parse(inicio);//formata a data
            data2 = format.parse(fim);
        } catch (ParseException ex) {
            Logger.getLogger(RelatoriosFichas.class.getName()).log(Level.SEVERE, null, ex);
        }

        Calendar cal = Calendar.getInstance();//instancia um objeto da Classe calendar
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(data1);//seta o calendário com o formato novo
        cal2.setTime(data2);

        // se a data 1 é metor que 2, retorna true, se não se a data 1 for maior que a data 2 retorna false, se não retorna 
        //obs o código está redundante, mas está melhor legivél para outro programador caso queira mudar ficaria
        //(cal.after(cal2))? false : true;
        return (cal.before(cal2)) ? true : (cal.after(cal2)) ? false : true;
    }

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
        } catch (DateTimeParseException e) {//se aquele método gerar um erro retorna falso
            return false;
        }
    }

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
            java.util.logging.Logger.getLogger(RelatoriosFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatoriosFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatoriosFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatoriosFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosFichas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JFormattedTextField campoDataFinal;
    private javax.swing.JFormattedTextField campoDataInicial;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JRadioButton selOutro;
    private javax.swing.JLabel txtAte;
    private javax.swing.JLabel txtDe;
    private javax.swing.JLabel txtVigencia;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        URL caminhoIcone = getClass().getResource("/br/com/IMG/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }
}
