
package objects;


/**
 * Game.
 */
public class Game {
    private singleMaze you;
    private singleMaze other;
    private String name;
    private String mazename;
    /**
     * Constructor.
     * @param name - String
     * @param mazename - String
     * @param u - my single maze
     * @param other -other single maze.
     */
    public Game(String name, String mazename, singleMaze u, singleMaze other)
        {
            this.name = name;
            this.mazename = mazename;
            this.you = u;
            this.other = other;
        }
   
    /**
     * get maze
     * @return string maze.
     */
    public String getMaze() {
        return you.getMaze();
    }
    /**
     * get name
     * @return maze string
     */
    public String getName() {
        return this.mazename;
    }
    /**
     * get maze name
     * @return String
     */
    public String getMazeName(){
    return this.name;
    }
    /**
     * get you
     * @return my maze 
     */
    public singleMaze getYou() {
        return this.you;
    } 
    /**
     * get other
     * @return other maze
     */
    public singleMaze getOther(){
    return this.other;
    }
  
}
