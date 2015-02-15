package com.example.terufumiozaki.holidaymaster;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {

    TextView mLblMeasuring1, mLblMeasuring2, mLblMeasuring3, mLblMeasuring4,
            mLblMeasuring5, mLblMeasuring6, mLblMeasuring7, mLblMeasuring8;
    private ScheduledExecutorService mScheduledExecutor;
    private Handler mHandler = new Handler();
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLblMeasuring1 = (TextView) findViewById(R.id.lbl_measuring1);
        mLblMeasuring2 = (TextView) findViewById(R.id.lbl_measuring2);
        mLblMeasuring3 = (TextView) findViewById(R.id.lbl_measuring3);
        mLblMeasuring4 = (TextView) findViewById(R.id.lbl_measuring4);
        mLblMeasuring5 = (TextView) findViewById(R.id.lbl_measuring5);
        mLblMeasuring6 = (TextView) findViewById(R.id.lbl_measuring6);
        mLblMeasuring7 = (TextView) findViewById(R.id.lbl_measuring7);
        mLblMeasuring8 = (TextView) findViewById(R.id.lbl_measuring8);

        startMeasure(mLblMeasuring1);
        startMeasure(mLblMeasuring2);
        startMeasure(mLblMeasuring3);
        startMeasure(mLblMeasuring4);
        startMeasure(mLblMeasuring5);
        startMeasure(mLblMeasuring6);
        startMeasure(mLblMeasuring7);
        startMeasure(mLblMeasuring8);
    }

    public void startMeasure(final TextView tv) {

        mScheduledExecutor = Executors.newScheduledThreadPool(2);
        mScheduledExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {
                        tv.setVisibility(View.VISIBLE);
                        int suuji = random.nextInt(10000000);
                        tv.setText("" + suuji);
                        animateAlpha();
                    }
                });
            }

            public void animateAlpha() {
                ArrayList<Animator> animatorList = new ArrayList<Animator>();

                ObjectAnimator animatorFadeIn = ObjectAnimator.ofFloat(tv,
                        "alpha", 0f, 1f);
                animatorFadeIn.setDuration(600);

                ObjectAnimator animatorFadeOut = ObjectAnimator.ofFloat(tv,
                        "alpha", 1f, 0f);
                animatorFadeOut.setDuration(600);

                animatorList.add(animatorFadeIn);
                animatorList.add(animatorFadeOut);


                final AnimatorSet animatorSet = new AnimatorSet();


                animatorSet.playSequentially(animatorList);
                animatorSet.start();
            }
        }, 0, 1700, TimeUnit.MILLISECONDS);
    }

    public void doAction(View v){
        Intent intent = new Intent(MainActivity.this, SearchPhaseOneActivity.class);
        startActivity(intent);
    }

    public void trendSpot2(View v){
        Intent intent1 = new Intent(MainActivity.this, TrendSpotActivity.class);
        startActivity(intent1);
    }
    public void trendSpot3(View v){
        Intent intent1 = new Intent(MainActivity.this, TrendSpotActivity.class);
        startActivity(intent1);
    }
    public void trendSpot4(View v){
        Intent intent1 = new Intent(MainActivity.this, TrendSpotActivity.class);
        startActivity(intent1);
    }
    public void trendSpot5(View v){
        Intent intent1 = new Intent(MainActivity.this, TrendSpotActivity.class);
        startActivity(intent1);
    }
    public void trendSpot6(View v){
        Intent intent1 = new Intent(MainActivity.this, TrendSpotActivity.class);
        startActivity(intent1);
    }
    public void trendSpot7(View v){
        Intent intent1 = new Intent(MainActivity.this, TrendSpotActivity.class);
        startActivity(intent1);
    }
    public void trendSpot8(View v){
        Intent intent1 = new Intent(MainActivity.this, TrendSpotActivity.class);
        startActivity(intent1);
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
