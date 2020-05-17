package com.socialcodia.studentmanagementsystem.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.socialcodia.studentmanagementsystem.R;
import com.socialcodia.studentmanagementsystem.model.ModelUser;
import com.socialcodia.studentmanagementsystem.storage.SharedPrefManager;

public class SettingsFragment extends Fragment {

    private EditText inputName, inputEmail;
    private Button btnUpdate;
    SharedPreferences sharedPreferences;
    SharedPrefManager sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View SocialCodia = inflater.inflate(R.layout.fragment_settings, container, false);

        sp = new SharedPrefManager(getContext());

        inputEmail = SocialCodia.findViewById(R.id.inputEmail);
        inputName = SocialCodia.findViewById(R.id.inputName);
        btnUpdate = SocialCodia.findViewById(R.id.btnUpdateProfile);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getUserData();

        return SocialCodia;
    }


    private void getUserData()
    {
        ModelUser user = sp.getUser();
        inputName.setText(user.getName());
        inputEmail.setText(user.getEmail());
    }
}
