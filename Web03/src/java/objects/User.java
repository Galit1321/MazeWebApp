/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.IOException;
import javafx.util.Pair;

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
<<<<<<< HEAD
    private singleMaze myMaze;
    //public String solStr;
   
=======
    public singleMaze myMaze;

>>>>>>> remotes/origin/stam1
    public User(String name, String un, String pw, String mail, String icon) {
        this.name = name;
        this.mail = mail;
        mode = new Model();
        this.userName = un;
        this.password = pw;
        this.icon = icon;
        
    }

  
    public String getSolStr() {
        return this.mode.getJson().solv.getMaze();
    }
 public int GetNxtClue()
        {
            Pair p;
            int pos;
            String[] dir ={ "up", "down", "left", "right" };
            for (int i=0; i<4;i++)
            {
                p= this.myMaze.move(dir[i]);////check the dirction
                if (p != null)
                {
                   pos = (int)p.getKey()*this.myMaze.getSize()+(int)p.getValue();
                   char[] solv=this.getSolStr().toCharArray();
                    if (solv[pos]=='2')
            {
                        return pos;
                    }
                }
            }  
            return this.myMaze.getClue(); 
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
<<<<<<< HEAD
       
    }

    public singleMaze getMaze() {
        return this.myMaze;
    }

    public void Close() throws IOException {
        this.mode.Close();
    }
=======
    }
    
    public singleMaze getMaze() {
        return this.myMaze;
    }
    
>>>>>>> remotes/origin/stam1
}
