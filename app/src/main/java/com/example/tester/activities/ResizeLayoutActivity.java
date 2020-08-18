package com.example.tester.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.tester.R;
import com.example.tester.animetations.SlideAnimation;

public class ResizeLayoutActivity extends AppCompatActivity {

    private LinearLayout sortView;
    private Boolean statusView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize_layout);

        initInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.resize_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_menu :
                if(!statusView) {
//                    showView(sortView, 0, 300);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(sortView, View.TRANSLATION_Y, 300f);
                    anim.setDuration(300);
                    anim.setInterpolator(new AccelerateInterpolator());
                    anim.start();
                } else {
                    showView(sortView, 300, 0);
                }
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    private void initInstance() {
        sortView = findViewById(R.id.sort_view);
    }

    private void showView(LinearLayout view, int fromHeight, int toHeight) {
        Animation animation = new SlideAnimation(view, fromHeight, toHeight);

        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(300);

        sortView.setAnimation(animation);
        sortView.startAnimation(animation);

        statusView = true;
    }

//    private void hideView(View view, int fromHeight, int toHeight) {
////        Animation animation = new SlideAnimation(view, fromHeight, toHeight);
//
//        animation.setInterpolator(new AccelerateInterpolator());
//        animation.setDuration(300);
//
//        sortView.setAnimation(animation);
//        sortView.startAnimation(animation);
//
//        statusView = false;
//    }

}
