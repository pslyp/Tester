package com.example.tester.activities;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tester.R;
import es.dmoral.toasty.Toasty;

public class ToastyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private ImageView imageView;
    private CheckBox checkBox;
    private Button normalButton, infoButton, successButton, errorButton;

    private static final int PICK_IMAGE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toasty);

        initInstance();
    }

    private void initInstance() {
        editText = findViewById(R.id.edit_text);
        imageView = findViewById(R.id.image_view);
        imageView.setOnClickListener(this);
        checkBox = findViewById(R.id.check_box);
        normalButton = findViewById(R.id.normal_button);
        normalButton.setOnClickListener(this);
        infoButton = findViewById(R.id.info_button);
        infoButton.setOnClickListener(this);
        successButton = findViewById(R.id.success_button);
        successButton.setOnClickListener(this);
        errorButton = findViewById(R.id.error_button);
        errorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String text = editText.getText().toString().trim();
        boolean withIcon = checkBox.isChecked();

        switch (v.getId()) {
            case R.id.image_view:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
                break;
            case R.id.normal_button:
                Toasty.normal(getApplicationContext(), text, Toasty.LENGTH_SHORT, imageView.getDrawable(), withIcon).show();
                break;
            case R.id.info_button:
                Toasty.info(getApplicationContext(), text, Toasty.LENGTH_SHORT, withIcon).show();
                break;
            case R.id.success_button:
                Toasty.success(getApplicationContext(), text, Toasty.LENGTH_SHORT, withIcon).show();
                break;
            case R.id.error_button:
                Toasty.error(getApplicationContext(), text, Toasty.LENGTH_SHORT, withIcon).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        }
    }
}