package objects;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 * Convert from Json.
 */
public class ConvertFromJson {

  //  SharedInfo si = SharedInfo.getSharedInfo();
    public Map<String, String> Serlize;
    public singleMaze maze;
    public Game g;
    public List<String> moves;
   // public String move;
    public String Type;
    public singleMaze sol;
    public Gson deserializer = new Gson();
    private Boolean gotMove;
    private Boolean inSession;

    /**
     * get move
     *
     * @return move.
     */
    public String getMove() 
    {
        String move=moves.get(0);
        this.moves.remove(0);
        return move;
    }

    

    /**
     * get got move.
     *
     * @return got move.
     */
    public Boolean getGotMove() {
        return gotMove;
    }

    /**
     * got move.
     *
     * @param gotMove - boolean.
     */
    public void setGotMove(Boolean gotMove) {
        this.gotMove = gotMove;
    }

    /**
     * Constractor.
     */
    public ConvertFromJson() {
        gotMove = false;
        
        this.inSession = false;
    }
    public void resetLst(){
    this.moves=new ArrayList<>();
    }
    /**
     * in session
     * @return inSession.
     */
    public Boolean getInSession() {
        return inSession;
        
    }

    /// <summary>
    /// constructor that get serlize string and turn it to a dictionary 
    /// </summary>
    /// <param name="json">selize dict</param>
    public void deserlize(String json) {
        Map<String, String> map = new HashMap<String, String>();
        map = (Map<String, String>) deserializer.fromJson(json, map.getClass());
        // Map<String, String> dic = deserializer.fromJson(response, String);
        this.Type = map.get("Type");
        String s = map.get("Content");
        Map<String, String> map2 = new HashMap<String, String>();
        this.Serlize = (Map<String, String>) deserializer.fromJson(s, map2.getClass());
        findClass();
    }

    public void findClass() {
        switch (this.Type) {
            case "1":
                CreateMaze();
                break;
            case "2":
                CreateSol();
                break;
            case "3":
                resetLst();
                ConvertStartGame();
                break;
            case "4":
                ConvertPlay();
                break;
            case "5":
                this.g = null;
                this.inSession = false;
                break;
            default:
                break;

        }
    }

    /**
     * *
     * /// create a single game by the value of serlize dictionary      *
     * /returns that single maze this serlize repersent
     */
    public void CreateMaze() {
    SharedInfo si = SharedInfo.getSharedInfo();    
        String maze = this.Serlize.get("Maze");
        String n = this.Serlize.get("Name");
        Pair start = CreatePair(this.Serlize.get("Start"));
        Pair end = CreatePair(this.Serlize.get("End"));
        singleMaze m = new singleMaze(start, end, maze, n, Integer.parseInt(si.getSize()));
        this.maze = m;
    }

    /// create coordinate of start and end of serlize sting in this.Serlize
    /// </summary>
    /// <param name="pair">selize pair</param>
    /// <returns>deselize of pair</returns>
    public Pair CreatePair(String pair) {
        String[] des = pair.split("@");
        int r = Integer.valueOf(des[0]);
        int c = Integer.valueOf(des[1]);
        return new Pair(r, c);
    }

    /// <summary>
    /// convert the maze in game
    /// </summary>
    /// <param name="game"></param>
    /// <returns></returns>
    public singleMaze WithoutName(String game) {
       SharedInfo si = SharedInfo.getSharedInfo();
        Map<String, String> ser = new HashMap<String, String>();
        ser = (Map<String, String>) deserializer.fromJson(game, ser.getClass());
        //ser = JsonConvert.DeserializeObject<Dictionary<string, string>>(game);
        String maze = ser.get("Maze");
        Pair start = CreatePair(ser.get("Start"));
        Pair end = CreatePair(ser.get("End"));
        singleMaze sm = new singleMaze(start, end, maze, Integer.parseInt(si.getSize()));
        return sm;
    }

    /// <summary>
    /// convert the msg of game
    /// </summary>
    public void ConvertStartGame() {
        this.inSession = true;
        String name = this.Serlize.get("Name");
        String mazename = this.Serlize.get("MazeName");
        singleMaze u = WithoutName(this.Serlize.get("You"));
        // u= this.Serlize.get("MazeName");
        singleMaze other = WithoutName(this.Serlize.get("Other"));
        Game g = new Game(name, mazename, u, other);
        //this.numOfMove=0;
        resetLst();
        this.g = g;
    }

    /// <summary>
    ///   convert a move of the yriv 
    /// </summary>
    public void ConvertPlay() {
        String[] s= this.Serlize.get("Move").split("\r");
       // this.move=s[0];
        gotMove = true;
        this.moves.add(s[0]);
         
    }
    /**
     * CreateSol
     * create the solution.
     */
    private void CreateSol() {
        SharedInfo si = SharedInfo.getSharedInfo();
        String maze = this.Serlize.get("Maze");
        String n = this.Serlize.get("Name");
        Pair start = CreatePair(this.Serlize.get("Start"));
        Pair end = CreatePair(this.Serlize.get("End"));
        singleMaze m = new singleMaze(start, end, maze, n, Integer.parseInt(si.getSize()));
        this.sol = m;
    }
}
