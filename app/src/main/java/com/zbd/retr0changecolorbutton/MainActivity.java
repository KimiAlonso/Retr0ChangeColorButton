package com.zbd.retr0changecolorbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zbd.retr0changecolorbutton.View.CircleChangeColorButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final CircleChangeColorButton cb = new CircleChangeColorButton(this);
        cb.setColor(Color.parseColor("#3F51B5"),Color.parseColor("#FF4081"),70);
        setContentView(cb);
    }
}
