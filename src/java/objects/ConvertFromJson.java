/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

/**
 *
 * @author revit
 */
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
        public ConvertFromJson(String json)
        {
            Type type = new TypeToken<Map<String, String>>(){}.getType();
            Map<String,String> map=deserializer.fromJson(json, type);
           // Map<String, String> dic = deserializer.fromJson(response, String);
            String s = map.get("Content");
            type = new TypeToken<Map<String, String>>(){}.getType();
            this.Serlize =deserializer.fromJson(s, type);
            //this.Serlize = JsonConvert.DeserializeObject<Dictionary<string, string>>(dic["Content"]);
            System.out.println("objects.ConvertFromJson.<init>()");
            System.out.println(map.get(s));
        }
        
}
