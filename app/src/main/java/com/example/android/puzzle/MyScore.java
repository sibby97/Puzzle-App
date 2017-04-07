package com.example.android.puzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_score);
        TextView textView = (TextView)findViewById(R.id.scores);
        Globals g = Globals.getInstance();
        Button back = (Button) findViewById(R.id.back);
        String ms = "";
        for(int i=0;i<12;i++){
            if(g.gettime(i) != 0){
                int x = i+1;
                ms += "Your highscore in level "+x+" is : "+ g.gettime(i)+" secs \n";
            }
        }
        textView.setText(ms);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyScore.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
