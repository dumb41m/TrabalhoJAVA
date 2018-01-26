/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Data;

/**
 *
 * @author JVM
 */

import java.sql.*;
import javax.swing.*;

public class ConexaoBanco {
    
    Connection conn = null;
    public static Connection ConectaDB(){

        try{
            //carrega o driver
            Class.forName("com.mysql.jdbc.Driver");
            //estabelece conexão com o banco
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notas","root","");
            //JOptionPane.showMessageDialog(null, "Conexão Aceita");
            //retorno do objeto de conexão
            return conn;

        }catch (Exception e){

            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
