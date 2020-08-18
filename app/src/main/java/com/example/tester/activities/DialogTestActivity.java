package com.example.tester.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tester.R;

public class DialogTestActivity extends AppCompatActivity {

    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);

        initInstance();
    }

    private void initInstance() {
        showDialog = findViewById(R.id.show_dialog_button);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               method();
            }
        });
    }

    private void method() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogTestActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dialog_test, null);

        final EditText editText = view.findViewById(R.id.edit_text);

        builder.setCancelable(false);
        builder.setMessage("Message");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogTestActivity.this, editText.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setContentView(R.layout.dialog_test);
        dialog.show();
    }
}
