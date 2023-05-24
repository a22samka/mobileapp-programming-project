package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22samka";

    private RecyclerView RecyclerView;
    private ArrayList<Djur> apor;
    private DjurAdapter adapter;

    private Button Knapp;

    private Intent newIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Knapp = findViewById(R.id.button1);

        Knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                newIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(newIntent);
            }
        });

        RecyclerView = findViewById(R.id.myRecycler_view);
        apor = new ArrayList<Djur>();
        adapter = new DjurAdapter(apor);
        RecyclerView.setAdapter(adapter);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        new JsonTask(this).execute(JSON_URL);
    }
        @Override
        public void onPostExecute(String json) {
            Log.d("tomten", "onPostExecute: " +json);

            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Djur>>() {}.getType();
            ArrayList<Djur> data = gson.fromJson(json, type);
            apor.addAll(data);
            adapter.notifyDataSetChanged();
        }


}
