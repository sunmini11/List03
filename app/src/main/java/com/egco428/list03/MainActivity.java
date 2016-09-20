package com.egco428.list03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String Course_Title = "Course Title";
    public static final String Course_Desc = "Course Description";
    public static final String Course_Num = "Course Number";
    public static final String Course_credit = "Credits";
    public static final String image = "Image";
    public static final int DETAIL_REQ_CODE = 1001;
    protected List<Course> data;
    int[] imageCourse = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = DataProvider.getData();
        ListView listView = (ListView)findViewById(R.id.list);
        //ArrayAdapter<Course> courseArrayAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, data, imageCourse);

        CustomAdapter adapter = new CustomAdapter(this, data, imageCourse);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Course course = data.get(position);
                displayDetail(course,position);
            }
        });
//        List<Course> data = DataProvider.getData();
//        Iterator<Course> iterator = data.iterator();
//
//        StringBuilder builder = new StringBuilder();
//        while (iterator.hasNext()){
//            Course course = iterator.next();
//            builder.append(course.getTitle()).append("\n");
//
//        }
//        TextView courseTextView = (TextView)findViewById(R.id.courseListView);
//        courseTextView.setText(builder.toString());
    }
    private void displayDetail(Course course,int position){
        String coNum = String.valueOf(course.getCourseNumber());
        String coCredit = String.valueOf(course.getCredits());
        String po = String.valueOf(position);

        Log.d("MainActivity", "Displaying Course: "+course.getTitle());
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Course_Title, course.getTitle());
        intent.putExtra(Course_Desc, course.getDescription());
        intent.putExtra(Course_Num,coNum);
        intent.putExtra(Course_credit, coCredit);
        intent.putExtra(image, po);
        startActivityForResult(intent, DETAIL_REQ_CODE);
    }

}
