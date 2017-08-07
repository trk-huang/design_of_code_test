package com.zhiping.alibaba.design_of_code_test.strategy;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhiping.alibaba.design_of_code_test.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button okBtn;
    private Button resetBtn;
    private EditText mPriceEditText;
    private EditText mSlEdittext;
    private TextView mTextView;
    private RadioGroup mRadioGroup;

    private CashStrategy mCashStrategy;
    private float price;
    private int num;
    private double sum;
    private StringBuilder jiTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        okBtn = (Button) this.findViewById(R.id.button);
        resetBtn = (Button) this.findViewById(R.id.button2);
        mPriceEditText = (EditText) this.findViewById(R.id.editText);
        mSlEdittext = (EditText) this.findViewById(R.id.editText2);
        mTextView = (TextView) this.findViewById(R.id.textView);
        mRadioGroup = (RadioGroup) this.findViewById(R.id.radiogroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        mCashStrategy = CashFactory.cashContext(0);
                        break;
                    case R.id.radioButton2:
                        mCashStrategy = CashFactory.cashContext(1);
                        break;
                    case R.id.radioButton3:
                        mCashStrategy = CashFactory.cashContext(2);
                        break;
                    default:
                        mCashStrategy = CashFactory.cashContext(0);
                        break;
                }
            }
        });
        okBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        jiTxt = new StringBuilder();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                sumPrice();
                break;
            case R.id.button2:
                mPriceEditText.setText(null);
                mSlEdittext.setText(null);
                break;
        }
    }

    private void sumPrice() {
        String price = mPriceEditText.getText().toString().trim();
        String num = mSlEdittext.getText().toString().trim();
        sum += Double.parseDouble(price) * Integer.parseInt(num);
        sum = mCashStrategy.acceptCash(sum);
        jiTxt.append("单价: ").append(price).append(" 数量： ").append(num).append(" 合计： ").append(sum).append(" \n");
        mTextView.setText(jiTxt.toString());
        mPriceEditText.setText(null);
        mSlEdittext.setText(null);

    }
}
