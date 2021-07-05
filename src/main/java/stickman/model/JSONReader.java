package stickman.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;

public class JSONReader {
    private String jsonString;
    private InputStream inputStream;
    private JSONObject configuration;


    public JSONReader(String address) {
        this.jsonString=null;
        this.inputStream=null;
        try {
            inputStream = new FileInputStream(address);
            jsonString = IOUtils.toString(inputStream, "utf8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jsonString != null){
            this.configuration = JSON.parseObject(jsonString);
        }else{
            throw new RuntimeException("JSON parse error");
        }

    }

    public JSONObject getConfiguration() {
        return configuration;
    }

    public void setConfiguration(JSONObject configuration) {
        this.configuration = configuration;
    }

    public JSONObject getJSONObject(String key){
        return configuration.getJSONObject(key);
    }

    public Double getDoubleFromJson(JSONObject object,String key){
        return object.getDouble(key);
    }

    public String getStringFromJson(JSONObject object,String key){
        return object.getString(key);
    }


}

