package com.example.yui06.flushcardplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.yui06.flushcardplus.R.drawable.running;
import static com.example.yui06.flushcardplus.R.drawable.walking;

public class MainActivity extends AppCompatActivity {
    List<card> mCards;
    CardAdapter mCardAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.ListView);
        mCards =new ArrayList<card>();

        mCards.add(new card(R.drawable.running,getString(R.string.run_title),
        getString(R.string.run_content),getString(R.string.run_meaning)));
        mCards.add(new card(R.drawable.walking,getString(R.string.walk_title),
        getString(R.string.walk_content),getString(R.string.walk_meaning)));

        mCardAdapter=new CardAdapter(this,R.layout.card,mCards);
        mListView.setAdapter(mCardAdapter);

    }
}
