package com.example.zachary.concerttickets;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		*/
	}

	public void buttonClick(View view)
	{
		// get method values

		EditText tickets = (EditText) findViewById(R.id.txtTickets);
		Spinner group = (Spinner) findViewById(R.id.spinner);
		TextView result = (TextView) findViewById(R.id.txtResult);

		// set method values

		final double COST_PER_TICKET = 79.99;
		int numberOfTickets;
		double cost;
		String groupChoice;
		String strNumberOfTickets;




		// check input value

		strNumberOfTickets = tickets.getText().toString();
		if (!strNumberOfTickets.equals(""))// && strNumberOfTickets != null)
		{
			// calculate ticket cost

			numberOfTickets = Integer.parseInt(strNumberOfTickets);

			// check number of tickets

			if (numberOfTickets >= 1 && numberOfTickets <= 100)
			{
				cost = numberOfTickets * COST_PER_TICKET;

				// get group choice

				groupChoice = group.getSelectedItem().toString();

				// display result

				DecimalFormat currencyUSD = new DecimalFormat("$###,##0.00");
				currencyUSD.setDecimalSeparatorAlwaysShown(true);

				//result.setText("Cost for " + groupChoice + " is " + cost);
				result.setText("Cost for " + groupChoice + " is " + currencyUSD.format(cost));
			}
			else
			{
				// otherwise display a toast message
				Toast.makeText(MainActivity.this, "Enter a valid number of tickets!", Toast.LENGTH_LONG).show();
			}
		}
		else
		{
			// otherwise display a toast message
			Toast.makeText(MainActivity.this, "Enter a valid number of tickets!", Toast.LENGTH_LONG).show();
		}




	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_clear)
		{
			// get method values

			EditText tickets = (EditText) findViewById(R.id.txtTickets);
			//Spinner group = (Spinner) findViewById(R.id.spinner);
			TextView result = (TextView) findViewById(R.id.txtResult);

			tickets.setText("");
			result.setText("");
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
