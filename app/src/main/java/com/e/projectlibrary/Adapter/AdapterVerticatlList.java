package com.e.projectlibrary.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.hrvalidationhelper.HRValidationHelper;
import com.e.projectlibrary.Model.ModelList;
import com.e.projectlibrary.databinding.ListItemBinding;

import java.util.List;

public class AdapterVerticatlList extends RecyclerView.Adapter<AdapterVerticatlList.ViewHolder> {
    private List<ModelList> list;
    private Context context;

    public AdapterVerticatlList(List<ModelList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding = ListItemBinding.inflate(layoutInflater, parent, false);
        HRValidationHelper.setScreenHeightDouble(binding.parent1,context,0.2);
        return new AdapterVerticatlList.ViewHolder(binding);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.address.setText(list.get(position).getAddress());
        holder.binding.name.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;
        public ViewHolder(ListItemBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
