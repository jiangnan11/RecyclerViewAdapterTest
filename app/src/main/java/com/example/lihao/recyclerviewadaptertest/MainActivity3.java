package com.example.lihao.recyclerviewadaptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lihao.recyclerviewadaptertest.bean.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity3 extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @InjectView(R.id.id_recyclerview)
    RecyclerView idRecyclerview;
    private List<Student> studentList = new ArrayList<>();
    private List<String> mDatas = new ArrayList<>(Arrays.asList("MultiItem ListView",
            "RecyclerView",
            "MultiItem RecyclerView"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_recyclerview);
        ButterKnife.inject(this);
        for (int i = 0; i < 50; i++) {
            studentList.add(new Student(i, "student" + i));
        }
        //设置成垂直布局
//        idRecyclerview.setLayoutManager(new LinearLayoutManager(this));
//        idRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //设置成网格布局
        idRecyclerview.setLayoutManager(new GridLayoutManager(this,4));
        idRecyclerview.addItemDecoration(new DividerGridItemDecoration(this));
        idRecyclerview.setAdapter(new HomeAdapter());
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(MainActivity3.this).inflate(R.layout.list_item1, parent, false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.tv_index.setText(studentList.get(position).getIndex() + "");
            holder.id_item_list_title.setText(studentList.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_index;
            TextView id_item_list_title;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv_index = (TextView) itemView.findViewById(R.id.tv_index);
                id_item_list_title = (TextView) itemView.findViewById(R.id.id_item_list_title);

            }
        }
    }
}
