/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.IOException;

/**
 *
 * @author גליתונופר
 */
public class User {

    public String name;
    public String userName;
    public String password;
    public String mail;
    public String icon;
    public Model mode;
    public singleMaze myMaze;

    public User(String name, String un, String pw, String mail, String icon) {
        this.name = name;
        this.mail = mail;
        mode = new Model();
        this.userName = un;
        this.password = pw;
        this.icon = icon;
    }

    /*
    override eq to check if it contain in 
    a Contianer such as map and list
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!User.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final User other = (User) obj;
        //check to see of it is the same name
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    public void setMaze(singleMaze maze) {
        this.myMaze = maze;
    }
    
    public singleMaze getMaze() {
        return this.myMaze;
    }
  public void Close() throws IOException{
  this.mode.Close();
  }  
}