package com.github.plexpt.iyuu.utils;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-09 20:33
 */
public final class GsonUtils {

    public static final Gson gson = new Gson();

    private static final JsonParser jsonParser = new JsonParser();

    /**
     * Just making default constructor private for noninstantiability.
     */
    private GsonUtils() {
        throw new AssertionError();
    }

    /**
     * Returns the JSON String representation of an object.
     *
     * @param object an arbitrary object.
     * @return a JSON String representation of the object.
     */
    public static String toJsonString(Object object) {
        return gson.toJson(object);
    }

    /**
     * Returns the JSON String representation of an object.
     *
     * @param object  an arbitrary object.
     * @param typeOfT the type of the desired arbitrary object.
     * @return a JSON String representation of the object.
     */
    public static String toJsonString(Object object, Type typeOfT) {
        return gson.toJson(object, typeOfT);
    }

    /**
     * Returns the JSON object as a plain java object.
     *
     * @param json a JSON String representation of a JSON object.
     * @return a simple POJO.
     */
    public static Object fromJsonString(String json) {
        return gson.fromJson(json, Object.class);
    }

    /**
     * Returns the JSON object as a plain java object by the specified type.
     *
     * @param json    a JSON String representation of a JSON object.
     * @param typeOfT the type of the desired object.
     * @return a plain java object by the specified type.
     */
    public static <T> T fromJsonString(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    /**
     * Returns the JSON object as a plain java object by the specified type.
     *
     * @param map  a Map representation of an object.
     * @param type the type of the desired object.
     * @return a plain java object by the specified type.
     */
    public static <T> T fromMap(Map<String, Object> map, Class<T> type) {
        return gson.fromJson(gson.toJson(map), type);
    }

    /**
     * Returns the JSON object as a plain java object by the specified type.
     *
     * @param map  a Map representation of an object.
     * @param type the type of the desired object.
     * @return a plain java object by the specified type.
     */
    public static Map<String, Object> toMap(Object object) {
        return gson.fromJson(gson.toJson(object), Map.class);
    }

    /**
     * Returns a JsonObject object from a String representation of a JSON
     * object.
     *
     * @param jsonStringObject a String representation of a JSON object.
     * @return a JsonObject object from the specified String.
     * @throws JsonSyntaxException   if JSON is not a valid representation for an object of type.
     * @throws IllegalStateException if the element is of another type.
     */
    public static JsonObject toJsonObject(String jsonStringObject)
            throws JsonSyntaxException, IllegalStateException {
        return jsonParser.parse(jsonStringObject).getAsJsonObject();
    }

    /**
     * Returns a JsonArray object from a String representation of a JSON array
     * object.
     *
     * @param jsonStringArray a String representation of a JSON array object.
     * @return a JsonArray object from the specified String.
     * @throws JsonSyntaxException   if JSON is not a valid representation for an object of type.
     * @throws IllegalStateException if the element is of another type.
     */
    public static JsonArray toJsonArray(String jsonStringArray)
            throws JsonSyntaxException, IllegalStateException {
        return jsonParser.parse(jsonStringArray).getAsJsonArray();
    }

    public static JsonElement toJsonElement(String jsonStringElement)
            throws JsonSyntaxException, IllegalStateException {
        return jsonParser.parse(jsonStringElement);
    }

    /**
     * Returns a jsonElement from a String representation of a JSON object.
     *
     * @param jsonString a String representation of a JSON object.
     * @return a jsonElement from the specified String.
     */
    public static JsonElement jsonElementFrom(String jsonString) {

        return jsonParser.parse(jsonString);
    }

    /**
     * Checks if the provided String is a representation of a JSON object.
     *
     * @param jsonStringObject a possible String representation of a JSON object.
     * @return true if this element is of type JsonObject, false otherwise.
     */
    public static boolean isJsonObject(String jsonStringObject) {
        try {
            return toJsonObject(jsonStringObject).isJsonObject();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /**
     * Checks if the provided String is a representation of a JSON array.
     *
     * @param jsonStringArray a possible String representation of a JSON array.
     * @return true if this element is of type JsonArray, false otherwise.
     */
    public static boolean isJsonArray(String jsonStringArray) {

        try {
            return toJsonArray(jsonStringArray).isJsonArray();
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
