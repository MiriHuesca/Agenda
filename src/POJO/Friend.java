/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;

/**
 *
 * @author 52229
 */
public class Friend {
    private int idFriend;
    private String name;
    private String phone;
    private String address;
    private Date birthday;
    private String image;

    public Friend() {
    }

    public Friend(int idFriend, String name, String phone, String address, Date birthday, String image) {
        this.idFriend = idFriend;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.image = image;
    }

    public Friend(String name, String phone, String address, Date birthday, String image) {
       this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.image = image;
    }

    public int getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(int idFriend) {
        this.idFriend = idFriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
       return getName();
    }

   

    
   
    
    
}
