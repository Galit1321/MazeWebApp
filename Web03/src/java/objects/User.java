package objects;

import java.io.IOException;
import javafx.util.Pair;

/**
 * User.
 */
public class User {

    public String name;
    public String userName;
    public String password;
    public String mail;
    public String icon;
    public Model mode;
    private singleMaze myMaze;
    private singleMaze other;

    /**
     * get other.
     *
     * @return single maze.
     */
    public singleMaze getOther() {
        return other;
    }

    /**
     * set other
     *
     * @param other - singleMaze.
     */
    public void setOther(singleMaze other) {
        this.other = other;
    }

    /**
     * Constructor.
     *
     * @param name - string
     * @param un - string
     * @param pw - string
     * @param mail - string
     * @param icon - string
     */
    public User(String name, String un, String pw, String mail, String icon) {
        this.name = name;
        this.mail = mail;
        mode = new Model();
        this.userName = un;
        this.password = pw;
        this.icon = icon;

    }

    /**
     * solStr
     *
     * @return string of solution
     */
    public String getSolStr() {
        return this.mode.getJson().sol.getMaze();
    }

    /**
     * Clean
     */
    public void clean() {
        this.myMaze = null;
        this.mode.getJson().maze = null;
        this.mode.getJson().sol = null;

    }
    /**
     * get next clue
     * @return int - the next clue position.
     */
    public int GetNxtClue() {
        Pair p;
        int pos;
        String[] dir = {"up", "down", "left", "right"};
        for (int i = 0; i < 4; i++) {
            p = this.myMaze.move(this.getMaze().getCurrrnt(), dir[i]);////check the dirction
            if (p != null) {
                pos = (int) p.getKey() * this.myMaze.getSize() + (int) p.getValue();
                char[] solv = this.getSolStr().toCharArray();
                if (solv[pos] == '2' && (!(this.myMaze.getClue().contains(pos)))) {
                    return pos;
                }
            }
        }
        return this.myMaze.getClue().get(this.myMaze.getClue().size() - 1);
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
    /**
     * checkPassword
     * @param pass - String
     * @return true if the pass equals false else.
     */
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }
    /**
     * set Maze
     * @param maze single maze 
     */
    public void setMaze(singleMaze maze) {
        this.myMaze = maze;

    }
    /**
     *  getmaze
     * @return single maze. 
     */
    public singleMaze getMaze() {
        return this.myMaze;
    }

    /**
     * close.
     * @throws IOException 
     */
    public void Close() throws IOException {
        //clean();
        //this.mode.Close();
    }
}
