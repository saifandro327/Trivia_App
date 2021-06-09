package com.app.triviaapp.controller;

import com.app.triviaapp.model.UserModel;
import com.app.triviaapp.view.IUsernameView;

public class UserNameController implements IUserNameController {
IUsernameView iUsernameView;

    public UserNameController(IUsernameView iUsernameView) {
        this.iUsernameView = iUsernameView;
    }

    @Override
    public void userName(String username) {
        UserModel userModel=new UserModel(username);
        int validcode=userModel.isValid();
        if (validcode==0){
            iUsernameView.onError("Please Enter Valid UserName");
        }
        else {
            iUsernameView.onSuccess("Success");
        }
    }
}
