/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.VIEW;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Denner Almeida - 2018
 */
public class Progresso1 extends javax.swing.JFrame {

    /**
     * Creates new form Progresso
     *
     * @param login
     */
    public Progresso1(String login) {
        initComponents();
        this.login = login;
        setIcon();
        System.out.println(getLengthLocal()+" "+getLengthServer());
        run();
    }
    private final String login;
    
    /**
     * Método para aplicar icone na janela e na barra de tarefas
     */
   private void setIcon() {
        URL caminhoIcone = getClass().getResource("/br/com/IMG/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }

    
    /**
     * Construtor Vazio
     */
    private Progresso1() {
        this("ADMIN");
    }
    
    /**
     * Método void principal
     */
    private void run() {
        if (comparar())/*Se retornar verdadeiro*/ {
            verificar();/* leia o java doc desde metodo*/

        } else {//se não há o que atualizar
            new Thread()/*Nova thread para processar*/ {
                @Override
                public void run() {
                    //as linhas abaixo atualizam de forma progressiva sem copiar arquivos
                    try {
                        int x = 0;
                        barraProgresso.setMaximum(100);
                        while (x < barraProgresso.getMaximum()) {
                            barraProgresso.setValue(++x);
                            sleep(10);//espera 10milisegundos
                            textProg.setText("Carregando...");
                            if (barraProgresso.getValue() >= 99) {
                                textProg.setText("Iniciando módulo principal!");
                                sleep(200);//espera 200 milisegundos
                            }
                        }

                        new Principal(data(), hora(),login).setVisible(true);
                        dispose();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "O progresso foi interrompido \n" + ex, "Erro de atualização", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }.start();
        }
    }
    
    /**
     * Método responsável por atualizar todos os arquivos do servidor para máquina local
     */
    private void verificar() {
       
        int max = getLengthServer();
        barraProgresso.setMaximum(max);

        new Thread() {
            @Override
            public void run() {
                Process p;
                try {
                    p = Runtime.getRuntime().exec("cmd /c XCOPY \\\\10.9.1.218\\ARQ\\SAME C:\\\"AMB - SYSTEM\"  /I /E /Y");//comando cmd, copiar arquivo do servidor para disco C

                    String line;
                    BufferedReader stdInput = new BufferedReader(new //Buffered reader para ler as linhas do comando
                            InputStreamReader(p.getInputStream()));
                    //printa o retorno
                    int x = 0;// contador do progresso
                    while ((line = stdInput.readLine()) != null || x <= max) { // enquanto haver linha escrita ou até que o progresso chegue ao máximo de arquivos do diretório original
                        barraProgresso.setValue(++x);//aumenta progresso
                        textProg.setText(line);
                        textStatus.setText("Carregando Arquivos...");//mensagem
                        if (barraProgresso.getValue() >= barraProgresso.getMaximum()-1) {
                            textStatus.setText("Atualizando o sistema...");
                            sleep(300);
                        }
                    }
                    dispose();
                    JOptionPane.showMessageDialog(null, "O sistema foi atualizado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    Runtime.getRuntime().exec("cmd /c cd C:\\\"AMB - SYSTEM\" && java -jar SAME.jar");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar arquivos do servidor \n" + ex, "Erro de atualização", JOptionPane.ERROR_MESSAGE);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "O progresso foi interrompido \n" + ex, "Erro de atualização", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.start();
    }
    
    /**
     * Método para compara a data de modificação do executavel do servidor com a local
     * @return      retorna true ou false
     */
    private boolean comparar() {
        
//        File jarLocal = new File("C:\\\"AMB - SYSTEM\"\\SAME.jar");
//        File jarServer = new File("\\\\10.9.1.218\\arq\\same\\SAME.JAR");
        return ((getLengthServer() > getLengthLocal()));
    }
    
    /**
     * Método que calcula a quantidade de arquivo existente na pasta local
     * 
     * @return    retorna quantidade de arquivos na pasta
     */
    private int getLengthLocal() {
        File subFileLib = new File("\\\\10.9.1.111\\amb - system\\lib");
        File subFile = new File("\\\\10.9.1.111\\amb - system\\RELATORIOS\\ATIVIDADES");
        File subFile2 = new File("\\\\10.9.1.111\\amb - system\\RELATORIOS\\FICHAS");
        File file = new File("\\\\10.9.1.111\\amb - system");
        return (file.listFiles().length + subFile.listFiles().length + subFileLib.listFiles().length + subFile2.listFiles().length);
    }

    /**
     * Método que calcula a quantidade de arquivo existente na pasta servidora
     * 
     * @return    retorna quantidade de arquivos na pasta
     */
    private int getLengthServer() {
        File subFileLib = new File("\\\\10.9.1.218\\arq\\same\\lib");
        File subFile = new File("\\\\10.9.1.218\\arq\\same\\RELATORIOS\\ATIVIDADES");
        File subFile2 = new File("\\\\10.9.1.218\\arq\\same\\RELATORIOS\\FICHAS");
        File file = new File("\\\\10.9.1.218\\arq\\same");
        return (file.listFiles().length + subFile.listFiles().length + subFileLib.listFiles().length + subFile2.listFiles().length);
    }

    /**
     * método para mostrar a data na tela principal
     *
     */
    private String data() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY"); //formata a data em dia mes e ano com 4 digitos
        Date data = new Date(); // instancia um objeto da classe data
        return (formato.format(data)); //seta a variavel na tela principal com a data formatada
    }

    /**
     * Método para verificar o horário do dia, e enviar uma mensagem de bom dia,
     * boa tarde e noite, dependendo do horário do dia
     */
    private String hora() {
        Calendar calendar = new GregorianCalendar();//Classe calendário do tipo calendário grego
        Date d = new Date();//instancia um objeto da classe data
        calendar.setTime(d); //seta o calendário com essa data
        if (calendar.get(Calendar.HOUR_OF_DAY) >= 0 && calendar.get(Calendar.HOUR_OF_DAY) < 12) { // de 0 até 12 bom dia
            return "Bom dia!";
        } else if (calendar.get(Calendar.HOUR_OF_DAY) >= 12 && calendar.get(Calendar.HOUR_OF_DAY) < 18) { // de 12 até 18 boa tarde
            return "Boa tarde!";
        } else {
            return "Boa noite!"; // acima de 18h boa noite
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

        barraProgresso = new javax.swing.JProgressBar();
        textProg = new javax.swing.JLabel();
        textStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Verificador");
        setResizable(false);

        textStatus.setText("Verificando arquivos...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(textProg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(barraProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(textStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textProg, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Progresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Progresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Progresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Progresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Progresso1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JLabel textProg;
    private javax.swing.JLabel textStatus;
    // End of variables declaration//GEN-END:variables
}
