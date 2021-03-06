package net.crimsonresearch.tipcalculator;

import java.text.NumberFormat;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {
	private EditText tvEnterAmount;
	private TextView tvComputedTip;
	private Button btnTenPercent;
	private Button btnFifteenPercent;
	private Button btnTwentyPercent;
	private TextView tvSplitTip;
	private EditText etPartyCount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvEnterAmount = (EditText)findViewById(R.id.tvEnterAmmount);
		tvComputedTip = (TextView)findViewById(R.id.tvComputedTip);
		btnTenPercent = (Button)findViewById(R.id.btnTenPercent);
		btnFifteenPercent = (Button)findViewById(R.id.btnFifteenPercent);
		btnTwentyPercent = (Button)findViewById(R.id.btnTwentyPercent);
		tvSplitTip = (TextView)findViewById(R.id.tvSplitTip);
		etPartyCount = (EditText)findViewById(R.id.etPartyCount);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void computeTip(View v) {
		double value = 0.0f;
		try {
			String amount = tvEnterAmount.getText().toString();
			value = Float.parseFloat(amount);
		} catch (NumberFormatException nfe) {
			Toast.makeText(this, "Enter Ammount", Toast.LENGTH_SHORT).show();	
		}
		double tip = 0.0f;
		if(v == btnTenPercent) {
			tip = (value * 0.10);
		} else if(v == btnFifteenPercent) {
			tip = (value * 0.15);
		} else if(v == btnTwentyPercent) {
			tip = (value * 0.20);
		}
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String result = "Tip is: " + currencyFormat.format(tip);
		tvComputedTip.setText(result);
		try {
			String amount = etPartyCount.getText().toString();
			value = Float.parseFloat(amount);
		} catch (NumberFormatException nfe) {
			value = 1;
			etPartyCount.setText(Integer.toString((int) value));
		}
		double perGuest = tip / value;	
		String perGuestString = "Per Guest Tip: " + currencyFormat.format(perGuest);
		tvSplitTip.setText(perGuestString);
	}
}
