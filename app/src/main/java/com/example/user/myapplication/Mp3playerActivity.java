package com.example.user.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Mp3playerActivity extends AppCompatActivity {
    private MediaPlayer mp = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3player);
        init();
    }

    private void init(){
        setTitle(R.string.mp3_player_title);
    }


    public void clkPlayer(View v){
        if(v instanceof Button){
            Log.i("test","cklPlayer : " + v.getId());
            switch (v.getId()){
                case R.id.mp3SongBtn1:
                    _doStop();
                    mp = MediaPlayer.create(Mp3playerActivity.this, R.raw.primary_playboysdiary);
                    mp.start();
                    break;
                case R.id.mp3SongBtn2:
                    _doStop();
                    mp = MediaPlayer.create(Mp3playerActivity.this, R.raw.primary_love);
                    mp.start();
                    break;
                case R.id.pause_and_playBtn:
                    if(mp == null){

                    }else{
                        Button btn = (Button)v;
                        String txt = btn.getText().toString();
                        if(txt.equals(getString(R.string.mp3_player_button_pause))){
                            btn.setText(R.string.mp3_player_button_play);//재생으로 뷰 변경
                            mp.pause();
                        }else{
                            btn.setText(R.string.mp3_player_button_pause);//일시정지로 뷰 변경
                            mp.start();
                        }
                        break;
                    }

                case R.id.stopBtn:
                    _doStop();

                    break;
            }
        }
    }

    private void _doStop(){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
