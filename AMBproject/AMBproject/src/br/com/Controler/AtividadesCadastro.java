/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controler;

import br.com.JDBC.Oracle;
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
public class AtividadesCadastro {

    private int cod, pront;
    private String nome, data, dataAlta, login, conv, medico, obs, tipoAtendimento, descricao, status, solicitante;
    private Oracle con;

    public AtividadesCadastro(int pront, String nome, String data, String dataAlta, String login, String conv, String medico,
            String obs, String tipoAtendimento, String descricao, String status, String solicitante) {
        this.con = new Oracle("10.9.1.210", "amb", "arquivo");
        this.pront = pront;
        this.nome = nome;
        this.data = data;
        this.dataAlta = dataAlta;
        this.login = login;
        this.conv = conv;
        this.medico = medico;
        this.obs = obs;
        this.tipoAtendimento = tipoAtendimento;
        this.descricao = descricao;
        this.status = status;
        this.solicitante = solicitante;
        inserirAtividade();
    }

    public AtividadesCadastro(int cod, int pront, String nome, String data, String dataAlta, String conv, String medico,
            String obs, String tipoAtendimento, String descricao, String status, String solicitante, String login) {
        this.con = new Oracle("10.9.1.210", "amb", "arquivo");
        this.login = login;
        this.cod = cod;
        this.pront = pront;
        this.nome = nome;
        this.data = data;
        this.dataAlta = dataAlta;
        this.conv = conv;
        this.medico = medico;
        this.obs = obs;
        this.tipoAtendimento = tipoAtendimento;
        this.descricao = descricao;
        this.status = status;
        this.solicitante = solicitante;
        editarAtividade();
    }

    public AtividadesCadastro(int cod) {
        this.con = new Oracle("10.9.1.210", "amb", "arquivo");
        this.cod = cod;
        excluirAtividade();
    }

    private void inserirAtividade() {
        this.con.connect();
        String sql = "INSERT INTO ATIVIDADES VALUES (CODIGO.NEXTVAL,?,?,SYSDATE,SYSDATE+30,?,(SELECT ID_LOGIN FROM USUARIOS WHERE LOGIN = '" + this.login + "'),?,?,?,?,?,NULL,?,?,?)";
        String sqlii = "INSERT INTO HISTORICO VALUES (CODIGO.CURRVAL,SYSDATE,(SELECT ID_LOGIN FROM USUARIOS WHERE LOGIN = '" + this.login + "'),'ATIVIDADE CADASTRADA (PENDENTE)', NUM_HIST.NEXTVAL)";
        PreparedStatement st;
        try {
            con.c.setAutoCommit(false);
            st = this.con.c.prepareStatement(sql);
            st.setString(1, this.status);
            st.setString(2, this.nome.replaceAll("  +", " ").trim());
            st.setString(3, this.descricao.replaceAll("  +", " ").trim());
            st.setString(4, this.dataAlta);
            st.setString(5, this.data);
            st.setString(6, this.conv);
            st.setString(7, this.medico);
            st.setInt(8, this.pront);
            st.setString(9, this.obs.replaceAll("  +", "").trim());
            st.setString(10, this.tipoAtendimento);
            st.setString(11, this.solicitante);
            int x = st.executeUpdate();
            if (x > 0) {
                int y = st.executeUpdate(sqlii);
                if (y > 0) {
                    JOptionPane.showMessageDialog(null, "Atividade cadastrada com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    this.con.c.commit();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a atividade \n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AtividadesCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.con.disconnect();
        }

    }

    private void editarAtividade() {
        this.con.connect();
        ResultSet rs;
        String sql;
        if(this.status.equals("FINALIZADA") || this.status.equals("CANCELADA")){
            sql = "UPDATE ATIVIDADES SET STATUS = ?,NOME = ?,DETALHAMENTO = ?,DATA_ALTA = ?, DATA = ?,CONV = ?, MEDICO = ?, PRONT = ?, "
                + "DATA_ENC = SYSDATE,OBS = ?,TIPO_ATENDIMENTO = ?, SOLICITANTE = ? "
                + "WHERE COD = ?";
        }else{
            sql = "UPDATE ATIVIDADES SET STATUS = ?,NOME = ?,DETALHAMENTO = ?,DATA_ALTA = ?, DATA = ?,CONV = ?, MEDICO = ?, PRONT = ?, "
                + "DATA_ENC = NULL,OBS = ?,TIPO_ATENDIMENTO = ?, SOLICITANTE = ? "
                + "WHERE COD = ?";
        }
        String sqlii = "INSERT INTO HISTORICO VALUES (" + this.cod + ",SYSDATE,(SELECT ID_LOGIN FROM USUARIOS WHERE LOGIN = '" + this.login + "'),'ATIVIDADE " + this.status + "', NUM_HIST.NEXTVAL)";
        PreparedStatement st;
        try {
            st = this.con.c.prepareStatement("SELECT NUM_HISTORICO,OBS FROM (SELECT NUM_HISTORICO,OBS FROM HISTORICO WHERE COD = ? ORDER BY DATA DESC)WHERE ROWNUM = 1 AND OBS LIKE ?");
            st.setInt(1, this.cod);
            st.setString(2, "%"+this.status+"%");
            rs = st.executeQuery();
            if(rs.next()){
                if(rs.getString("OBS").contains(this.status)){
                    sqlii = "UPDATE HISTORICO SET ID_LOGIN = (SELECT ID_LOGIN FROM USUARIOS WHERE LOGIN = '" + this.login + "'), DATA = SYSDATE WHERE NUM_HISTORICO ="+rs.getInt("NUM_HISTORICO");
                }
            }
            con.c.setAutoCommit(false);
            st = this.con.c.prepareStatement(sql);
            st.setString(1, this.status);
            st.setString(2, this.nome.trim().replaceAll(" +"," "));
            st.setString(3, this.descricao.trim().replaceAll(" +"," "));
            st.setString(4, this.dataAlta);
            st.setString(5, this.data);
            st.setString(6, this.conv);
            st.setString(7, this.medico);
            st.setInt(8, this.pront);
            st.setString(9, this.obs);
            st.setString(10, this.tipoAtendimento);
            st.setString(11, this.solicitante);
            st.setInt(12, this.cod);
            int x = st.executeUpdate();
            if (x > 0) {
                int y = st.executeUpdate(sqlii);
                if (y > 0) {
                    JOptionPane.showMessageDialog(null, "Atividade atualizada com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    this.con.c.commit();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a atividade \n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AtividadesCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.con.disconnect();
        }

    }

    private void excluirAtividade() {
        this.con.connect();
        String sql = "DELETE FROM ATIVIDADES WHERE COD = ?";
        PreparedStatement st;
        try {
            con.c.setAutoCommit(false);
            st = this.con.c.prepareStatement(sql);
            st.setInt(1, this.cod);
            int x = st.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Atividade excluída com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
                this.con.c.commit();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a atividade \n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AtividadesCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.con.disconnect();
        }

    }

}
