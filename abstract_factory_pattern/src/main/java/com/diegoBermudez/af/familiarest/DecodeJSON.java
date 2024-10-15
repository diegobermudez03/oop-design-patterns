package com.diegoBermudez.af.familiarest;

import com.diegoBermudez.af.IDecoding;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class DecodeJSON implements IDecoding {
    private static DecodeJSON instance = new DecodeJSON();

    private DecodeJSON(){}

    public static DecodeJSON getInstance() {
        return instance;
    }

    @Override
    public String[] decode(String json, String attribute){
        JsonElement jsonEl = JsonParser.parseString(json);
        JsonArray jsonArr = jsonEl.getAsJsonObject().getAsJsonArray(attribute);
        Gson gson = new Gson();
        return gson.fromJson(jsonArr, String[].class);
    }
}
