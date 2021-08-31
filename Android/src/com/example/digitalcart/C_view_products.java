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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class C_view_products extends Activity {
	
	ListView l1;
	Spinner s1;
	String p_id[];
	String c1;
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_view_products);
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
		s1=(Spinner)findViewById(R.id.spinner1);
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
	        ArrayAdapter ad=new ArrayAdapter(C_view_products.this,android.R.layout.simple_spinner_item,ptype);
	        s1.setAdapter(ad);
		}
		
	s1.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			c1=p_id[arg2];
			//Toast.makeText(getApplicationContext(), c1, 3).show();
			//listview code
			//type=c1
			

			SoapObject obj1=new SoapObject(soapclass.NAMESPACE,"v_products");
			obj1.addProperty("type",c1);
			soapclass sc1=new soapclass();
			String ou1=sc1.Callsoap(obj1,  "http://tempuri.org/v_products");
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
		        hmap.put("d",s2[3]);
		        hmap.put("e",s2[4]);
		        allist.add(hmap);
		        }
		        ListAdapter lis=new SimpleAdapter(C_view_products.this, allist, R.layout.products, new String[]{"a","b","c","d","e"},new int[]{R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,R.id.textView10});
		        l1.setAdapter(lis);
		        	}
			else
			{
				l1.setAdapter(null);
			}
			
			
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.c_view_products, menu);
		return true;
	
	}
}
