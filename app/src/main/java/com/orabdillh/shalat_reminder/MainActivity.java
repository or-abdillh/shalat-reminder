package com.orabdillh.shalat_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ButtonNext = null;
    private TextView haditsArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Random Hadits
        String[] hadits = {
                "Padahal mereka tidak disuruh kecuali supaya menyembah Allah dengan memurnikan ketaatan kepada-Nya dalam(menjalankan) agama yang lurus, dan supaya mereka mendirikan shalat dan meunaikan zakat; dan yang demikian itulah agama yang lurus.",
                "Peliharalah segala shalat(mu), dan (peliharalah) shalat wusthaa. Berdirilah untuk Allah (dalam shalatmu) dengan khusyu.",
                "Jabir bin Abdullah berkata, Saya mendengar Rasulullah shallallahu alaihi wasallam bersabda: \"Yang memisahkan antara seorang laki-laki dengan kesyirikan dan kekufuran adalah meninggalkan shalat."
        };

        haditsArea = (TextView) findViewById(R.id.haditsArea);
        int random = new Random().nextInt(hadits.length);

        haditsArea.setText(hadits[random]);

        // Toast
        Toast.makeText(this, "20302022 - Oka R. Abdillah", Toast.LENGTH_SHORT).show();

        // Button Next animation
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        ButtonNext = (ImageView)findViewById(R.id.buttonNext);

        // Animate
        ButtonNext.startAnimation(shake);

        // navigate to list
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, ListActivity.class
                );
                //playAudio();
                startActivity(intent);
            }
        });
    }
}