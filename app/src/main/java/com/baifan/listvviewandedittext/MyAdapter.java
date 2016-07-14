package com.baifan.listvviewandedittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baifan on 16/6/1.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;

    private List<News> mList = new ArrayList<>();

    public MyAdapter(Context context) {
        mContext = context;
    }

    public void setList(List<News> list) {
        mList = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 20;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHoder vh;
        if (convertView == null) {
            vh = new ViewHoder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_lv, null);
            vh.mEdtTitle = (EditText) convertView.findViewById(R.id.edt);
            vh.mEdtContent = (EditText) convertView.findViewById(R.id.edt_content);
            vh.mBtnLog = (Button) convertView.findViewById(R.id.btn_log);
            convertView.setTag(vh);
        } else {
            vh = (ViewHoder) convertView.getTag();
        }
        final News news = mList.get(position);

        removeTextWatcher(vh.mEdtTitle);
        removeTextWatcher(vh.mEdtContent);

        //设置值
        if (TextUtils.isEmpty(news.getTitle())) {
            vh.mEdtTitle.setText("");
        } else {
            vh.mEdtTitle.setText(news.getTitle());
        }

        if (TextUtils.isEmpty(news.getContent())) {
            vh.mEdtContent.setText("");
        } else {
            vh.mEdtContent.setText(news.getContent());
        }

        vh.mBtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //获取焦点或者去除焦点
        if (news.isTitleFocus()) {
            if (!vh.mEdtTitle.isFocused()) {
                vh.mEdtTitle.requestFocus();
            }
            CharSequence text = news.getTitle();
            vh.mEdtTitle.setSelection(TextUtils.isEmpty(text) ? 0 : text.length());
        } else {
            if (vh.mEdtTitle.isFocused()) {
                vh.mEdtTitle.clearFocus();
            }
        }

        if (news.isContentFocus()) {
            if (!vh.mEdtContent.isFocused()) {
                vh.mEdtContent.requestFocus();
            }
            CharSequence text = news.getContent();
            vh.mEdtContent.setSelection(TextUtils.isEmpty(text) ? 0 : text.length());
        } else {
            if (vh.mEdtContent.isFocused()) {
                vh.mEdtContent.clearFocus();
            }
        }

        //设置触摸获得焦点
        vh.mEdtTitle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    final boolean focus = news.isTitleFocus();
                    checkTitle(position);
                    if (!focus && !vh.mEdtTitle.isFocused()) {
                        vh.mEdtTitle.requestFocus();
                        vh.mEdtTitle.onWindowFocusChanged(true);
                    }
                }
                return false;
            }
        });

        vh.mEdtContent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    final boolean focus = news.isContentFocus();
                    checkContent(position);
                    if (!focus && !vh.mEdtContent.isFocused()) {
                        vh.mEdtContent.requestFocus();
                        vh.mEdtContent.onWindowFocusChanged(true);
                    }
                }
                return false;
            }
        });

        final TextWatcher watcherTitle = new SimpleTextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    news.setTitle(null);
                } else {
                    news.setTitle(String.valueOf(s));
                }
            }
        };
        vh.mEdtTitle.addTextChangedListener(watcherTitle);
        vh.mEdtTitle.setTag(watcherTitle);

        final TextWatcher watcherContent = new SimpleTextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    news.setContent(null);
                } else {
                    news.setContent(String.valueOf(s));
                }
            }
        };
        vh.mEdtContent.addTextChangedListener(watcherContent);
        vh.mEdtContent.setTag(watcherContent);

        return convertView;
    }

    /**
     * 去除textWatcher
     *
     * @param editText
     */
    private void removeTextWatcher(EditText editText) {
        if (editText.getTag() instanceof TextWatcher) {
            editText.removeTextChangedListener((TextWatcher) editText.getTag());
        }
    }

    private void checkTitle(int position) {
        for (News l : mList) {
            l.setTitleFocus(false);
        }
        mList.get(position).setTitleFocus(true);
    }

    private void checkContent(int position) {
        for (News l : mList) {
            l.setContentFocus(false);
        }
        mList.get(position).setContentFocus(true);
    }

    private class ViewHoder {
        EditText mEdtContent;
        EditText mEdtTitle;
        Button mBtnLog;
    }
}
