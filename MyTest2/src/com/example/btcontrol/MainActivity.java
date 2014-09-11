package com.example.btcontrol;

import java.io.IOException;

import com.example.mytest2.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv1;
	Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv1 = (TextView) findViewById(R.id.textView1);
		btn1 = (Button) findViewById(R.id.button1);
		final BluetoothReceiver btActivity = new BluetoothReceiver(this);

		btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				System.out.println("try closeBT()");
				try {
					btActivity.closeBT();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		
		btActivity.findBT();
		try {
			btActivity.openBT();
			btActivity.listenForData();
			btActivity.timelySendData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}