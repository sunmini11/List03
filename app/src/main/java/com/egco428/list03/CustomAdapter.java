package com.egco428.list03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell pc on 19/9/2559.
 */
public class CustomAdapter extends BaseAdapter{
    Context mContext;
    List<Course> list;
    int[] resId;

    public CustomAdapter(Context context, List<Course> list, int[] resId) {
        this.mContext= context;
        this.list = list;
        this.resId = resId;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
            view = mInflater.inflate(R.layout.listview_row, parent, false);

        Course course = list.get(position);

        TextView textView = (TextView)view.findViewById(R.id.textView);
        String title = course.getTitle();
        textView.setText(title);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView3);
        //imageView.setBackgroundResource(resId[position]);
        int image = resId[position];
        imageView.setImageResource(image);


        return view;
    }
}
