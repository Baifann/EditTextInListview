package com.baifan.listvviewandedittext;

import android.content.Context;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baifan on 16/6/2.
 */
public class SecondAdapter extends BaseAdapter {
    private List<News> mList = new ArrayList<>();

    private Context mContext;



    public void setList(List<News> list) {
        mList = list;
    }

    public SecondAdapter(Context context) {
        mContext = context;
        getResourceArray();
    }

    private List<String> mSpinnerList = new ArrayList<>();

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_lv, null);
            vh.mEdtTitle = (EditText) convertView.findViewById(R.id.edt);
            vh.mEdtContent = (EditText) convertView.findViewById(R.id.edt_content);
            vh.mSpinner = (Spinner) convertView.findViewById(R.id.spinner);
            vh.mEdtSpinner = (EditText) convertView.findViewById(R.id.edt_spinner);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.position = position;

        //设置值
        vh.mEdtTitle.setText(mList.get(position).getTitle());
        vh.mEdtContent.setText(mList.get(position).getContent());
        getStrSetSelection(mList.get(position).getSpinnerContent(), vh.mSpinner);
        getStrSetEdt(mList.get(position).getEdtSpiContent(), vh.mEdtSpinner);

        vh.mEdtTitle.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                mList.get(vh.position).setTitle(s.toString());
            }
        });

        vh.mEdtContent.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                mList.get(vh.position).setContent(s.toString());
            }
        });

        vh.mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mList.get(vh.position).setSpinnerContent(mSpinnerList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initListPop(vh, vh.mEdtSpinner);
        return convertView;
    }

    private class ViewHolder {
        int position;
        EditText mEdtTitle;
        EditText mEdtContent;
        Spinner mSpinner;
        EditText mEdtSpinner;
    }

    private void getResourceArray() {
        String[] args = mContext.getResources().getStringArray(R.array.languages);
        mSpinnerList = Arrays.asList(args);
    }

    private void getStrSetSelection(String s, Spinner spinner) {
        Log.i("caonima", "s:" + s);
        int index = mSpinnerList.indexOf(s);
        if (index >= 0) {
            spinner.setSelection(index);
        } else {
            spinner.setSelection(0);
        }
    }

    private void getStrSetEdt(String s, EditText editText) {
        Log.i("caonima", "s:" + s);
        int index = mSpinnerList.indexOf(s);
        if (index >= 0) {
            editText.setText(mSpinnerList.get(index));
        } else {
            editText.setText(mSpinnerList.get(0));
        }
    }

    private void initListPop(final ViewHolder vh, EditText editText) {
        final ListPopupWindow mListPop = new ListPopupWindow(mContext);
        mListPop.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, mSpinnerList));
        mListPop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListPop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListPop.setAnchorView(editText);//设置ListPopupWindow的锚点，即关联PopupWindow的显示位置和这个锚点
        mListPop.setModal(true);//设置是否是模式

        mListPop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vh.mEdtSpinner.setText(mSpinnerList.get(position));
                mList.get(vh.position).setEdtSpiContent(mSpinnerList.get(position));
                mListPop.dismiss();
            }
        });

        vh.mEdtSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListPop.show();
            }
        });
    }
}
