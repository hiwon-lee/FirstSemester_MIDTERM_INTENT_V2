package com.example.firstsemester_midterm_intent_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button btnreturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        
        //항목별로 투표개수 가져와서 배열에 넣음
        int[] voutcout=intent.getIntArrayExtra("votec");
        String[] imageName=intent.getStringArrayExtra("imgname");
        
        //이미지랑 이미지 이름 공간 세팅
        TextView[] tv =new TextView[9];
        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
                R.drawable.pic9}; //이미지 위치 배열

        Integer[] tvid ={R.id.tv1,R.id.tv2,R.id.tv3,
                R.id.tv4,R.id.tv5,R.id.tv6,
                R.id.tv7,R.id.tv8,R.id.tv9}; //이미지 들어갈 공간 아이디

        //최대 투표인거 띄우기

        TextView tvTop = findViewById(R.id.tvTop);
        ImageView ivTop = findViewById(R.id.ivTop);

        int maxEntry = 0; //최대인 인덱스 담는 변수
        for (int i = 1; i < voutcout.length; i++) {
            if (voutcout[maxEntry] < voutcout[i])
                maxEntry = i;
        }
        tvTop.setText(imageName[maxEntry]);
        ivTop.setImageResource(imageFileId[maxEntry]);


        //이미지에다가 이미지 이름 세팅
        for(int i =0;i<9;i++){
            tv[i] = findViewById(tvid[i]);
            tv[i].setText(imageName[i]);
        }
        RatingBar[] rbar =new RatingBar[9];
        Integer[] rbarid ={R.id.rbar1, R.id.rbar2,R.id.rbar3,
                R.id.rbar4, R.id.rbar5,R.id.rbar6,
                R.id.rbar7, R.id.rbar8,R.id.rbar9  };

        //투표 개수만큼 별 찍기
        for(int i = 0; i<9;i++) {
            rbar[i]=findViewById(rbarid[i]);
            rbar[i].setRating(voutcout[i]);
        }
        
        //돌아가기 버튼 누르면 메인으로 감
        btnreturn = findViewById(R.id.btnreturn);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}