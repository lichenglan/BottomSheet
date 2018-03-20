package com.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    private List<String> initPanelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        button3 = findViewById(R.id.btn_3);

        intListener();
    }

    private void intListener() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBottom();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }


    private void openBottom() {

        //初始化名称
//        initPanelList.clear();
        initPanelList.add("回家情景");
        initPanelList.add("离家情景");
        initPanelList.add("会客情景");
        initPanelList.add("影音情景");
        initPanelList.add("阅读情景");
        initPanelList.add("浪漫情景");
        initPanelList.add("睡眠情景");
        initPanelList.add("起夜情景");
        initPanelList.add("起床情景");
        initPanelList.add("布防情景");
        initPanelList.add("撤防情景");
        initPanelList.add("紧急警报");
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.recyclerview, null);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        BottomSheetAdapter adapter = new BottomSheetAdapter(this, initPanelList);
        recyclerView.setAdapter(adapter);

        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(recyclerView);

        final FrameLayout frameLayout =  dialog.findViewById(android.support.design.R.id.design_bottom_sheet);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                BottomSheetBehavior behavior = BottomSheetBehavior.from(frameLayout);
                behavior.setPeekHeight(0);//BottomSheetBehavior停留的高度

                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);//展开
                frameLayout.forceLayout();

            }
        });

        dialog.show();
        adapter.setOnItemClickListener(new BottomSheetAdapter.OnBottomItemClickListener() {
            @Override
            public void onItemClick(int position, String text) {
                dialog.dismiss();
            }
        });
    }

}
