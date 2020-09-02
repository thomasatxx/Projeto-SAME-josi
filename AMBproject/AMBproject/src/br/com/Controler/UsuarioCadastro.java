/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.JDBC.Oracle;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Denner
 */
public class UsuarioCadastro {
    
    private String login,senha,perfil;
    /**
     * Construtor para ser declarado para exclusão de usuários do banco
     * @param login     login (unique) para ser excluido no banco
     */
    public UsuarioCadastro(String login){
        this.login = login;
        excluir();
    }
    
    /**
     * Construtor para ser declarado para inserir usuário no banco
     * 
     * @param login     login a ser inserido
     * @param senha     senha a ser inserida
     * @param perfil    perfil a ser inserida
     */
    public UsuarioCadastro(String login, String senha, String perfil){
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        inserir();
    }
    
    /**
     * Método para inserir usuário segue abaixo os comentários
     */
    private void inserir(){
       Oracle con = new Oracle("10.9.1.210","amb","arquivo");//cria a conexão do banco
       con.connect();// conecta com o banco
       String sql = "insert into USUARIOS values(ID.NEXTVAL,?,?,?)";//sql para executar
       ResultSet rs = null;
        try {
            PreparedStatement st = con.c.prepareStatement(sql); //criar uma Statement para query
            st.setString(1,this.login);// da "?" será preenchido com respectivos nome senha perfil
            st.setString(2,new SHA256().criptografar(String.valueOf(this.senha.trim().replaceAll(" +",""))));// a senha não poderá ter espaços em branco
            st.setString(3,this.perfil);
            rs = st.executeQuery();//execulta o sql
            if(rs.next()){//verifica se o banco trouxe resultados 
                JOptionPane.showMessageDialog(null,"Usuário: "+this.login+" inserido com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);// se sim, msg de sucesso
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao inserir o: "+this.login+" no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);// se não, msg de erro
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir o: "+this.login+" no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"Erro no banco de dados \n"+ex);// excessão caso o banco falha
            Logger.getLogger(UsuarioCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.disconnect();// por fim disconecta do banco
        }
    }
    /**
     * Método para excluir usuário, igualmente comentários aos dois métodos declarados nessa classe 
     */
    private void excluir(){
        Oracle con = new Oracle("10.9.1.210","amb","arquivo");
        con.connect();
        ResultSet rs = null;
        try {
            PreparedStatement st = con.c.prepareStatement("delete from USUARIOS where LOGIN = ?");
            st.setString(1,this.login);
            rs = st.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Usuário: "+this.login+" excluído com sucesso","Info",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao excluir o usuário: "+this.login,"Erro",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no banco de dados \n"+ex);
            Logger.getLogger(UsuarioCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.disconnect();
        }
    }
}
