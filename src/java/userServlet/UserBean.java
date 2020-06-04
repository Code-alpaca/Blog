/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userServlet;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class UserBean {

    private String username;
    private String email;
    private String password;
    private String gender;
    private String birthday;
    private String phone;
    private String address;
    private String personnal;
    private int id;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the personnal
     */
    public String getPersonnal() {
        return personnal;
    }

    /**
     * @param personnal the personnal to set
     */
    public void setPersonnal(String personnal) {
        this.personnal = personnal;
    }

    /**
     * @return the userid
     */
    public int getId() {
        return id;
    }

    /**
     * @param userid the userid to set
     */
    public void setId(int userid) {
        this.id = userid;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
