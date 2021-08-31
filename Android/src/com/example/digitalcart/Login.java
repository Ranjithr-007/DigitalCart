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

public class Login extends Activity {
	EditText e1,e2;
	Button b1,b2,b3;
public static String uid,type;
    @TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if(!e1.getText().toString().equals("")&&!e2.getText().toString().equals(""))
				{
				
				
				SoapObject obj=new SoapObject(soapclass.NAMESPACE, "login");
				obj.addProperty("unm", e1.getText().toString());
				obj.addProperty("pass", e2.getText().toString());
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj,  "http://tempuri.org/login");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					
					String []s1=ou.split("#");
					uid=s1[0];
					type=s1[1];
					if(type.equals("customer"))
					{
						Intent i=new Intent(getApplicationContext(),CustHome.class);
						startActivity(i);	
					}
					//}
					
					else if(type.equals("staff"))
					{
						Intent i=new Intent(getApplicationContext(),StaffHome.class);
						startActivity(i);	
					}
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
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),C_registration.class);
				startActivity(i);
				
			}
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
}
