package com.yuaoq.yabiz.daojia.model.json.common.store;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by changsy on 16/8/31.
 */
public class Params {
    public String orgCode;
    public int imgOrder;
    public String storeId;
    
    public Params(String orgCode, int imgOrder, String storeId) {
        this.orgCode = orgCode;
        this.imgOrder = imgOrder;
        this.storeId = storeId;
    }
    
    public static Params objectFromData(String str) {
        
        return new Gson().fromJson(str, Params.class);
    }
    
    public static Params objectFromData(String str, String key) {
        
        try {
            JSONObject jsonObject = new JSONObject(str);
            
            return new Gson().fromJson(jsonObject.getString(str), Params.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static List<Params> arrayParamsFromData(String str) {
        
        Type listType = new TypeToken<ArrayList<Params>>() {
        }.getType();
        
        return new Gson().fromJson(str, listType);
    }
}
