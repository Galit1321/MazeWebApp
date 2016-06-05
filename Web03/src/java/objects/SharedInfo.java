package objects;

import java.util.HashMap;
import java.util.Map;
import objects.User;

/**
 * SharedInfo - keep info for everyone.
 * Singelton.
 */
public class SharedInfo {
    
    static  private Map<String, User> userList;
    static private boolean initiated=false;
    static private SharedInfo myinfo;
    private String size;
    /**
     * private Costructor.
     */
    private SharedInfo(){
        userList = new HashMap<>();
    }
    /**
     * get shareInfo
     * @return Shared info.
     */
    public static SharedInfo getSharedInfo(){
        if (!initiated){
            myinfo = new SharedInfo();
            initiated = true;
        }
        return myinfo;
    }
    /**
     * get user list
     * @return user list.
     */
    public static Map<String,User> getUserList() {
        return userList;
    }
    /**
     * add user to the list
     * @param name - String
     * @param userList - User
     */
    public void addUserList(String name, User userList) {
        SharedInfo.userList.put(name, userList);
    }
    /**
     * set size
     * @param s - string - size. 
     */
    public void SetSize(String s) {
        size = s;
    }
    /**
     * get size.
     * @return size
     */
    public String getSize(){
        return size;
    }
    /**
     * check if name in the list.
     * @param name - String
     * @return true if the name in false else.
     */
    public Boolean CheckIfNameInList(String name) {
        if (SharedInfo.userList.get(name) == null) {
            return false;
        } else {
            return true;
        }
    }
}
