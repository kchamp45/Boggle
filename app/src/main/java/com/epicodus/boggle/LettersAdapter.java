package com.epicodus.boggle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Guest on 10/11/17.
 */

public class LettersAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mVowels;
    private String[] mConsonants;

    public LettersAdapter(Context mContext, String[] mVowels, String[] mConsonants) {
        this.mContext = mContext;
        this.mVowels = mVowels;
        this.mConsonants = mConsonants;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        ArrayList<String> lettersList = selectLetters(2, 6);

        if(convertView == null) {
            gridView = inflater.inflate(R.layout.letter_activity, null);

            TextView letterTextView = gridView.findViewById(R.id.grid_letter);
            letterTextView.setText(lettersList.get(position));
        } else {
            gridView = convertView;
        }
        return gridView;
    }

    private ArrayList<String> selectLetters(int k, int m) {
        int vowelsInt;
        int consonantsInt;
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            vowelsInt = (int) Math.floor(Math.random() * 5);
            letters.add(mVowels[vowelsInt]);
        }

        for (int j = 0; j < m; j++) {
            consonantsInt = (int) Math.floor(Math.random() * 21);
            letters.add(mConsonants[consonantsInt]);
        }
        return letters;
    }
}
