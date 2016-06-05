
import com.sun.javafx.UnmodifiableArrayList;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import objects.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author revit
 */
public class SharedInfo {
    
    static  private Map<String, User> userList;
    static private boolean initiated=false;
    static private SharedInfo myinfo;
    private String size;
    private SharedInfo(){
        userList = new HashMap<>();
    }
    
    public static SharedInfo getSharedInfo(){
        if (!initiated){
            myinfo = new SharedInfo();
            initiated = true;
        }
        return myinfo;
    }

    public static Map<String,User> getUserList() {
        return userList;
    }

    public void addUserList(String name, User userList) {
        SharedInfo.userList.put(name, userList);
    }
    
    public void SetSize(String s) {
        size = s;
    }
    public String GetSize(){
        return size;
    }
    
    public Boolean CheckIfNameInList(String name) {
        if (SharedInfo.userList.get(name) == null) {
            return false;
        } else {
            return true;
        }
    }
}
