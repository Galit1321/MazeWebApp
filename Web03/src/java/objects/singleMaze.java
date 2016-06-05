package objects;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 * Single maze object.
 */
public class singleMaze {

    private Pair start;
    private Pair end;
    private String name;
    private String maze;
    private Pair currentPosition;
    private int size;
    private List<Integer> clue;

    /**
     * Constructor.
     * @param start - pair
     * @param end - pair
     * @param maze - string
     * @param name - string
     */
    public singleMaze(Pair start, Pair end, String maze, String name) {
        this.start = start;
        this.end = end;
        this.maze = maze;
        this.name = name;
        this.currentPosition = start;
        //need to change size
        this.size = 13;
        int first = this.size * ((int) start.getKey()) + (int) this.start.getValue();
        this.clue = new ArrayList<Integer>();
        this.clue.add(first);
    }

    /**
     * Constructor.
     * @param start - pair
     * @param end - pair
     * @param maze - String.
     */
    public singleMaze(Pair start, Pair end, String maze) {
        this.start = start;
        this.end = end;
        this.maze = maze;
        this.currentPosition = start;
        ////////////////////////////
        this.size = 13;
        int first = this.size * ((int) start.getKey()) + (int) this.start.getValue();
        this.clue = new ArrayList<Integer>();
        this.clue.add(first);
    }

    /**
     * get clue.
     * @return list for clue.
     */
    public List<Integer> getClue() {
        return this.clue;
    }

    /**
     * set clue.
     * @param pos - int position 
     */
    public void setClue(int pos) {
        this.clue.add(pos);
    }

    /**
     * get start
     * @return start pair.
     */
    public Pair getStart() {
        return this.start;
    }

    /**
     * get end
     * @return end pair. 
     */
    public Pair getEnd() {
        return this.end;
    }

    /**
     * set Name
     * @param name - String. 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get name
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * get maze
     * @return String maze.
     */
    public String getMaze() {
        return this.maze;
    }

    /**
     * set current
     * @param newPosition - Pair 
     */
    public void setCurrent(Pair newPosition) {
        this.currentPosition = newPosition;
    }

    /**
     * get currrnt
     * @return current position.
     */
    public Pair getCurrrnt() {
        return this.currentPosition;
    }

    /**
     * get size
     * @return size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * move 
     * @param cor - Pair.
     * @param direction - Pair.
     * @return new position Pair.
     */
    public Pair move(Pair cor, String direction) {
        int row = (Integer) cor.getKey();
        int col = (Integer) cor.getValue();
        int pos = (this.size * row) + col;//the place of cor in maze string
        char[] stringMaze = this.maze.toCharArray();
        //switch where to move.
        switch (direction) {
            case "up"://up
                if ((row - 2 >= 0) && (stringMaze[pos - this.size] != '1')) {
                    row = row - 2;
                }
                break;
            case "down"://down
                if ((row + 2 < this.size) && (stringMaze[pos + (this.size)] != '1')) {
                    row = row + 2;
                }
                break;
            case "right"://right
                if ((col + 2 < this.size) && (stringMaze[pos + 1] != '1')) {
                    col += 2;
                }
                break;
            case "left"://le ft
                if ((col - 2 >= 0) && (stringMaze[pos - 1] != '1')) {
                    col -= 2;
                }
                break;
        }
        return new Pair(row, col);
    }

}
