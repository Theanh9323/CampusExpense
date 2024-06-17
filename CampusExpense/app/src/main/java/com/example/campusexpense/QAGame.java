package com.example.campusexpense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class QAGame extends AppCompatActivity {
    private ImageView image;
    private RadioButton answer;
    private Button next;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qa_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Integer> imgList = new ArrayList<>();
        List<String> answerList = new LinkedList<>();
        answerList.add("licon");
        answerList.add("cadilac");
        answerList.add("mercedes");
        answerList.add("acura");
        imgList.add(R.drawable.licon);
        imgList.add(R.drawable.cadilac);
        imgList.add(R.drawable.mercedes);
        imgList.add(R.drawable.acura);
        image = findViewById(R.id.img_question);
        next = findViewById(R.id.btn_next);
        RadioButton answer1 = findViewById(R.id.rb_answer1);
        RadioButton answer2 = findViewById(R.id.rb_answer2);
        RadioButton answer3 = findViewById(R.id.rb_answer3);
        RadioButton answer4 = findViewById(R.id.rb_answer4);
        Collections.shuffle(imgList);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Collections.shuffle(answerList);
                if(i < imgList.size()) {
                    image.setImageResource(imgList.get(i));
                    i++;
                }
                int j = 0;
                if(i < imgList.size()) {
                    answer1.setText(answerList.get(j));
                    answer2.setText(answerList.get(j+1));
                    answer3.setText(answerList.get(j+2));
                    answer4.setText(answerList.get(j+3));
                }
            }
        });


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}