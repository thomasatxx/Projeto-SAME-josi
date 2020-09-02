/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controler;

import br.com.JDBC.Oracle;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class HistoricoCadastro {

    private String descricao, login;
    private int cod;
    private Oracle con;

    /**
     * Construtor da classe
     *
     * @param cod cod da solicitaçãp
     * @param descricao descrição da observação
     * @param login login de quem inseriu
     */
    public HistoricoCadastro(int cod, String descricao, String login) {
        this.con = new Oracle("10.9.1.210", "amb", "arquivo");
        this.descricao = descricao;
        this.cod = cod;
        this.login = login;
        inserirHistorico();
    }

    /**
     * Método para inserir um histórico
     */
    private void inserirHistorico() {
        con.connect();//conectar no banco
        String sql = "INSERT INTO HISTORICO VALUES(?,SYSDATE,(SELECT ID_LOGIN FROM USUARIOS WHERE LOGIN = ? ),?,NUM_HIST.NEXTVAL)";//comando sql
        try {
            PreparedStatement st = this.con.c.prepareStatement(sql);//preparar uma Statement
            st.setInt(1, this.cod);
            st.setString(2, this.login);
            st.setString(3, this.descricao.trim().replaceAll(" +"," "));
            int x = st.executeUpdate();//excultar a ação
            if (x > 0) {//se a inserção ocorreu perfeitamente
                JOptionPane.showMessageDialog(null, "O histórico foi inserido!", "Info", JOptionPane.INFORMATION_MESSAGE);//mensagem de conclusão
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao inserir histórico!", "Erro", JOptionPane.ERROR_MESSAGE);//mensagem de exception
            Logger.getLogger(HistoricoCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.disconnect();//disconecta do banco
        }
    }

//    private void excluirHistorico(){
//        con.connect();
//        String sql = "DELETE FROM HISTORICO WHERE NUM_HIST = ?";
//        try {
//            PreparedStatement st = this.con.c.prepareStatement(sql);
//            st.setInt(1,this.cod);
//            int x = st.executeUpdate();
//            if(x > 0){
//                JOptionPane.showMessageDialog(null, "O histórico foi excluído!", "Info", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Falha ao inserir histórico!", "Erro", JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(HistoricoCadastro.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            con.disconnect();
//        }
//    }
}
