package util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import com.example.onekeyemergency.bean.TaskBean;

//import android.util.Log;

public class JavaUtil {

// 节点是否存在
	public static Boolean getObject(JSONObject jsonobject,String key){
		Boolean boo=null;
		try {

			if(!jsonobject.isNull(key)){
				boo=true;
			}
			else{
				boo=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			//Log.e("log",e.toString());
		}
		return boo;
	}
	
	public static String getVal(JSONObject jsonobject,String key){
		String val=null;
		try {
			val = jsonobject.getString(key);
		} catch (Exception e) {
			// TODO: handle exception
			//Log.e("log",e.toString());
		}
		return val;
	}
	
	
	public static JSONObject getJSONObject(String obj){
		JSONObject jsonobject=null;
		try {
			jsonobject=new JSONObject(obj);
		} catch (Exception e) {
			// TODO: handle exception
			//Log.e("log",e.toString());
		}
		return jsonobject;
	}

	public static JSONObject getJSONObject(String obj,String key){
		JSONObject jsonobject=null;
		try {
			jsonobject=new JSONObject(obj).getJSONObject(key);
		} catch (Exception e) {
			// TODO: handle exception
			//Log.e("log",e.toString());
		}
		return jsonobject;
	}

	public static JSONObject getJSONObject(JSONArray jsonarray,int index){
		JSONObject jsonobject=null;
		try {
			jsonobject=jsonarray.getJSONObject(index);
		} catch (Exception e) {
			// TODO: handle exception
			//Log.e("log",e.toString());
		}
		return jsonobject;
	}

	public static JSONArray getJSONArray(JSONObject jsonobject,String root){
		JSONArray jsonarray=null;
		try {
			jsonarray = jsonobject.getJSONArray(root);
		} catch (Exception e) {
			// TODO: handle exception
			//Log.e("log",e.toString());
		}
		return  jsonarray;
	}

	public static JSONObject putJSON(Map<String, Object> map,String key){
		JSONObject data=null;
		JSONObject jsonobject=null;
		try {
			data=new JSONObject();
			data.put(key, map);
			jsonobject=data.getJSONObject(key);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonobject;
	}

	public static JSONObject putVal(JSONObject jsonobject,String key,String value){
		try {
		
			jsonobject.put(key, value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonobject;
	}
	
	public static JSONObject putVal(JSONObject jsonobject,String key,Object value){
		try {
		
			jsonobject.put(key, value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonobject;
	}
    
	public static JSONArray putVal(JSONArray jsonarray,Object value){
		
		try {
			jsonarray.put(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonarray;
	}


	
	
	/*** 将map数据解析出来，并拼接成json字符串
         * 
         * @param map
         * @return
         */
    public static JSONObject setJosn(Map map) {
                JSONObject json = null;
                StringBuffer temp = new StringBuffer();
                if (!map.isEmpty()) {
                        temp.append("{");
                        // 遍历map
                        Set set = map.entrySet();
                        Iterator i = set.iterator();
                        while (i.hasNext()) {
                                Map.Entry entry = (Map.Entry) i.next();
                                String key = (String) entry.getKey();
                                Object value = entry.getValue();
                                temp.append("\"" + key + "\":");
                                if (value instanceof Map<?, ?>) {
                                        temp.append(setJosn((Map<String, Object>) value) + ",");
                                } else {
                                        temp.append(value + ",");
                                }
                        }
                        if (temp.length() > 1) {
                                temp = new StringBuffer(temp.substring(0, temp.length() - 1));
                        }
                        temp.append("}");
                        try {
                        	json = new JSONObject(temp.toString());
						} catch (Exception e) {
							// TODO: handle exception
						}
                        
                }
                return json;
        }
}
