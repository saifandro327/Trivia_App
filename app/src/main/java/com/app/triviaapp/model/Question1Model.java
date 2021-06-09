package com.app.triviaapp.model;

import android.widget.RadioButton;

public class Question1Model implements Question1Interface {
    private RadioButton radioButton;

    public Question1Model(RadioButton radioButton) {
        this.radioButton = radioButton;
    }

    @Override
    public RadioButton getradioButton() {
return radioButton;
    }

    @Override
    public int isValid() {
if (radioButton.isChecked()){
            return -1;
        }
        else {
            return 0;
        }


    }
}
