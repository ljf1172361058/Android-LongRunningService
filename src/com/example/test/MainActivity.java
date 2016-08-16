package com.example.test;

import android.os.Bundle;
import android.view.View;

import com.example.service.MyService;

import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void start(View view) {
		startService(new Intent(this, MyService.class));
	}
	
	
	public void stop(View view) {
		startService(new Intent(this, MyService.class));
	}
	
	

}
