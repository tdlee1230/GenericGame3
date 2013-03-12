package com.tdlee1230.genericgame3;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import com.tdlee1230.genericgame3.Unit;

public class SlotSelect extends Activity {
	
	private boolean newGame = false;
	private boolean loadGame = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slot_select);
		// Show the Up button in the action bar.
		// getActionBar().setDisplayHomeAsUpEnabled(true)
		Log.println(1,  "bullshit",  "SLOT SELECT");
	    newGame = getIntent().getExtras().getBoolean("newGame");
	    loadGame = getIntent().getExtras().getBoolean("loadGame");
	    
	    // After this above block, one of these should be true
	    
	    /* USED TO TEST BOOLEAN VALUES
	    TextView textView = (TextView) findViewById(R.id.slot_1);
	    textView.setText("newGame = " + newGame);
	    textView = (TextView) findViewById(R.id.slot_2);
	    textView.setText("loadGame = " + loadGame);
	    */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_slot_select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void slotSwitch(View view)
    {
		switch(view.getId())
		{
		case R.id.slot_1:
			nextActivity(1);
			break;
		case R.id.slot_2:
			nextActivity(2);
			break;
		case R.id.slot_3:
			nextActivity(3);
			break;
		case R.id.slot_4:
			nextActivity(4);
			break;
		}
    }
	
	public void nextActivity(int slot)
	{
		if(newGame == true)
		{
			switch(slot)
			{
			case 1:
		        Intent intent1 = new Intent(this, CreateNewGame.class);
		        
		        startActivity(intent1);
		        break;
			case 2:
				Intent intent2 = new Intent(this, CreateNewGame.class);
				startActivity(intent2);
		        break;
			case 3:
				Intent intent3 = new Intent(this, CreateNewGame.class);
				startActivity(intent3);
		        break;
			case 4:
				Intent intent4 = new Intent(this, CreateNewGame.class);
				startActivity(intent4);
		        break;
			}
		}
		
		else if(loadGame == true)
		{
			switch(slot)
			{
			case 1:
				//Prepare two arrays of units and send across this intent
				ArrayList<Unit> allies = new ArrayList<Unit>();
		        allies.add(new Unit());
		        allies.get(0).setHealth(10);
		        allies.add(new Unit());
		        allies.get(1).setHealth(10);
		        
		        ArrayList<Unit> enemies = new ArrayList<Unit>();
		        enemies.add(new Unit());
		        enemies.get(0).setHealth(10);
		        enemies.add(new Unit());
		        enemies.get(1).setHealth(10);
		        
		        Intent intent1 = new Intent(this, Game.class);
		        
		        //intent1.putParcelableArrayListExtra("allies", allies);
		        //intent1.putParcelableArrayListExtra("enemies", enemies);
		        
		        Bundle bundle = new Bundle();
		        bundle.putParcelableArrayList("allies", allies);
		        bundle.putParcelableArrayList("enemies", enemies);
		        intent1.putExtras(bundle);
		        startActivity(intent1);
		        break;
			case 2:
				Intent intent2 = new Intent(this, Game.class);
		        startActivity(intent2);
		        break;
			case 3:
				Intent intent3 = new Intent(this, Game.class);
		        startActivity(intent3);
		        break;
			case 4:
				Intent intent4 = new Intent(this, Game.class);
		        startActivity(intent4);
		        break;
			}
		}
	}
	
}
