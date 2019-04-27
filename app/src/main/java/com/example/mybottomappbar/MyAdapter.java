package com.example.mybottomappbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> mDataList;
    private LayoutInflater inflater;
    private Context context;
    private CoordinatorLayout coordinatorLayout;
    private String text;

    public MyAdapter(ArrayList<String> data, Context context, CoordinatorLayout coordinatorLayout) {
        this.mDataList = data;
        this.context = context;
        this.coordinatorLayout = coordinatorLayout;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_tasarim, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        String ulke = mDataList.get(position);
        holder.satirYazi.setText(ulke);

        holder.satirCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(coordinatorLayout, holder.satirYazi.getText().toString(), Snackbar.LENGTH_SHORT).show();
                MainActivity.showSnackbar(holder.satirYazi.getText().toString());
            }
        });

        holder.satirResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(context, holder.satirResim);
                popupMenu.getMenuInflater().inflate(R.menu.card_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_delete:
                                //Snackbar.make(coordinatorLayout, "You deleted " + holder.satirYazi.getText().toString(), Snackbar.LENGTH_SHORT).show();
                                text = "You deleted " + holder.satirYazi.getText().toString();
                                MainActivity.showSnackbar(text);
                                return true;
                            case R.id.action_edit:
                                Snackbar.make(coordinatorLayout, "You edited " + holder.satirYazi.getText().toString(), Snackbar.LENGTH_SHORT).show();
                                text = "You edited " + holder.satirYazi.getText().toString();
                                MainActivity.showSnackbar(text);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView satirCard;
        private TextView satirYazi;
        private ImageView satirResim;

        public MyViewHolder(@NonNull View view) {
            super(view);

            satirCard = itemView.findViewById(R.id.satirCard);
            satirYazi = itemView.findViewById(R.id.satirYazi);
            satirResim = itemView.findViewById(R.id.satirResim);
        }
    }
}
