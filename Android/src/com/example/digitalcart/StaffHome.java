package com.example.digitalcart;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StaffHome extends Activity {
	Button b1,b2,b3,b4,b5,b6,b7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_staff_home);
	
	b1=(Button)findViewById(R.id.button1);
	b2=(Button)findViewById(R.id.button2);
	b3=(Button)findViewById(R.id.button3);
	b4=(Button)findViewById(R.id.button4);
	b5=(Button)findViewById(R.id.button5);
	b6=(Button)findViewById(R.id.button6);
	b7=(Button)findViewById(R.id.button7);
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),S_add_product.class);
			startActivity(i);	
			
		}
	});
	b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),S_add_type.class);
			startActivity(i);	
			
		}
	});
	b3.setOnClickListener(new OnClickListener(){
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),S_view_stock_update.class);
			startActivity(i);	
			
		}
	});
	b4.setOnClickListener(new OnClickListener(){
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),S_sales_report.class);
			startActivity(i);	
	}
	});
		
b5.setOnClickListener(new OnClickListener(){
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub	
			Intent i=new Intent(getApplicationContext(),C_view_bill_report.class);
			startActivity(i);	
		
		}
});
b6.setOnClickListener(new OnClickListener(){
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub	
		Intent i=new Intent(getApplicationContext(),S_view_feedback.class);
		startActivity(i);	
	}
});
	
b7.setOnClickListener(new OnClickListener(){
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub	
		Intent i=new Intent(getApplicationContext(),Login.class);
		startActivity(i);	
		
	}
});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.staff_home, menu);
		return true;
	}

}
