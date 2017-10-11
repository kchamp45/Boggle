package com.epicodus.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    GridView gridView;
    ArrayList<String> userAnswers = new ArrayList<>();
    private String[] vowels = {"a", "e", "o", "u", "i"};
    private String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n",
            "p", "q", "r", "s", "t", "v", "w", "x", "y", "z" };
    @Bind(R.id.submit_button) Button mSubmitButton;
    @Bind(R.id.edit_text_user_input) EditText mWordEditText;
    @Bind(R.id.show_list_button) Button mShowListButton;
    @Bind(R.id.grid_view) GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mGridView.setAdapter(new LettersAdapter(this, vowels, consonants));


        mSubmitButton.setOnClickListener(this);
        mShowListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mSubmitButton) {
            String userInputWord = mWordEditText.getText().toString();
            checkUserInput(userInputWord);

        } else if(view == mShowListButton){
            Intent intent = new Intent(MainActivity.this, WordActivity.class);
            intent.putStringArrayListExtra("words", userAnswers);
            startActivityForResult(intent, 1);
        }
    }

    private void checkUserInput(String word) {
        if(word.length() < 3 || word.length() > 8) {
            mWordEditText.setError("Enter at least 3 characters");
        } else {
            userAnswers.add(word);
            mWordEditText.getText().clear();
        }
    }
}
