package com.example.digitalcart;

import org.ksoap2.serialization.SoapObject;

import android.R.string;
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
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class S_add_product extends Activity {
EditText e1,e2,e3,e4;
Button b1;
Spinner s1;
String p_id[];
String c1;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_s_add_product);
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
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		b1=(Button)findViewById(R.id.button1);
		s1=(Spinner)findViewById(R.id.spinner1);
		
		//view producttype
		
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
	        ArrayAdapter ad=new ArrayAdapter(S_add_product.this,android.R.layout.simple_spinner_item,ptype);
	        s1.setAdapter(ad);
		}
		
	s1.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			c1=p_id[arg2];
			Toast.makeText(getApplicationContext(), c1, 3).show();
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//soapcode connecting addproduct
				//producttypeid=c1
				
				
				
				//val
				if(!e1.getText().toString().equals("")&&!e2.getText().toString().equals("")&&!e3.getText().toString().equals("")&&!e4.getText().toString().equals(""))
				{
				
				Toast.makeText(getApplicationContext(), c1, 3).show();
				SoapObject obj=new SoapObject(soapclass.NAMESPACE, "addprod");
				obj.addProperty("producttypeid", c1);
				obj.addProperty("productname",e1.getText().toString());
				obj.addProperty("description",e2.getText().toString());
				obj.addProperty("quantity",e3.getText().toString());
				obj.addProperty("price",e4.getText().toString());
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj,  "http://tempuri.org/addprod");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					Toast.makeText(getApplicationContext(), "success", 3).show();
					
				
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.s_add_product, menu);
		return true;
	}

}
