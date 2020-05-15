package com.socialcodia.studentmanagementsystem.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.socialcodia.studentmanagementsystem.model.ModelUser;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "SocialCodia";

    private static SharedPrefManager mInstance;
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefManager(Context context)
    {
        this.context = context;
    }

    public  static synchronized SharedPrefManager getInstance(Context context)
    {
        if (mInstance==null)
        {
            mInstance = new SharedPrefManager(context);
        }
        return  mInstance;
    }


    public void saveUser(ModelUser modelUser)
    {
        sharedPreferences =  context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.USER_ID, modelUser.getId());
        editor.putString(Constants.USER_NAME, modelUser.getName());
        editor.putString(Constants.USER_EMAIL, modelUser.getEmail());
        editor.apply();
        editor.commit();
    }

    public ModelUser getUser()
    {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new ModelUser(
                sharedPreferences.getInt(Constants.USER_ID,-1),
                sharedPreferences.getString(Constants.USER_NAME,null),
                sharedPreferences.getString(Constants.USER_EMAIL,null)
        );
    }

    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if (sharedPreferences.getInt(Constants.USER_ID,-1)!=-1)
        {
            return true;
        }
        return false;
    }

    public void doLogout()
    {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
