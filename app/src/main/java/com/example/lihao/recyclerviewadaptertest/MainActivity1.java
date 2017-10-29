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

////该方法可以解决点击listview  item中某一个组件的问题
public class MainActivity1 extends AppCompatActivity {
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
        for (int i = 0;i<10;i++){
            studentList.add(new Student(i,"student"+i));
        }
        listView.setAdapter(new CommonAdapter<Student>(this, R.layout.list_item1,studentList) {
            @Override
            protected void convert(ViewHolder viewHolder, Student item, final int position) {

                viewHolder.setText(R.id.tv_index,item.getIndex()+"");
                viewHolder.setText(R.id.id_item_list_title,item.getName());
                //该方法可以解决点击listview  item中某一个组件的问题
                viewHolder.setOnClickListener(R.id.tv_index,new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity1.this,studentList.get(position).getIndex()+"",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Index: "+studentList.get(position).getIndex());
                    }
                });
            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView) {
                super.onViewHolderCreated(holder, itemView);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity1.this,studentList.get(position).getName(),Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onItemClick: "+studentList.get(position).getName());
            }
        });

    }
}
