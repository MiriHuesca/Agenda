/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Friend;
import POJO.Meeting;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 52229
 */
public class meetingDAO {
      public int insertar(Meeting meeting){
    Connection con=null;
    PreparedStatement st=null;
    int id=0;
    try{
        con=Conexion.getConnection();
        st=con.prepareStatement("call insertMeeting(?,?)" , PreparedStatement.RETURN_GENERATED_KEYS);
        st.setString(1, meeting.getPlace());
        st.setTimestamp(2, meeting.getDate_of());
        
        id=st.executeUpdate();
        ResultSet rs=st.getGeneratedKeys();
        if (rs.next()) {
            id=rs.getInt(1);
        }
    }catch(Exception e){
            System.out.println("fail "+e);
    } finally{
    Conexion.close(con);
    Conexion.close(st);
}
    return id;
}
}
