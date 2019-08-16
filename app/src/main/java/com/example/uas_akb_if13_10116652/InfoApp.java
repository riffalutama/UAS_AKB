package com.example.uas_akb_if13_10116652;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uas_akb_if13_10116652.Adapter.SlideAdapter;
import com.example.uas_akb_if13_10116652.R;

public class InfoApp extends AppCompatActivity {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    private ViewPager slidePager;
    private LinearLayout mDotLayout;

    private TextView[] dots;

    private SlideAdapter slideAdapter;

    private Button btnPrev, btnNext, btnFinish;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_app);

        slidePager = (ViewPager)findViewById(R.id.viewPager);
        mDotLayout = (LinearLayout)findViewById(R.id.dotLayout);

        btnNext = (Button)findViewById(R.id.btnNext);
        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnFinish = (Button)findViewById(R.id.btnFinish);

        slideAdapter = new SlideAdapter(this);
        slidePager.setAdapter(slideAdapter);

        addDotsIndicator(0);

        slidePager.addOnPageChangeListener(viewListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidePager.setCurrentItem(currentPage + 1);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidePager.setCurrentItem(currentPage - 1);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(InfoApp.this,BottomNavigation.class);
                startActivity(intentLogin);
                finish();
            }
        });
    }

    public void addDotsIndicator(int position){
        dots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i = 0;i < dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextSize(50);
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            currentPage = i;

            if(i==0){
                btnNext.setEnabled(true);
                btnPrev.setEnabled(false);
                btnPrev.setVisibility(View.INVISIBLE);
                btnFinish.setVisibility(View.INVISIBLE);
                btnNext.setVisibility(View.VISIBLE);

                btnNext.setText("Next");
                btnPrev.setText("");
            }
            else if(i==dots.length - 1){
                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.INVISIBLE);
                btnFinish.setVisibility(View.VISIBLE);

                btnNext.setText("Finish");
                btnPrev.setText("prev");
            }
            else{
                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);
                btnFinish.setVisibility(View.INVISIBLE);
                btnNext.setVisibility(View.VISIBLE);

                btnNext.setText("Next");
                btnPrev.setText("prev");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
