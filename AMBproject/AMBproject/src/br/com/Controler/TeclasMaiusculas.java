/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controler;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author User
 */
public class TeclasMaiusculas extends PlainDocument {
    @Override
    public void insertString(int i, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
        super.insertString(i, str.toUpperCase().replaceAll("([^(a-zA-Z) |[\\s]])",""), attr);
    }
    
    public void replace(int i, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
        super.insertString(i, str.toUpperCase().replaceAll("([^(a-zA-Z) |[\\s]])",""), attr);
    }
}
