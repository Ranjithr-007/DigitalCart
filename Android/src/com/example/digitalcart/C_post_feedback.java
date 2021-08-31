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

public class C_post_feedback extends Activity {
	EditText e1;
	Button b1;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_post_feedback);
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
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
	if(!e1.getText().toString().equals(""))
					
				{
				SoapObject obj=new SoapObject(soapclass.NAMESPACE, "postfeedback");
				obj.addProperty("feedback", e1.getText().toString());
				obj.addProperty("userid",Login.uid);
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj,  "http://tempuri.org/postfeedback");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					Toast.makeText(getApplicationContext(), "success", 3).show();
					Intent i=new Intent(getApplicationContext(),CustHome.class);
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
		getMenuInflater().inflate(R.menu.c_post_feedback, menu);
		return true;
	}

}
