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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class C_view_bill_report extends Activity {
	ListView l1;
	EditText e1;
	TextView tot;
	Button b1;
	String c1;
String tid;
float pr=0;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_view_bill_report);
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
		e1=(EditText)findViewById(R.id.editText1);
		b1=(Button)findViewById(R.id.button1);
		tot=(TextView)findViewById(R.id.textView2);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!e1.getText().toString().equals(""))
				{
//				SoapObject obj1=new SoapObject(soapclass.NAMESPACE,"get_trollyid");
//				obj1.addProperty("tno", e1.getText().toString());
//				soapclass sc1=new soapclass();
//				String ou1=sc1.Callsoap(obj1,  "http://tempuri.org/get_trollyid");
//				
//				if(!ou1.equals("error")&&!ou1.equals(""))
//				{
					//tid=ou1;
					SoapObject obj=new SoapObject(soapclass.NAMESPACE,"v_billreport1");
					obj.addProperty("tid",e1.getText().toString());
					soapclass sc=new soapclass();
					String ou=sc.Callsoap(obj,  "http://tempuri.org/v_billreport1");
					
					if(!ou.equals("error")&&!ou.equals(""))
					{
						ArrayList<HashMap<String, String>> allist=new ArrayList<HashMap<String,String>>();
						String s3[]=ou.split("@");
					
				        for(int i=0;i<s3.length;i++)
				        {
				        String[] s2=s3[i].split("#");
				        HashMap<String, String> hmap=new HashMap<String, String>();
				        hmap.put("a", s2[0]);
				        hmap.put("b", s2[1]);
                        hmap.put("c",s2[2]);
                        hmap.put("d",s2[3]);
                        pr+=Float.parseFloat(s2[1]);
				        allist.add(hmap);
				        }
				        ListAdapter lis=new SimpleAdapter(C_view_bill_report.this, allist, R.layout.bill, new String[]{"a","c","d","b"},new int[]{R.id.textView4,R.id.textView7,R.id.textView8,R.id.textView2});
				        l1.setAdapter(lis);
				        tot.setText(pr+"");
				        	}
					else
					{
						l1.setAdapter(null);
					}
					



					
					
				
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
		getMenuInflater().inflate(R.menu.c_view_bill_report, menu);
		return true;
	}

}
