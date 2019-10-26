package com.ebookfrenzy.currencyconverter;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void convert(View view){
        EditText usValue = (EditText) findViewById(R.id.usValue);
        String usValueText = usValue.getText().toString();

        EditText eurValue = (EditText) findViewById(R.id.eurValue);
        String eurValueText = eurValue.getText().toString();

        if (usValueText.matches("") && !(eurValueText.matches(""))) {
            double eurValueInt = Double.parseDouble(eurValueText);

            //convert Euro to US
            double dollars = eurValueInt * 1.11699;

            //set text
            usValue.setText(Double.toString(dollars));
        } else if (eurValueText.matches("") && !(usValueText.matches(""))) {
            double usValueInt = Double.parseDouble(usValueText);

            //convert US to Eur
            double euros = usValueInt * 0.87;

            //set text
            eurValue.setText(Double.toString(euros));
        } else if (usValueText.matches("") && eurValueText.matches("")){
            EditText bottom = (EditText) findViewById(R.id.bottom);
            bottom.setText("At least one field must not be empty.");
        } else {
            //if both are not empty
            double usValueInt = Double.parseDouble(usValueText);

            //convert US to Eur
            double euros = usValueInt * 0.87;

            //set text
            eurValue.setText(Double.toString(euros));
        }
    }

    public void clear(View view) {
        EditText usValue = (EditText) findViewById(R.id.usValue);
        usValue.setText("");

        EditText eurValue = (EditText) findViewById(R.id.eurValue);
        eurValue.setText("");

        EditText bottom = (EditText) findViewById(R.id.bottom);
        bottom.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
