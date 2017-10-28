package com.example.lihao.recyclerviewadaptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lihao.recyclerviewadaptertest.bean.Student;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @InjectView(R.id.listView)
    ListView listView;
    private List<Student> studentList = new ArrayList<>();
    private List<String> mDatas = new ArrayList<>(Arrays.asList("MultiItem ListView",
            "RecyclerView",
            "MultiItem RecyclerView"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        listView.setAdapter(new CommonAdapter<String>(this, R.layout.list_item,mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {

                viewHolder.setText(R.id.id_item_list_title,item);
            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView) {
                super.onViewHolderCreated(holder, itemView);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,mDatas.get(position),Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onItemClick: "+mDatas.get(position));
            }
        });

    }
}
