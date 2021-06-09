package com.app.triviaapp.controller;

import android.widget.RadioButton;

import com.app.triviaapp.model.Question1Model;
import com.app.triviaapp.view.IQuestion1View;

public class Question1Controller implements IQuestion1Controller {
    IQuestion1View iQuestion1View;

    public Question1Controller(IQuestion1View iQuestion1View) {
        this.iQuestion1View = iQuestion1View;
    }

    @Override
    public void radiobutton(RadioButton radioButton) {
        Question1Model question1Model = new Question1Model(radioButton);
        int validcode = question1Model.isValid();
        if (validcode == 0) {
            iQuestion1View.onError("Please Select Atleast One Option");

        } else {
            iQuestion1View.onSuccess("Answer Selected");
        }
    }
}
