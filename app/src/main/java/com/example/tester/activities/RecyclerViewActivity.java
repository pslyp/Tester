package com.example.tester.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tester.R;
import com.example.tester.adapter.RecyclerAdapter;
import com.example.tester.models.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initInstance();
        initLogic();
    }

    private void initInstance() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());

        recyclerView.setLayoutManager(linearLayoutManager);

        List<User> userList = new ArrayList<>();

        userList.add(new User("A"));
        userList.add(new User("B"));
        userList.add(new User("C"));
        userList.add(new User("D"));
        userList.add(new User("E"));

        RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext(), userList);

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User item) {
                Toast.makeText(RecyclerViewActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnFavoriteCheckedChangedListener(new RecyclerAdapter.OnFavoriteCheckedChangedListener() {
            @Override
            public void onFavoriteCheckedChanged(boolean isChecked, User item) {
                Toast.makeText(RecyclerViewActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initLogic() {

    }
}
