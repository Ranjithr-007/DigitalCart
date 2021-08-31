package com.example.digitalcart;

import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.serialization.SoapObject;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class C_view_reply extends Activity {
	ListView l1;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_view_reply);
		try
    	{
    		if (android.os.Build.VERSION.SDK_INT > 9) 
    		{
    			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    			StrictMode.setThreadPolicy(policy);
    		}
    	}
    	catch(Exception e)
    	{
    		
    	}
		l1=(ListView)findViewById(R.id.listView1);
		
		//listview code
		SoapObject obj1=new SoapObject(soapclass.NAMESPACE,"v_reply");
		obj1.addProperty("uid",Login.uid);
		soapclass sc1=new soapclass();
		String ou1=sc1.Callsoap(obj1,  "http://tempuri.org/v_reply");
		Toast.makeText(getApplicationContext(), ou1, 3).show();
		if(!ou1.equals("error")&&!ou1.equals(""))
		{
			ArrayList<HashMap<String, String>> allist=new ArrayList<HashMap<String,String>>();
			String s3[]=ou1.split("@");
		
	        for(int i=0;i<s3.length;i++)
	        {
	        String[] s2=s3[i].split("#");
	        HashMap<String, String> hmap=new HashMap<String, String>();
	        hmap.put("a", s2[0]);
	        hmap.put("b", s2[1]);
	        hmap.put("c",s2[2]);
	        allist.add(hmap);
	        }
	        ListAdapter lis=new SimpleAdapter(C_view_reply.this, allist, R.layout.reply, new String[]{"a","b","c"},new int[]{R.id.textView2,R.id.textView4,R.id.textView6});
	        l1.setAdapter(lis);
	        	}
		else
		{
			l1.setAdapter(null);
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.c_view_reply, menu);
		return true;
	}

}
