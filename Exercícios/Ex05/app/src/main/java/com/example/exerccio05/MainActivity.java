package com.example.exerccio05;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
    }

    /* Chamado quando um radiobutton é clicado */
    public void onRadioButtonClick (View view) {
        String text = ((RadioButton) view).getText().toString();
        Toast.makeText(this, "Você selecionou a " + text, Toast.LENGTH_SHORT).show();
    }

    public void onClick (View view) {
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radio_1:
                Toast.makeText(this, "Você selecionou a primeira opção", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_2:
                Toast.makeText(this, "Você selecionou a segunda opção", Toast.LENGTH_SHORT).show();
                break;
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
