package com.epicodus.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WordActivity extends AppCompatActivity {
    @Bind(R.id.listView)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ArrayList<String> userAnswers =  intent.getStringArrayListExtra("words");

        mListView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,  userAnswers));

    }
}
