package com.demo.materialdem;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class MainActivity extends Activity implements View.OnClickListener {
    private View androidRobotView;
    private View imgContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

// get the common element for the transition in this activity
        androidRobotView = findViewById(R.id.image_container);

    }

    public void onSomeButtonClicked(View view) {
       /* //ending x co-ordinates
        float x1 = androidRobotView.getX();
        float y1 = androidRobotView.getY();

        //ending x co-ordinates
        float x3 = x1/2;
        float y3 = y1/2;

        final Path path = new Path();
        path.moveTo(x1, y1);

        final float x2 = (x1 + x3) / 2;
        final float y2 = y1;

        path.quadTo(x2, y2, x3, y3);

        ObjectAnimator anim = ObjectAnimator.ofFloat(androidRobotView, View.X, View.Y, path);
        anim.start();*/

      /* getWindow().setExitTransition(new Explode());
        Intent intent = new Intent(this, MyOtherActivity.class);
        startActivity(intent,
                ActivityOptions
                        .makeSceneTransitionAnimation(this).toBundle());*/
        Intent intent = new Intent(getApplicationContext(), MyOtherActivity.class);
        // create the transition animation - the images in the layouts
        // of both activities are defined with android:transitionName="image"

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, androidRobotView, "image");
        // start the new activity
        startActivity(intent, options.toBundle());


        // first 0f, 1f mean scaling from X-axis to X-axis, meaning scaling from 0-100%
// first 0f, 1f mean scaling from Y-axis to Y-axis, meaning scaling from 0-100%
// The two 0.5f mean animation will start from 50% of X-axis & 50% of Y-axis, i.e. from center

 /*       ScaleAnimation fade_in =  new ScaleAnimation(view.getWidth(), 1f, view.getHeight(), 1f, Animation.RELATIVE_TO_SELF,view.getWidth()/2, Animation.RELATIVE_TO_SELF,view.getHeight()/2);
        fade_in.setDuration(1000);     // animation duration in milliseconds
        fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
        view.startAnimation(fade_in);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MyOtherActivity.class);
        // create the transition animation - the images in the layouts
        // of both activities are defined with android:transitionName="robot"
        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this, androidRobotView, "robot");
        // start the new activity
        startActivity(intent, options.toBundle());
    }
}
