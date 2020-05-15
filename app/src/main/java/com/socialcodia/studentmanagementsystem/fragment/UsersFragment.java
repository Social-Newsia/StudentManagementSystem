package com.socialcodia.studentmanagementsystem.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.socialcodia.studentmanagementsystem.R;
import com.socialcodia.studentmanagementsystem.adapter.AdapterUser;
import com.socialcodia.studentmanagementsystem.api.RetrofitClient;
import com.socialcodia.studentmanagementsystem.model.ModelUser;
import com.socialcodia.studentmanagementsystem.model.UsersResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersFragment extends Fragment {

    private RecyclerView recyclerView;
    List<ModelUser> modelUserList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View SocialCodia = inflater.inflate(R.layout.fragment_users, container, false);

        recyclerView = SocialCodia.findViewById(R.id.usersRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        modelUserList = new ArrayList<>();
        Call<UsersResponse> call = RetrofitClient.getInstance().getApi().getUser();
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                Toast.makeText(getContext(), "responsssssssssssssssssssssss", Toast.LENGTH_SHORT).show();
                modelUserList = response.body().getUser();
                Toast.makeText(getContext(), "model user list "+modelUserList, Toast.LENGTH_SHORT).show();
                AdapterUser adapterUser = new AdapterUser(getContext(),modelUserList);
                recyclerView.setAdapter(adapterUser);

            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return SocialCodia;
    }


}
