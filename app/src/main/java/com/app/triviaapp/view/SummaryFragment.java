package com.app.triviaapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.triviaapp.MainActivity;
import com.app.triviaapp.R;
import com.app.triviaapp.db.DatabaseHelper;

import java.util.Date;


public class SummaryFragment extends Fragment {


    public SummaryFragment() {
        // Required empty public constructor
    }
    private DatabaseHelper dbHandler;

    public static final String MY_SHARED_PREFERENCES = "MySharedPrefs";

    String stringGetName, stringAnswer1;
    TextView textViewSummarytName, textViewSummaryAnswer1, textViewSummaryAnswer2;
Button buttonFinish;

    String currentDateTimeString;    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        dbHandler = new DatabaseHelper(getContext());

        textViewSummarytName = (TextView) view.findViewById(R.id.summary_name_textview);
        textViewSummaryAnswer1 = (TextView) view.findViewById(R.id.summary_answer1_textview);
        textViewSummaryAnswer2 = (TextView) view.findViewById(R.id.summary_answer2_textview);
buttonFinish=(Button)view.findViewById(R.id.fiinsh);





        stringGetName = ((MainActivity) getActivity()).getUsernamet();

        textViewSummarytName.setText(stringGetName);
        SharedPreferences pref = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        String id = pref.getString("facebook_id", "empty");
        Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
        textViewSummaryAnswer1.setText(id);

        SharedPreferences prefflag = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        String idflag = prefflag.getString("flags", "empty");
        textViewSummaryAnswer2.setText(idflag);


        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
                String name = textViewSummarytName.getText().toString();
                String tvAns1 = textViewSummaryAnswer1.getText().toString();
                String tvAns2 = textViewSummaryAnswer2.getText().toString();

                // validating if the text fields are empty or not.
//                if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
//                    Toast.makeText(getContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                dbHandler.addNewGame(currentDateTimeString, name, tvAns1, tvAns2);

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.

                // after adding the data we are displaying a toast message.
                Toast.makeText(getActivity(), "Saeved", Toast.LENGTH_SHORT).show();
                ;
               pref.edit().clear().apply();
               prefflag.edit().clear().apply();

               MainActivity.viewPager.setCurrentItem(0);


            }
        });

        return view;
    }


}