/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import javafx.util.Pair;

/**
 *
 * @author גליתונופר
 */
public class Game {
    private singleMaze you;
    private singleMaze other;
    private String name;
    private String mazename;
    
    public Game(String name, String mazename, singleMaze u, singleMaze other)
        {
            this.name = name;
            this.mazename = mazename;
            this.you = u;
            this.other = other;
        }
   

    public String getMaze() {
        return you.getMaze();
    }

    public String getName() {
        return this.mazename;
    }

    public singleMaze getYou() {
        return this.you;
    } 
    
    public singleMaze getOther(){
    return this.other;
    }
  
}
