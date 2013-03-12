package com.tdlee1230.genericgame3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash, menu);
		return true;
	}
	
	public void nextActivity(View view)
    {
    	// Make a new intent
        Intent intent = new Intent(this, NewOrLoad.class);
        // Start the next activity
        startActivity(intent);
    }
    
}