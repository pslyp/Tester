package com.example.tester.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.tester.R;

public class ImageRoundedActivity extends AppCompatActivity {

    private ImageView imageView;

    private CrystalRangeSeekbar rangeSeekbar;
    private TextView tvMin, tvMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_rounded);

        initInstance();
    }

    private void initInstance() {
//        imageView = findViewById(R.id.image_view);

//        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.cat)).getBitmap();
//        Bitmap imageRounded = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
//        Canvas canvas = new Canvas(imageRounded);
//        Paint mPaint = new Paint();
//        mPaint.setAntiAlias(true);
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
//        canvas.drawRoundRect((new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight())), 100, 100, mPaint);
//
//        imageView.setImageBitmap(imageRounded);

        rangeSeekbar = findViewById(R.id.rangeSeekbar);

        tvMin = findViewById(R.id.text_min);
        tvMax = findViewById(R.id.text_max);

        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.format("%.2f", minValue));
                tvMax.setText(String.format("%.2f", maxValue));
            }
        });


    }
}
