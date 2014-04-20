package com.oa.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.opensymphony.xwork2.ActionSupport;

public class ChartAction extends ActionSupport {
	public String getFeeds() throws JSONException, IOException{
		JSONArray array=new JSONArray();
		JSONObject object=new JSONObject();
		object.put("id", 11);
		object.put("title", "metting");
		object.put("start", System.currentTimeMillis());
		object.put("end", System.currentTimeMillis()+10000);
		object.put("backgroundColor", "#102222");
		array.put(object);
		ServletActionContext.getResponse().getWriter().println(array.toString());
		System.out.println("here=============");
		return null;
	}
}
