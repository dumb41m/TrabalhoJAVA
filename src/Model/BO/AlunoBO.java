/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;


import Model.Data.ConexaoBanco;
import Model.Entity.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author JVM
 */
public class AlunoBO {

    Connection conn = null;
    PreparedStatement pst = null;
    //ResultSet rs = null;    
    
    public void CadastrarAluno(Aluno aluno){
        try {
            String sql = "insert into alunos (nome,sexo,dnascimento,matricula,curso,email) values (?,?,?,?,?,?)";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getSexo());
            pst.setString(3, aluno.getdNasc());
            pst.setString(4, aluno.getMatricula());
            pst.setString(5, aluno.getCurso());
            pst.setString(6, aluno.getEmail());
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
    
    public void EditarAluno(Aluno aluno){
        try {
            String sql = "update alunos set nome=? ,sexo=? ,dnascimento=? ,matricula=? ,curso=? ,email=? where id=?";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getSexo());
            pst.setString(3, aluno.getdNasc());
            pst.setString(4, aluno.getMatricula());
            pst.setString(5, aluno.getCurso());
            pst.setString(6, aluno.getEmail());
            pst.setString(7, aluno.getId());
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
    
    public void RemoverAluno(Aluno aluno){
        try {
            String sql = "delete from alunos where id = ?";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(aluno.getId()));
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Aluno Removido");

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

