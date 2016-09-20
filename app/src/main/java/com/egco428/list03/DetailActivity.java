package com.egco428.list03;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //set back button

        String courseTitle = getIntent().getStringExtra(MainActivity.Course_Title);
        TextView titleText = (TextView)findViewById(R.id.courseTitleText);
        titleText.setText(courseTitle);

        String courseDesc = getIntent().getStringExtra(MainActivity.Course_Desc);
        TextView descText = (TextView)findViewById(R.id.descriptionText);
        descText.setText(courseDesc);

        String courseNum = getIntent().getStringExtra(MainActivity.Course_Num);
        TextView numText = (TextView)findViewById(R.id.courseNumView);
        numText.setText("Course Number = "+courseNum);
        img(courseNum);

        String courseCredits = getIntent().getStringExtra(MainActivity.Course_credit);
        TextView creditText = (TextView)findViewById(R.id.creditView);
        creditText.setText("Credits = "+courseCredits+"    ");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
public void img(String course){
    //int id = getResources().getIdentifier(course,"drawable",getPackageName());
    HashMap<String, Integer> MMap = new HashMap<String, Integer>();
    MMap.put("10101",R.drawable.pic1);
    MMap.put("10102",R.drawable.pic2);
    MMap.put("10103",R.drawable.pic3);
    MMap.put("10104",R.drawable.pic4);
    MMap.put("10105",R.drawable.pic5);
    MMap.put("10106",R.drawable.pic6);
    MMap.put("10107",R.drawable.pic7);
    MMap.put("10108",R.drawable.pic8);

    ImageView imagecourse = (ImageView)findViewById(R.id.imageView2);
    imagecourse.setImageResource(MMap.get(course));
}
}



