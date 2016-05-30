package objects;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class singleMaze {

    private Pair start;
    private Pair end;
    private String name;
    private String maze;
    private Pair currentPosition;
    private int size;
    private int clue;
  

    public singleMaze(Pair start, Pair end, String maze, String name) {
        this.start = start;
        this.end = end;
        this.maze = maze;
        this.name = name;
        this.currentPosition = start;
        //need to change size
        this.size = 13;
        this.clue = this.size * ((int) start.getKey()) + (int) this.start.getValue();
    }

    public singleMaze(Pair start, Pair end, String maze) {
        this.start = start;
        this.end = end;
        this.maze = maze;
        this.currentPosition = start;
        ////////////////////////////
        this.size = 13;
    }

    public int getClue() {
        return this.clue;
    }
    
    public void setClue(int pos){
    this.clue=pos;
    }

    public Pair getStart() {
        return this.start;
    }

    public Pair getEnd() {
        return this.end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getMaze() {
        return this.maze;
    }

    public void setCurrent(Pair newPosition) {
        this.currentPosition = newPosition;
    }

    public Pair getCurrrnt() {
        return this.currentPosition;
    }

    public int getSize() {
        return this.size;
    }

    public Pair move(String direction) {
        int row = (Integer) this.currentPosition.getKey();
        int col = (Integer) this.currentPosition.getValue();
        int pos = (this.size * row) + col;//the place of cor in maze string
        char[] stringMaze = this.maze.toCharArray();
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