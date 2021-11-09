package com.example.bankingapp.ListAdapaters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;
import com.example.bankingapp.Data.Customers;
import com.example.bankingapp.CustomerData;

import java.util.ArrayList;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {

    private ArrayList<Customers> customersArrayList;

    public CustomerListAdapter(Context context, ArrayList<Customers> list) {
        customersArrayList = list;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userAccountBalance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.customername);
            userAccountBalance = itemView.findViewById(R.id.amount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // still to be implemented
                }
            });
        }
    }

    @NonNull
    @Override
    public CustomerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.customers_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(customersArrayList.get(position));
        viewHolder.userName.setText(customersArrayList.get(position).getName());
        viewHolder.userAccountBalance.setText(String.format("%d", customersArrayList.get(position).getBalance()));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CustomerData.class);
                intent.putExtra("ACCOUNT_NO", customersArrayList.get(position).getAccountNumber());
                intent.putExtra("NAME", customersArrayList.get(position).getName());
                intent.putExtra("EMAIL", customersArrayList.get(position).getEmail());
                intent.putExtra("IFSC_CODE", customersArrayList.get(position).getIfscCode());
                intent.putExtra("PHONE_NO", customersArrayList.get(position).getPhoneNumber());
                intent.putExtra("BALANCE", String.valueOf(customersArrayList.get(position).getBalance()));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customersArrayList.size();
    }
}
