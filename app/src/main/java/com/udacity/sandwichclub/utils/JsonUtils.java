package com.udacity.sandwichclub.utils;
import android.text.TextUtils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtils {
    /*Method to parse objects of the sandwich_details.json file
     *returns a Sandwich object with parsed sandwich elements
     */
    public static Sandwich parseSandwichJson(String json) {
        //Non-Array fields
        //String image;
        //String placeOfOrigin;
        //String description;
/*if(TextUtils.isEmpty(sandwich_detls)){
            return null;            //Exit out if JSON String is empty, otherwise line32
        }
Sandwich sandwich = null;    //Initialize an empty sandwich object*/
        //  Parses the sandwichArray throwing and catching any possible exception due to the array
        try{
            JSONObject sandwichObject = new JSONObject(json);   //Creates a JSONObject
            JSONObject Nome = sandwichObject.getJSONObject("name"); //Gets a specific key from the object
            String mainName = Nome.getString("mainName");   //gets the value of specific key
            JSONArray alsoKnownAsJsonArray = Nome.getJSONArray("alsoKnownAs"); //Gets the JsonArray with key name
            List<String> alsoKnownAs = new ArrayList<>();
            for(int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
            }
            String placeOfOrigin = sandwichObject.getString("placeOfOrigin");  //Gets place of origin's key value
            String description = sandwichObject.getString("description");  //Gets description's key value
            String image = sandwichObject.getString("image");  //Gets image's key value
            JSONArray jsonIngredientsArray = sandwichObject.getJSONArray("ingredients");   //Stores all strings from ingredients' key
            List<String> ingredients = new ArrayList<>();    //Stores previous array values into a List
            for(int j = 0; j < jsonIngredientsArray.length(); j++){
                ingredients.add(jsonIngredientsArray.getString(j));
            }
            return new Sandwich (image, mainName, placeOfOrigin, description, alsoKnownAs, ingredients);
        }catch(JSONException except){
            except.printStackTrace();
            return null;
        }
    }
}
