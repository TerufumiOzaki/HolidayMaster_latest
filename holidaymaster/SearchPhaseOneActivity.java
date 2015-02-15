package com.example.terufumiozaki.holidaymaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class SearchPhaseOneActivity extends ActionBarActivity {

    SharedPreferences mSPspinner1, mSPspinner2, mSPspinner3;
    Spinner spinner1, spinner2, spinner3;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_phase_one);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        button1 = (Button) findViewById(R.id.button1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner2.setVisibility(View.INVISIBLE);
                spinner3.setVisibility(View.INVISIBLE);
                if (position == 1) {
                    spinner2.setVisibility(View.VISIBLE);
                    spinner2.setAdapter(new ArrayAdapter<String>(SearchPhaseOneActivity.this, android.R.layout.simple_spinner_item,
                            getResources().getStringArray(R.array.zone_osaka)));
                } else if (position == 2) {
                    spinner2.setVisibility(View.VISIBLE);
                    spinner2.setAdapter(new ArrayAdapter<String>(SearchPhaseOneActivity.this, android.R.layout.simple_spinner_item,
                            getResources().getStringArray(R.array.zone_tokyo)));
                } else {
                    return;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner2.setVisibility(View.INVISIBLE);
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0){
                    spinner3.setVisibility(View.VISIBLE);
                }else{
                    spinner3.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner3.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void doAction(View v){
        /*mSPspinner1 = getSharedPreferences("spinner1", MODE_PRIVATE);
        mSPspinner2 = getSharedPreferences("spinner2", MODE_PRIVATE);
        mSPspinner3 = getSharedPreferences("spinner3", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = mSPspinner1.edit();
        SharedPreferences.Editor editor2 = mSPspinner2.edit();
        SharedPreferences.Editor editor3 = mSPspinner3.edit();
        editor1.putInt("spinner1Position", spinner1.getSelectedItemPosition());
        editor2.putInt("spinner2Position", spinner2.getSelectedItemPosition());
        editor3.putInt("spinner3Position", spinner3.getSelectedItemPosition());
        editor1.commit();
        editor2.commit();
        editor3.commit();*/
        Intent intent = new Intent(SearchPhaseOneActivity.this, SpotActivity.class);
        intent.putExtra("spinner1", spinner1.getSelectedItem().toString());
        intent.putExtra("spinner2", spinner2.getSelectedItem().toString());
        intent.putExtra("spinner3", spinner3.getSelectedItem().toString());
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_phase_one, menu);
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
