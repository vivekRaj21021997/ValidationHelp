package com.e.projectlibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.e.hrvalidationhelper.HRValidationHelper;
import com.e.projectlibrary.Model.ModelList;
import com.e.projectlibrary.R;
import com.e.projectlibrary.databinding.ListItemBinding;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    private List<ModelList> list;
    private Context context;
    LayoutInflater mInflater;

    public AdapterList(List<ModelList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    ListItemBinding binding = ListItemBinding.inflate(layoutInflater, parent, false);
        HRValidationHelper.setScreenWidthDouble(binding.parent1, context, 0.8);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.name.setText(list.get(position).getName());
        holder.binding.address.setText(list.get(position).getAddress());
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
