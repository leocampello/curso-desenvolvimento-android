package com.example.exerccio04;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1;
    CheckBox checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
    }

    /*Chamado quando algum checkbox é clicado */
    public void onCheckboxClicked (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox1:
                if(checked) {
                    Toast.makeText(this, "Você selecionou a primeira opção", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Você cancelou a primeira opção", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox2:
                if(checked) {
                    Toast.makeText(this, "Você selecionou a segunda opção", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Você cancelou a segunda opção", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onClick (View view) {
        boolean checked1 = checkBox1.isChecked();
        boolean checked2 = checkBox2.isChecked();

        if(checked1 && checked2) {
            Toast.makeText(this, "Você selecionou as duas opções", Toast.LENGTH_SHORT).show();
        } else if(checked1) {
            Toast.makeText(this, "Você selecionou a primeira opção", Toast.LENGTH_SHORT).show();
        } else if(checked2) {
            Toast.makeText(this, "Você selecionou a segunda opção", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você não selecionou nenhuma opção", Toast.LENGTH_SHORT).show();
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
