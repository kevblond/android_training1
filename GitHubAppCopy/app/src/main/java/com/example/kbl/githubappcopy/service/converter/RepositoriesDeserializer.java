package com.example.kbl.githubappcopy.service.converter;

import com.example.kbl.githubappcopy.model.Repositorie;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * class using to convert json file loaded
 */
public class RepositoriesDeserializer implements JsonDeserializer<List<Repositorie>> {
    @Override
    public List<Repositorie> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final Gson gson = new Gson();
        if (json instanceof JsonObject) {
            final JsonObject jsonObject = json.getAsJsonObject();
            final Repositorie repositorie = gson.fromJson(jsonObject.get("results"), typeOfT);
            List<Repositorie> rep = new ArrayList<>();
            rep.add(repositorie);
            return rep;
        } else if (json instanceof JsonArray) {
            final JsonArray jsonArray = json.getAsJsonArray();
            return gson.fromJson(jsonArray, typeOfT);
        } else {
            throw new JsonParseException("Not a JsonObject and a not a JsonArray either");
        }

    }
}
