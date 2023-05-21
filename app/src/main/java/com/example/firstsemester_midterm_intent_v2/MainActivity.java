package com.example.firstsemester_midterm_intent_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv1, iv2;
    ImageView image[];
    Button btnresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = findViewById(R.id.iv1);
        Integer ivid[] ={
                R.id.iv1, R.id.iv2,R.id.iv3,
                R.id.iv4,R.id.iv5,R.id.iv6,
                R.id.iv7,R.id.iv8,R.id.iv9  };
        image =new ImageView[9];

        int[] votecount =new int[9];
        //투표개수 0으로 초기화
        for(int i=0;i<9;i++){
            votecount[i]=0;
        }

        String[] imageName ={"책읽는 소녀","모자소녀","부채소녀",
                "이레느강","잠든소녀","두자매",
                "피아노","피아노소녀","해변"    };

        for(int i = 0; i<ivid.length;i++){
            final int index = i;
            image[index] = findViewById(ivid[index]);

            //이미지를 클릭하면, 해당 투표수를 증가
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    votecount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imageName[index]+":총"+votecount[index]+"표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }//for

        //결과보러가기 버튼 클릭하면, 인텐트에 투표 수랑 이미지 이름 넣어서 결과액티비티에 보냄
        btnresult = findViewById(R.id.btnresult);
        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ResultActivity.class );
                intent.putExtra("votec",votecount);
                intent.putExtra("imgname",imageName);
                startActivity(intent);
            }
        });
    }//oncreate
}//class