/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;


import Model.Data.ConexaoBanco;
import Model.Entity.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author JVM
 */
public class ProfessorBO {

    Connection conn = null;
    PreparedStatement pst = null;
    //ResultSet rs = null;    
    
    public void CadastrarProfessores(Professor professor){
        try {
            String sql = "insert into professores (nome,sexo,dnascimento,titulo,salario,telefone) values (?,?,?,?,?,?)";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setString(2, professor.getSexo());
            pst.setString(3, professor.getdNasc());
            pst.setString(4, professor.getTitulo());
            pst.setString(5, professor.getSalario());
            pst.setString(6, professor.getTelefone());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Cadastrado no Banco de Dados");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }finally{
            try {
                pst.close();
            } catch (Exception e) {
            }
        }
    }//fim do else das validações de inserção de informação
    
    public void EditarProfessor(Professor professor){
        try {
            String sql = "update professores set nome=? ,sexo=? ,dnascimento=? ,titulo=? ,salario=? ,telefone=? where id=?";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setString(2, professor.getSexo());
            pst.setString(3, professor.getdNasc());
            pst.setString(4, professor.getTitulo());
            pst.setString(5, professor.getSalario());
            pst.setString(6, professor.getTelefone());
            pst.setString(7, professor.getId());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Atualização Realizada");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }finally{
            try {
                pst.close();
            } catch (Exception e) {
            }
        }
    }
    
    public void RemoverProfessor(Professor professor){
        try {
            String sql = "delete from professores where id = ?";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(professor.getId()));
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Professor Removido");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }finally{
            try {
                pst.close();
            } catch (Exception e) {
            }
        }
    }
}

