package com.app.triviaapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.triviaapp.MainActivity;
import com.app.triviaapp.R;
import com.app.triviaapp.controller.IUserNameController;
import com.app.triviaapp.controller.UserNameController;


public class NameFragment extends Fragment implements IUsernameView {


    public NameFragment() {
        // Required empty public constructor
    }



Button buttonNext;
EditText editTextUserName;
IUserNameController iUserNameController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_name, container, false);
   editTextUserName=(EditText)view.findViewById(R.id.name_edittext);
   buttonNext=(Button)view.findViewById(R.id.nextbutton);
iUserNameController=new UserNameController(this);
buttonNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        iUserNameController.userName(editTextUserName.getText().toString().trim());
        String stringName=editTextUserName.getText().toString();
        ((MainActivity) getActivity()).setUsername(stringName);

    }
});
    return view;
    }

    @Override
    public void onSuccess(String successmessage) {
        Toast.makeText(getActivity(), successmessage, Toast.LENGTH_SHORT).show();
        MainActivity.viewPager.setCurrentItem(1);
    }

    @Override
    public void onError(String errormesssage) {
        Toast.makeText(getActivity(), errormesssage, Toast.LENGTH_SHORT).show();

    }
}