package com.example.lifecycle_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("MainActivity","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //액티비티 또는 프래그먼트가 생성될때 이곳내부구문을 실행
        //첫화면 레이아웃
        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.e("MainActivity","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("MainActivity","onResume");
        super.onResume();
        //중지되어있던 액티비티가 다시 재개되는 시점에서 이곳 내부구문을 실행
    }

//여기서 어플이 정상적으로 실행
    @Override
    protected void onPause() {
        Log.e("MainActivity","onPause");
        super.onPause();
        //액티비티가 중지상태(홈버튼을 눌렀을 때,다른 액티비티가 활성화 되어있을 때)일 때 이곳 내부구문을 실행
        //투명액티비티를 띄워서 보일때는 pause까지만 실행한다.
    }

    @Override
    protected void onStop() {
        Log.e("MainActivity","onStop");
        super.onStop();
        //액티비티가 안보이게 될 때 이 구문을 실행
    }

    @Override
    protected void onRestart() {
        Log.e("MainActivity","onRestart");
        //onStop에서 다시 onStart로 넘어갈때
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e("MainActivity","onDestroy");
        super.onDestroy();
        //액티비티가 파괴될 때 소멸했을 때의 시점 일 때 이 곳 내부구문들을 실행
    }
}