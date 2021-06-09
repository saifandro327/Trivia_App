package com.app.triviaapp.controller;

import android.widget.CheckBox;

import com.app.triviaapp.model.Question2Model;
import com.app.triviaapp.view.IQuestion2View;

public class Question2Controller implements IQuestion2Controller {
    IQuestion2View iQuestion2View;

    public Question2Controller(IQuestion2View iQuestion2View) {
        this.iQuestion2View = iQuestion2View;
    }



    @Override
    public void checkbox(CheckBox checkBox) {
        Question2Model question2Model = new Question2Model(checkBox);
        int validcode = question2Model.isValid();
        if (validcode == 0) {
            iQuestion2View.onError("Please select Multiple Options");

        } else {
            iQuestion2View.onSuccess("Answer Selected");
        }


    }
}

