/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

import Model.Data.ConexaoBanco;
import Model.Entity.Materias;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author JVM
 */
public class MateriasBO {
    Connection conn = null;
    PreparedStatement pst = null;
    
    public void CadastrarMaterias(Materias materias){
        try {
            String sql = "insert into materias (nome,carga_horaria) values (?,?)";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setString(1, materias.getNome());
            pst.setString(2, materias.getCarga_horaria());

            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Materia Cadastrada no Banco de Dados");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }finally{
            try {
                pst.close();
            } catch (Exception e) {
            }
        }
    }//fim do else das validações de inserção de informação
    
    public void EditarMaterias(Materias materias){
        try {
            String sql = "update materias set nome=? ,carga_horaria=? where id=?";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setString(1, materias.getNome());
            pst.setString(2, materias.getCarga_horaria());
            pst.setString(3, materias.getId());
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
    
    public void RemoverMaterias(Materias materias){
        try {
            String sql = "delete from materias where id = ?";
                
            conn = ConexaoBanco.ConectaDB();
               
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(materias.getId()));
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Materia Removido");

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
