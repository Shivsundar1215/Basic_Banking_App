package com.example.bankingapp.ListAdapaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.Data.Customers;
import com.example.bankingapp.R;

import java.util.ArrayList;

public class SendToCustomerAdapter extends RecyclerView.Adapter<SendToCustomerAdapter.ViewHolder> {
    private ArrayList<Customers> customersArrayList;
    private OnUserListener onUserListener;

    public SendToCustomerAdapter(ArrayList<Customers> customersArrayList, OnUserListener onUserListener) {
        this.customersArrayList = customersArrayList;
        this.onUserListener = onUserListener;
    }

    @NonNull
    @Override
    public SendToCustomerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.customers_list_item, viewGroup, false);
        return new SendToCustomerAdapter.ViewHolder(view, onUserListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SendToCustomerAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(customersArrayList.get(position));
        viewHolder.userName.setText(customersArrayList.get(position).getName());
        viewHolder.userAccountBalance.setText(String.format("%d", customersArrayList.get(position).getBalance()));
    }

    @Override
    public int getItemCount() {
        return customersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView userName, userAccountBalance;
        OnUserListener onUserListener;

        public ViewHolder(@NonNull View itemView, OnUserListener onUserListener) {
            super(itemView);
            userName = itemView.findViewById(R.id.customername);
            userAccountBalance = itemView.findViewById(R.id.amount);
            this.onUserListener = onUserListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserListener.onUserClick(getAdapterPosition());
        }
    }

    public interface OnUserListener {
        void onUserClick(int position);
    }
}
