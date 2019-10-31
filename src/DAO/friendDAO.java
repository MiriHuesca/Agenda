/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Friend;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 52229
 */
public class friendDAO {
     public int insert(Friend friend){
    Connection con=null;
    PreparedStatement st=null;
    int id=0;
    try{
        con=Conexion.getConnection();
        st=con.prepareStatement("call insertFriend(?,?,?,?,?)" , PreparedStatement.RETURN_GENERATED_KEYS);
        st.setString(1, friend.getName());
        st.setString(2, friend.getPhone());
        st.setString(3,friend.getAddress());
        st.setDate(4,friend.getBirthday());
        st.setBinaryStream(5, new FileInputStream(new File(friend.getImage())),(int) new File(friend.getImage()).length());
        id=st.executeUpdate();
        ResultSet rs=st.getGeneratedKeys();
        if (rs.next()) {
            id=rs.getInt(1);
        }
    }catch(Exception e){
            System.out.println("Fail "+e);
    } finally{
    Conexion.close(con);
    Conexion.close(st);
}
    return id;
}
      public DefaultTableModel cargarModelo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        ResultSet rs = null;
        String encabezados[] = {"Id","Name","Phone number"};
        try {
            con = DAO.Conexion.getConnection();
            st = con.prepareStatement("call select_all_friend");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];
                Friend pojo = inflaPOJO(rs);
                ob[0] = pojo.getIdFriend();
                ob[1] = pojo.getName();
                ob[2] = pojo.getPhone();
                
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla alumno " + e);
        } finally {
            DAO.Conexion.close(con);
            DAO.Conexion.close(st);
            DAO.Conexion.close(rs);
        }
        return dt;
        
        }
      public DefaultComboBoxModel cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel dt = null;
        try {
            con = DAO.Conexion.getConnection();
            st = con.prepareStatement("call select_all_friend");
            dt = new DefaultComboBoxModel();
            ResultSet rs= st.executeQuery();
            dt.addElement("Seleccione a su amigo");
            while (rs.next()) {
                Friend pojo = inflaPOJO(rs);
                
                dt.addElement(pojo);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla alumno " + e);
        } finally {
            DAO.Conexion.close(con);
            DAO.Conexion.close(st);
        }
        return dt;
        
        }
      
       private static Friend inflaPOJO(ResultSet rs) {

       Friend pojo = new Friend();
        try {
            pojo.setIdFriend(rs.getInt("idfriend"));
            pojo.setName(rs.getString("name"));
            pojo.setPhone(rs.getString("phone"));
            pojo.setAddress(rs.getString("address"));
            pojo.setBirthday(rs.getDate("birthday"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo materia: " + ex);
        }
        return pojo;
    }
       public static Friend selectFriend(int id){
           Connection con=null;
           PreparedStatement st=null;
           Friend pojo= new Friend();
           try{
            con = DAO.Conexion.getConnection();
            st = con.prepareStatement("call select_a_friend(?)");
            st.setInt(1, id);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                pojo= inflaPOJO(rs);
            }
           }catch(SQLException ex){
               System.out.println("Error : " + ex);
           }finally{
               Conexion.close(con);
               Conexion.close(st);
           }
           return pojo;
       }
       public boolean delete_friend(int id){
        Connection con=null;
        PreparedStatement st=null;
         try{
            con=DAO.Conexion.getConnection();
            st=con.prepareStatement("call delete_friend(?)");
            st.setInt(1, id);
            int x=st.executeUpdate(); 
             if (x==0) {
                 return false;
             }
         }catch(Exception e){
             System.out.println("Error al eliminar amigo"+ e);
             return false;
         }finally{
             DAO.Conexion.close(con);
             DAO.Conexion.close(st);
         }
         return true;
}
       public static void exportFriend(String exportFile){
            Connection con=null;
        PreparedStatement st=null;
        boolean success;
        try{
             con=DAO.Conexion.getConnection();
            st=con.prepareStatement("select*from friend into outfile '"
            +exportFile+"' fields terminated by ';' optionally enclosed by '\\\"' lines terminated by '\\n\\r'");
            success=st.execute();
        }catch(Exception e){
            System.out.println("Error al exportar amigos" +e);
        }finally{
             DAO.Conexion.close(con);
             DAO.Conexion.close(st);
        }
       }
      }




              
        
        
        
       
    
    

