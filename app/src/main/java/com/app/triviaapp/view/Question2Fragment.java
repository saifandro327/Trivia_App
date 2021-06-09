package com.app.triviaapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.triviaapp.MainActivity;
import com.app.triviaapp.R;
import com.app.triviaapp.controller.IQuestion2Controller;
import com.app.triviaapp.controller.Question2Controller;


public class Question2Fragment extends Fragment implements IQuestion2View {

    public Question2Fragment() {
        // Required empty public constructor
    }
    IQuestion2Controller  iQuestion2Controller;
Button buttonQ2;
CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
TextView textView;

String answer2=" ";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question2, container, false);
  iQuestion2Controller=new Question2Controller(this);
  buttonQ2=(Button)view.findViewById(R.id.q2_next_btn);
  buttonQ2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          checkBox1 = (CheckBox) view.findViewById(R.id.checkbox1);
          checkBox2 = (CheckBox) view.findViewById(R.id.checkbox2);
          checkBox3 = (CheckBox) view.findViewById(R.id.checkbox3);
          checkBox4 = (CheckBox) view.findViewById(R.id.checkbox4);






          if (checkBox1.isChecked()) {
              answer2+=checkBox1.getText().toString();

              iQuestion2Controller.checkbox(checkBox1);
          }

          if (checkBox2.isChecked()) {
              answer2+=checkBox2.getText().toString();
              iQuestion2Controller.checkbox(checkBox2);

          }
          if (checkBox3.isChecked()) {
              answer2+=checkBox3.getText().toString();

              iQuestion2Controller.checkbox(checkBox3);

          }
          if (checkBox4.isChecked()) {
              answer2+=checkBox4.getText().toString();

              iQuestion2Controller.checkbox(checkBox4);

          }
//          String string=checkBox1.getText().toString().concat(checkBox2.getText().toString().concat(checkBox3.getText().toString()));

          //Getting answer from  Question2

          SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
          SharedPreferences.Editor edt = pref.edit();
          edt.putString("flags", answer2);
          edt.commit();
          Toast.makeText(getContext(), answer2+"", Toast.LENGTH_SHORT).show();
      }
  });
        return view;
    }


    @Override
    public void onSuccess(String successmessage) {
        Toast.makeText(getActivity(), successmessage, Toast.LENGTH_SHORT).show();
        MainActivity.viewPager.setCurrentItem(3);
    }

    @Override
    public void onError(String errormesssage) {
        Toast.makeText(getActivity(), errormesssage, Toast.LENGTH_SHORT).show();

    }
}