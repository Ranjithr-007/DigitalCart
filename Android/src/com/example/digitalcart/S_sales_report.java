package com.example.digitalcart;

import org.ksoap2.serialization.SoapObject;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class S_sales_report extends Activity {
	EditText e1,e2,e3,e4;
	Button b1;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_s_sales_report);
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
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!e1.getText().toString().equals("")&&!e2.getText().toString().equals("")&&!e3.getText().toString().equals("")&&!e4.getText().toString().equals(""))
				{
				//val
				
				
				SoapObject obj=new SoapObject(soapclass.NAMESPACE, "salesreport");
				obj.addProperty("no_of_purchase", e1.getText().toString());
				obj.addProperty("profit", e2.getText().toString());
				obj.addProperty("date", e3.getText().toString());
				obj.addProperty("loss", e4.getText().toString());
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj,  "http://tempuri.org/salesreport");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					Toast.makeText(getApplicationContext(), "success", 3).show();
					Intent i=new Intent(getApplicationContext(),StaffHome.class);
					startActivity(i);
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
		getMenuInflater().inflate(R.menu.s_sales_report, menu);
		return true;
	}

}
