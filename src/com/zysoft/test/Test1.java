package com.zysoft.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import wsclient.OnekeyAppService;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import util.Base64;
import util.JavaUtil;

public class Test1 {
	
	public static  String TableBase64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/" ;
	public static String LogKey = null;//用户登录口令
	
	//获取当前时间   
	public static String getTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");       
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间       
		String str = formatter.format(curDate);
		return str;
	}
	
	public static void main(String[] args) throws JSONException{

		OnekeyAppService service = new OnekeyAppService();

		JSONObject object = new JSONObject();
		String username=Base64.EncodeBase64("username", TableBase64);
		String userpwd=Base64.EncodeBase64("password", TableBase64);
			
			object.put("登录账号", username);
			object.put("密码", userpwd);
			// 最终发出去的json参数
			String strUserInfo=object.toString();
		
        String result = service.getOnekeyAppServiceSoap().getOnekyRepairUserInfo(strUserInfo);
        System.out.println("登录返回JSON数据："+result);
        //处理返回数据
        if (null != result && !"".equals(result)) {
			JSONObject jsonobject,jsonuser;
			JSONArray jsonarray;
			try {
				jsonobject = new JSONObject(result);
				String s = jsonobject.optString("result");

				if (s.equals("正常")) {
					jsonarray= jsonobject.getJSONArray("resultInfo");
					
						jsonuser=jsonarray.getJSONObject(0);
						
						JSONObject json=new JSONObject();
						json=JavaUtil.putVal(json,  "创建人", jsonuser.optString("登录账号"));
						json=JavaUtil.putVal(json,  "创建人ID", jsonuser.optString("ID"));
//						json=JavaUtil.putVal(json,  "开始时间", "2015-01-15");
//						json=JavaUtil.putVal(json,  "结束时间",  "2015-01-15");
						json=JavaUtil.putVal(json,  "开始时间", getTime());
						json=JavaUtil.putVal(json,  "结束时间", getTime());
						json=JavaUtil.putVal(json,  "令牌", jsonuser.optString("令牌"));
						LogKey=jsonuser.optString("令牌");
						JSONObject jsonobject_param=new JSONObject();
						jsonobject_param=JavaUtil.putVal(jsonobject_param, "登录信息",json);
						
						/*String str=getTask(jsonobject_param);
						if(null != str && !"".equals(str)){
							JSONObject jsontask=new JSONObject(str);
							String status=jsontask.getString("result");
							
							if("正常".equals(status)){
//								String count=jsontask.getString("count");
								jsonobject_param=JavaUtil.putVal(jsonobject_param, "任务信息",str);
							}
//							else{
//								jsonobject_param=JavaUtil.putVal(jsonobject_param, "任务信息",str);
//							}
							
						}
						Intent intent = new Intent(LoginActivity.this, MainActivity.class);
						intent.putExtra("param", jsonobject_param.toString());
						startActivity(intent);

						finish();
						Toast.makeText(getBaseContext(), "登陆成功", Toast.LENGTH_SHORT).show();*/
					
					
				}else if("异常".equals(s) && jsonobject.optString("resultInfo").contains("已经登录")){
					//{"resultInfo":"用户名“tester3”已经登录，不可重复登录","result":"异常"}
					//Toast.makeText(getBaseContext(), "用户名已经登录，不可重复登录",Toast.LENGTH_SHORT).show();
					System.out.println("用户名已经登录，不可重复登录");
				}else if("异常".equals(s) && jsonobject.optString("resultInfo").contains("锁定")){
					//Toast.makeText(getBaseContext(), "一天之内密码错误超过3次，用户已锁定，请明天再试！",Toast.LENGTH_SHORT).show();
					System.out.println("一天之内密码错误超过3次，用户已锁定，请明天再试！");
				}else{
					//edit2_pwd.setText("");
					//Toast.makeText(getBaseContext(), "用户名或密码错误",Toast.LENGTH_SHORT).show();
					//String username=Base64.EncodeBase64(edit_username.getText().toString().trim(), StaticClass.TableBase64);
					//writeIsUsername(username, "");
					System.out.println("用户名或密码错误");
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} else {// 判断返回的result是否为空
			//Toast.makeText(getBaseContext(), "网络异常，登陆失败", Toast.LENGTH_SHORT)
			//		.show();
			System.out.println("网络异常，登陆失败");
		}
    }

}
