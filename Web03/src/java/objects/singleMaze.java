/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import javafx.util.Pair;

public class singleMaze {

    private Pair start;
    private Pair end;
    private String name;
    private String maze;

    public singleMaze(Pair start, Pair end, String maze, String name) {
        this.start = start;
        this.end = end;
        this.maze = maze;
        this.name = name;
    }

    public singleMaze(Pair start, Pair end, String maze) {
        this.start = start;
        this.end = end;
        this.maze = maze;
    }
}