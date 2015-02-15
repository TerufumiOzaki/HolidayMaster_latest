package com.example.terufumiozaki.holidaymaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.terufumiozaki.holidaymaster.api.FoursquareApiClientManager;
import com.example.terufumiozaki.holidaymaster.api.VenueSearchPhotos;
import com.example.terufumiozaki.holidaymaster.api.VenueSearchResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SpotActivity extends ActionBarActivity {

    String spot;
    String spinner1Position, spinner2Position, spinner3Position;
    SharedPreferences mSPspinner1, mSPspinner2, mSPspinner3;
    String id, prefix, suffix;
    TextView text2;

    /*RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://api.gnavi.co.jp/ver1/RestSearchAPI/?keyid=b58a240cb9d8c5a49537d547902985d7")
            .build();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);

        Intent intent = getIntent();
        if (intent != null) {
            spinner1Position = intent.getStringExtra("spinner1");
            spinner2Position = intent.getStringExtra("spinner2");
            spinner3Position = intent.getStringExtra("spinner3");
            Log.d("spinner`position", spinner1Position);

            FoursquareApiClientManager.service.listResponse("35.6,135.5", spinner1Position, 100000, new Callback<VenueSearchResponse>() {
                @Override
                public void success(VenueSearchResponse response, retrofit.client.Response response2) {
                    Log.d("response", response.getResponse().getVenues().get(0).getName());
                    id = response.getResponse().getVenues().get(0).getId();
                    FoursquareApiClientManager.service.listPhotos(id,new Callback<VenueSearchPhotos>() {
                        @Override
                        public void success(VenueSearchPhotos venueSearchPhotos, Response response) {
                            prefix = venueSearchPhotos.getResponse().getPhotos().get(0).getPrefix();
                            suffix = venueSearchPhotos.getResponse().getPhotos().get(0).getSuffix();
                            prefix = prefix.replaceAll("\\/", "/");
                            suffix = suffix.replaceAll("\\/", "/");
                            //id = id.replaceAll("\\/","/");
                            text2 = (TextView) findViewById(R.id.textView2);
                            text2.setText(prefix + suffix);

                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("error", error.getResponse().getReason());
                }
            });



        }

        //spinner1の中身は、選択してください→大阪→東京
        //spinner2の中身（大阪）は、選択してください→梅田→心斎橋→難波→天王寺
        //spinner2の中身（東京）は、選択してください→新宿→渋谷→世田谷→江東→目黒→港区
        //spinner3の中身は、特になし→カフェ→レストラン→面白い場所

    }

    public void retrySearching(View v) {
        Intent intent1 = new Intent(SpotActivity.this, SpotActivity.class);
        startActivity(intent1);
    }

    public void endSearching(View v) {
        Intent intent2 = new Intent(SpotActivity.this, MainActivity.class);
        startActivity(intent2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spot, menu);
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
