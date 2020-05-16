package com.socialcodia.studentmanagementsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.socialcodia.studentmanagementsystem.R;
import com.socialcodia.studentmanagementsystem.model.ModelUser;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {

    private Context context;
    private List<ModelUser> modelUserList;

    public AdapterUser(Context context, List<ModelUser> modelUserList) {
        this.context = context;
        this.modelUserList = modelUserList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        ModelUser user = modelUserList.get(position);
//        holder.tvUserName.setText(user.getName());
//        holder.tvUserEmail.setText(user.getEmail());

        holder.tvUserName.setText(modelUserList.get(position).getName());
        holder.tvUserEmail.setText(modelUserList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
//        return modelUserList.size();
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUserName, tvUserEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);

        }
    }
}
