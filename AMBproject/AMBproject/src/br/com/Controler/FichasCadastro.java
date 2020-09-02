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
 * @author Denner
 */
public class FichasCadastro {

    private String nome, nascimento, atendimento, user;
    private int cod;

    /**
     * Construtor para inicializar o método inserir
     *
     *
     * @param nome
     * @param nascimento
     * @param atendimento
     * @param user
     */
    public FichasCadastro(String nome, String nascimento, String atendimento, String user) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.atendimento = atendimento;
        this.user = user;
        inserir();
    }

    /**
     * Construtor para inicializar o método de editar
     *
     * @param nome
     * @param nascimento
     * @param atendimento
     * @param user
     * @param cod
     */
    public FichasCadastro(String nome, String nascimento, String atendimento, String user, int cod) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.atendimento = atendimento;
        this.user = user;
        this.cod = cod;
        editar();
    }

    /**
     * Construtor para inicializar o método excluir
     *
     * @param cod
     */
    public FichasCadastro(int cod) {
        this.cod = cod;
        excluir();
    }

    /**
     * Método para inserir atendimentos no banco
     */
    private void inserir() {
        Oracle con = new Oracle("10.9.1.210", "amb", "arquivo");
        con.connect();
        try {
            PreparedStatement st = con.c.prepareStatement("insert into ATENDIMENTOS values(?,?,?,(select ID_LOGIN from USUARIOS where LOGIN = '" + this.user + "'),sysdate,COD.NEXTVAL)");
            st.setString(1, this.nome.trim().replaceAll("  +", " "));// antes de inserir corrige os nomes com mais de um espaço
            st.setString(2, this.nascimento);
            st.setString(3, this.atendimento);
            int rs = st.executeUpdate();//excuteUpdate ideal para DML
            if (rs > 0) {//resultado maior que 0, significa que não trouxe erros
                JOptionPane.showMessageDialog(null, "Ficha cadastrada com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a ficha \n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FichasCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.disconnect();
        }
    }

    /**
     * Método para editar os atendimentos no banco
     */
    private void editar() {
        Oracle con = new Oracle("10.9.1.210", "amb", "arquivo");
        con.connect();
        try {
            PreparedStatement st = con.c.prepareStatement("Update ATENDIMENTOS set NOME = ?,DATA_NASCIMENTO = ?,DATA_ATENDIMENTO = ?,ID_LOGIN =(select ID_LOGIN from USUARIOS where LOGIN = '" + this.user + "'),DATA_CADASTRO = sysdate where CODIGO = ?");
            st.setString(1, this.nome.trim().replaceAll("  +", " "));
            st.setString(2, this.nascimento);
            st.setString(3, this.atendimento);
            st.setInt(4, this.cod);
            int x = st.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Ficha atualizada com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a ficha \n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FichasCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.disconnect();
        }
    }

    /**
     *Método para excluir os atendimentos no banco
     */
    private void excluir() {
        Oracle con = new Oracle("10.9.1.210", "amb", "arquivo");
        con.connect();
        try {
            PreparedStatement st = con.c.prepareStatement("delete from ATENDIMENTOS where CODIGO =" + this.cod + "");
            int x = st.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Ficha excluída com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a ficha \n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FichasCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.disconnect();
        }
    }
}
