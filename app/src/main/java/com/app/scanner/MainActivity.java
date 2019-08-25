package com.app.scanner;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout bg;
    ImageView img;
    Animation totop,frombtm,frmtop;
    CardView strt;
    private ViewPager viewPager;
    private SlideAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg = findViewById(R.id.bg);
        strt = findViewById(R.id.strt);
        img = findViewById(R.id.img);
        totop = AnimationUtils.loadAnimation(this,R.anim.totop);
        frombtm = AnimationUtils.loadAnimation(this,R.anim.frombtm);
        frmtop = AnimationUtils.loadAnimation(this,R.anim.frmtop);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        bg.setAnimation(totop);
        strt.setAnimation(frombtm);
        img.setAnimation(frmtop);

        strt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Home.class);
               startActivity(intent);

            }
        });

    }
}
