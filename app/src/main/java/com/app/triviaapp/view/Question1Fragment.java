package com.app.triviaapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.triviaapp.MainActivity;
import com.app.triviaapp.R;
import com.app.triviaapp.controller.IQuestion1Controller;
import com.app.triviaapp.controller.Question1Controller;


public class Question1Fragment extends Fragment implements IQuestion1View {


    public Question1Fragment() {

    }

    IQuestion1Controller iQuestion1Controller;
    RadioGroup radioGroup;
    Button buttonQ1;
    RadioButton radioButtonQ1;
    RadioButton radioButtonQ2;
    RadioButton radioButtonQ3;
    RadioButton radioButtonQ4;
    String answer1;
    TextView textViewtv;
    TextView textViewQuestion1;

    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question1_fragments, container, false);
        radioGroup = (RadioGroup) view.findViewById(R.id.answer_radiogroup);
        textViewtv=(TextView)view.findViewById(R.id.tv);
        textViewQuestion1=(TextView)view.findViewById(R.id.question1_textview) ;


        buttonQ1 = (Button) view.findViewById(R.id.q1_next_button);
        iQuestion1Controller = new Question1Controller(this);
        buttonQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButtonQ1 = (RadioButton) view.findViewById(R.id.option1);
                radioButtonQ2 = (RadioButton) view.findViewById(R.id.option2);
                radioButtonQ3 = (RadioButton) view.findViewById(R.id.option3);
                radioButtonQ4 = (RadioButton) view.findViewById(R.id.option4);



                if (radioButtonQ1.isChecked()) {
                    iQuestion1Controller.radiobutton(radioButtonQ1);

                }
                if (radioButtonQ2.isChecked()) {
                    iQuestion1Controller.radiobutton(radioButtonQ2);

                }
                if (radioButtonQ3.isChecked()) {
                    iQuestion1Controller.radiobutton(radioButtonQ3);

                }
                if (radioButtonQ4.isChecked()) {
                    iQuestion1Controller.radiobutton(radioButtonQ4);

                }


                answer1 =((RadioButton)view.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
//                ((MainActivity) requireActivity()).setAnswer1(answer1);
                //Getting answer from  Question1
                Toast.makeText(getActivity(), answer1+"", Toast.LENGTH_SHORT).show();
                SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = pref.edit();
                edt.putString("players", answer1);
                edt.apply();


            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        SharedPreferences preferences = context.getSharedPreferences("pref", 0);

    }
    @Override
    public void onSuccess(String successmessage) {
        Toast.makeText(getActivity(), successmessage, Toast.LENGTH_SHORT).show();
        MainActivity.viewPager.setCurrentItem(2);
    }

    @Override
    public void onError(String errormesssage) {
        Toast.makeText(getActivity(), errormesssage, Toast.LENGTH_SHORT).show();

    }
}