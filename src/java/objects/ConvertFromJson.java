/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ConvertFromJson {

    public Map<String, String> Serlize;
    // public SingleMaze maze;
    // public Game g;
    //  public Play move;
    // public String Type;
    public Gson deserializer = new Gson();

    /// <summary>
    /// constructor that get serlize string and turn it to a dictionary 
    /// </summary>
    /// <param name="json">selize dict</param>
    public ConvertFromJson(String json) {
        Map<String, String> map = new HashMap<String, String>();
        map = (Map<String,String>) deserializer.fromJson(json, map.getClass());
       // Map<String, String> dic = deserializer.fromJson(response, String);
        String s = map.get("Content");
         Map<String, String> map2 = new HashMap<String, String>();
         this.Serlize = (Map<String,String>)deserializer.fromJson(s, map2.getClass());
        
    }

}
