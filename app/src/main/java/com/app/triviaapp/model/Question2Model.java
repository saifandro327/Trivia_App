package com.app.triviaapp.model;

import android.widget.CheckBox;

public class Question2Model implements Question2Interface {
    private CheckBox checkBox;

    public Question2Model(CheckBox checkBox) {
        this.checkBox = checkBox;
    }


    @Override
    public CheckBox getCheckbox() {
        return checkBox;
    }

    @Override
    public int isValid() {
        if (checkBox.isChecked()){
            return -1;
        }
        else {
            return 0;
        }


    }
}