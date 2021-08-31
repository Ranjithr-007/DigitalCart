package com.example.digitalcart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.serialization.SoapObject;

import android.R.string;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class S_view_stock_update extends Activity {
EditText e1;
Spinner s1;
ListView l1;
Button b1;
String pid;
String p_id[];
String c1;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_s_view_stock_update);
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
		e1=(EditText)findViewById(R.id.editText1);
		s1=(Spinner)findViewById(R.id.spinner1);
		l1=(ListView)findViewById(R.id.listView1);
		b1=(Button)findViewById(R.id.button1);
		SoapObject obj=new SoapObject(soapclass.NAMESPACE,"v_producttype");
		soapclass sc=new soapclass();
		String ou=sc.Callsoap(obj,  "http://tempuri.org/v_producttype");
		
		if(!ou.equals("error")&&!ou.equals(""))
		{
			String ss[]=ou.split("@");
			String ptype[]=new String[ss.length];
	         p_id=new String[ss.length];
	        for(int i=0;i<ss.length;i++)
	        {
	        String[]s2=ss[i].split("#");
	         p_id[i]=s2[0];
	         ptype[i]=s2[1];
	        	}
	        ArrayAdapter ad=new ArrayAdapter(S_view_stock_update.this,android.R.layout.simple_spinner_item,ptype);
	        s1.setAdapter(ad);
		}
		
	s1.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			c1=p_id[arg2];
			//Toast.makeText(getApplicationContext(), c1, 3).show();
			
			
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	

	l1.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			// TODO Auto-generated method stub
			HashMap<String, String> hmap=(HashMap<String, String>)arg0.getItemAtPosition(arg2);
			pid=hmap.get("a");
			
		}
	});	
    
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//val
              if(!e1.getText().toString().equals(""))
					
				{
				
				
				SoapObject obj=new SoapObject(soapclass.NAMESPACE, "stockupdate");
				obj.addProperty("quantity", e1.getText().toString());
				obj.addProperty("pid",pid);
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj,  "http://tempuri.org/stockupdate");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					Toast.makeText(getApplicationContext(), "success", 3).show();
					vwstock(c1);
				
				}
			
				else
				{
					Toast.makeText(getApplicationContext(), "Incorrect Username or password", 3).show();
				}
				
				///end
				}
					else
					{
						Toast.makeText(getApplicationContext(), "Fill", 3).show();
				}
			}
			
		});
	}
public void vwstock(String c1)
{
	
	SoapObject obj1=new SoapObject(soapclass.NAMESPACE,"product_type");
	obj1.addProperty("type",c1);
	soapclass sc1=new soapclass();
	String ou1=sc1.Callsoap(obj1,  "http://tempuri.org/product_type");
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
        ListAdapter lis=new SimpleAdapter(S_view_stock_update.this, allist, R.layout.prdt, new String[]{"b","c"},new int[]{R.id.textView1,R.id.textView2});
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
		getMenuInflater().inflate(R.menu.s_view_stock_update, menu);
		return true;
	}

}
