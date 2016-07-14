package com.baifan.listvviewandedittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListPopupWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baifan on 16/6/2.
 */
public class PopListEditText extends EditText implements View.OnTouchListener, AdapterView.OnItemSelectedListener {
    private List<String> mSpinnerList = new ArrayList<>();

    public PopListEditText(Context context) {
        this(context, null);
    }

    public PopListEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopListEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void getArray() {
        String args[] = getResources().getStringArray(R.array.languages);
        mSpinnerList = Arrays.asList(args);
    }

    private void init() {
        getArray();
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            ListPopupWindow lpw = new ListPopupWindow(getContext());
            lpw.setAdapter(new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_list_item_1, mSpinnerList));
            lpw.setAnchorView(this);
            lpw.setModal(true);
            lpw.setOnItemSelectedListener(this);
        }
        return false;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setText(mSpinnerList.get(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
