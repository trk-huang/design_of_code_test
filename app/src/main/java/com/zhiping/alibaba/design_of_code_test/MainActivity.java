package com.zhiping.alibaba.design_of_code_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result_txt;
    private GridView operation_grid;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;

    private double numA, numB;
    private boolean isOperation;

    private Operation mOperation;
    private ArrayList<HashMap<String, Object>> numbs = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("txt_item", i);
            numbs.add(map);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_txt = (TextView) this.findViewById(R.id.result);
        addBtn = (Button) this.findViewById(R.id.add);
        subBtn = (Button) this.findViewById(R.id.sub);
        mulBtn = (Button) this.findViewById(R.id.mul);
        divBtn = (Button) this.findViewById(R.id.div);
        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
        operation_grid = (GridView) this.findViewById(R.id.operation_grid);
        SimpleAdapter adapter = new SimpleAdapter(this, numbs, R.layout.layout, new String[]{"txt_item"}, new int[]{R.id.txt_item});
        operation_grid.setAdapter(adapter);
        operation_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!isOperation) {
                    numA = position;
                    result_txt.setText("结果 = " + numA);
                } else {
                    numB = position;
                    mOperation.setNumberA(numA);
                    mOperation.setNumberB(numB);
                    result_txt.setText("结果 = " + mOperation.getResult());
                    isOperation = false;
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        isOperation = true;
        switch (v.getId()) {

            case R.id.add:
                mOperation = OperationFactory.createOperation("+");
                break;
            case R.id.sub:
                mOperation = OperationFactory.createOperation("-");
                break;
            case R.id.mul:
                mOperation = OperationFactory.createOperation("*");
                break;
            case R.id.div:
                mOperation = OperationFactory.createOperation("/");
                break;
        }
    }
}
