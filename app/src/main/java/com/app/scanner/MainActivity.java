package com.app.scanner;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout bg;
    ImageView img;
    Animation totop,frombtm,frmtop;
    CardView strt;
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    LinearLayout dotsll;

    private TextView[] mdots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg = findViewById(R.id.bg);
        strt = findViewById(R.id.strt);
        img = findViewById(R.id.img);
        dotsll = findViewById(R.id.dotsll);
        totop = AnimationUtils.loadAnimation(this,R.anim.totop);
        frombtm = AnimationUtils.loadAnimation(this,R.anim.frombtm);
        frmtop = AnimationUtils.loadAnimation(this,R.anim.frmtop);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        bg.setAnimation(totop);
        strt.setAnimation(frombtm);
        img.setAnimation(frmtop);

        addDots(0);

        viewPager.addOnPageChangeListener(viewlistner);

        strt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Home.class);
               startActivity(intent);

            }
        });

    }

    public void  addDots(int position){
        mdots = new TextView[3];
        dotsll.removeAllViews();

        for (int i =0; i< mdots.length;i++){
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.grey));

            dotsll.addView(mdots[i]);
        }
        if (mdots.length > 0){
            mdots[position].setTextColor(getResources().getColor(R.color.colorwhite));
        }
    }
    ViewPager.OnPageChangeListener viewlistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDots(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
