package com.tdlee1230.genericgame3;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class Game extends Activity {
	
    Unit allies[];
    Unit enemies[];
    int allies_size;
    int enemies_size;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		// THE TWO UNIT ARRAYS SHOULD BE COMING THROUGH AROUND HERE
		// WE NEED TO PASS THEM TO THE NEXT ACTIVITY
		// ALLIES
		
		Bundle data = getIntent().getExtras();

		ArrayList<Unit> allies_list = data.getParcelableArrayList("allies");
		ArrayList<Unit> enemies_list = data.getParcelableArrayList("enemies");
				
		allies_size = allies_list.size();
		enemies_size = enemies_list.size();
		
		//String text = "allies_size = " + allies_size + " enemies_size = " + enemies_size;
		//Log.d("RUNTIME", text);
		
		allies = new Unit[allies_size];
		enemies = new Unit[enemies_size];
		
		for(int i = 0; i < allies_size; i++)
		{
			allies[i]=allies_list.get(i);
		}
		for(int i = 0; i < enemies_size; i++)
		{
			enemies[i]=enemies_list.get(i);
		}
		/*
		String test = "allies[0] HP = " + allies[0].getHealth() + " allies[1] HP = "
				+ allies[1].getHealth() + " enemies[0] HP = " + enemies[0].getHealth()
				+ " enemies[1] HP = " + enemies[1].getHealth();
		Log.d("RUNTIME", test);
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

	public void nextActivity(View view)
    {
		ArrayList<Unit> allies_list = new ArrayList<Unit>();
		ArrayList<Unit> enemies_list = new ArrayList<Unit>();
		for(int i = 0; i < allies_size; i++)
		{
			allies_list.add(new Unit());
			allies_list.set(i, allies[i]);
		}
		for(int i = 0; i < enemies_size; i++)
		{
			enemies_list.add(new Unit());
			enemies_list.set(i, enemies[i]);
		}
		
        // Make a new intent
        Intent intent = new Intent(this, Battle.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("allies", allies_list);
        bundle.putParcelableArrayList("enemies", enemies_list);
        intent.putExtras(bundle);
        startActivity(intent);
    }
	
}