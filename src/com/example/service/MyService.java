package com.example.service;

import com.example.broadcast.MyBroadcastReveicer;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@SuppressLint("NewApi")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {
			public void run() {
				Log.i("test", "服务运行了");
			}
		}).start();
		
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		Intent intent2 = new Intent(this, MyBroadcastReveicer.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent2, 0);
		alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+1000*5, pendingIntent);
		return super.onStartCommand(intent, flags, startId);
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
