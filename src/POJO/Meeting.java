/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Timestamp;

/**
 *
 * @author 52229
 */
public class Meeting {
    private int idMeeting;
    private String place;
    private Timestamp date_of;

    public Meeting() {
    }

    public Meeting(int idMeeting, String place, Timestamp date_of) {
        this.idMeeting = idMeeting;
        this.place = place;
        this.date_of = date_of;
    }

    public int getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(int idMeeting) {
        this.idMeeting = idMeeting;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Timestamp getDate_of() {
        return date_of;
    }

    public void setDate_of(Timestamp date_of) {
        this.date_of = date_of;
    }

  

   
}
