package com.example.pleo.formatmoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pleo.formatmoney.utilities.NumbersGenericUtils;

public class Main extends AppCompatActivity {

    private EditText getInputBox;
    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInputBox = (EditText) findViewById(R.id.inputBox);
        showResult = (TextView) findViewById(R.id.displayResults);
    }

    private void makeQuery() {
        try {
            double amount = Double.parseDouble(getInputBox.getText().toString());
            String results = "The formatted amount is: " + NumbersGenericUtils.format(amount);
            showResult.setText(results);
        } catch (NumberFormatException e)  {
            showResult.setText(R.string.onlyNumbersAllowed);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int clickedId = item.getItemId();
        if (clickedId == R.id.submit) {
            makeQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}