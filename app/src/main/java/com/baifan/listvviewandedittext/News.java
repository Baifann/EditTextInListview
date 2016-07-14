package com.baifan.listvviewandedittext;

import java.io.Serializable;

/**
 * Created by baifan on 16/6/1.
 */
public class News implements Serializable {
    private String title;

    private String content;

    private String spinnerContent;

    private String edtSpiContent;

    private int num;

    private boolean titleFocus;

    private boolean contentFocus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isTitleFocus() {
        return titleFocus;
    }

    public void setTitleFocus(boolean titleFocus) {
        this.titleFocus = titleFocus;
    }

    public boolean isContentFocus() {
        return contentFocus;
    }

    public void setContentFocus(boolean contentFocus) {
        this.contentFocus = contentFocus;
    }

    public String getSpinnerContent() {
        return spinnerContent;
    }

    public void setSpinnerContent(String spinnerContent) {
        this.spinnerContent = spinnerContent;
    }

    public String getEdtSpiContent() {
        return edtSpiContent;
    }

    public void setEdtSpiContent(String edtSpiContent) {
        this.edtSpiContent = edtSpiContent;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", spinnerContent='" + spinnerContent + '\'' +
                ", edtSpiContent='" + edtSpiContent + '\'' +
                ", num=" + num +
                ", titleFocus=" + titleFocus +
                ", contentFocus=" + contentFocus +
                '}';
    }
}
