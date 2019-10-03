package com.challengeappmarceloscaccia.com.myapplication;

import com.challengeappmarceloscaccia.com.myapplication.models.Categorias;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class DeserializerGSon implements JsonDeserializer<Categorias>
    {
        @Override
        public Categorias deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
                throws JsonParseException
        {
            JsonElement content = je.getAsJsonObject().get("content");

            // Deserialize it. You use a new instance of Gson to avoid infinite recursion
            // to this deserializer
            return new Gson().fromJson(content, Categorias.class);

        }
    }

