package com.tdlee1230.genericgame3;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;

public class Battle extends Activity
{
	private static final String TAG = Battle.class.getSimpleName();

	Unit allies[];
    Unit enemies[];
    int menuLevel;
    int allies_size;
    int enemies_size;

	int screen_width;
	int screen_height;
  
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Display display = getWindowManager().getDefaultDisplay();
		screen_width = display.getWidth(); // deprecated
		screen_height = display.getHeight(); // deprecated
		menuLevel = 0;
		
		setup_units();
		//setup_battle();
		
		setContentView(new MainGamePanel(this));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_battle, menu);
		return false;
	}

	public void setup_battle()
	{
		setup_background();
		setup_units();
	}

	public void setup_background()
	{
		// Take conditions and load background here
	}

	public void setup_units()
	{
		Bundle data = getIntent().getExtras();

		ArrayList<Unit> allies_list = data.getParcelableArrayList("allies");
		ArrayList<Unit> enemies_list = data.getParcelableArrayList("enemies");
		allies_size = allies_list.size();
		enemies_size = enemies_list.size();

		//String text = "BATTLE: allies_size = " + allies_size
		//		+ " enemies_size = " + enemies_size;
		//Log.d("RUNTIME", text);

		allies = new Unit[allies_size];
		enemies = new Unit[enemies_size];

		for (int i = 0; i < allies_size; i++)
		{
			allies[i] = allies_list.get(i);
		}
		for (int i = 0; i < enemies_size; i++)
		{
			enemies[i] = enemies_list.get(i);
		}
	}
	
	@Override
    protected void onPause()    {
        super.onPause();
        
    }
    @Override
    protected void onResume()   {
        super.onResume();
        
    }
    @Override
	protected void onDestroy()
	{
		Log.d(TAG, "Destroying...");
		super.onDestroy();
	}
    @Override
	protected void onStop()
	{
		Log.d(TAG, "Stopping...");
		super.onStop();
	}
	@Override
	public void onBackPressed() {
	    // do something on back.
	    // return;
	}
}