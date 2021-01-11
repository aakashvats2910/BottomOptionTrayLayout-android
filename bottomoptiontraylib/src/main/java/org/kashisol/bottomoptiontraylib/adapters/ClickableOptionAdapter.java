package org.kashisol.bottomoptiontraylib.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import org.kashisol.bottomoptiontraylib.R;
import org.kashisol.bottomoptiontraylib.ShowOptions;
import org.kashisol.bottomoptiontraylib.util.TrayOptionsList;

import java.util.ArrayList;

public class ClickableOptionAdapter extends RecyclerView.Adapter<ClickableOptionAdapter.ClickableOptionViewHolder> {

    private ArrayList<TrayOptionsList.Option> arrayList;
    private Context context;
    private TrayOptionWatcher trayOptionWatcher;

    public ClickableOptionAdapter(Context context, ArrayList<TrayOptionsList.Option> list, TrayOptionWatcher trayOptionWatcher) {
        arrayList = list;
        this.context = context;
        this.trayOptionWatcher = trayOptionWatcher;
    }

    @NonNull
    @Override
    public ClickableOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_option_layout, parent,false);
        return new ClickableOptionViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ClickableOptionViewHolder holder, int position) {
        TrayOptionsList.Option option = arrayList.get(position);
        holder.clickable_option_button.setText(option.optionText);
        if (option.optionDrawable != null)
            holder.option_icon.setImageDrawable(option.optionDrawable);
        if (option.optionDrawableId != -1)
            holder.option_icon.setImageDrawable(
                    ContextCompat.getDrawable(context, option.optionDrawableId));
        else
            // TODO set a predefined image or throw exception
        ;

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ClickableOptionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button clickable_option_button;
        private ImageView option_icon;

        public ClickableOptionViewHolder(@NonNull View itemView) {
            super(itemView);

            clickable_option_button = itemView.findViewById(R.id.clickable_option_button);
            option_icon = itemView.findViewById(R.id.option_icon);

            if (ShowOptions.getCurrentDrawable() != null)
                clickable_option_button.setBackground(ShowOptions.getCurrentDrawable());

            clickable_option_button.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TrayOptionsList.Option option = arrayList.get(getAdapterPosition());
            trayOptionWatcher.onTrayOptionSelectedListener(option.optionId, option.optionText, option);
        }
    }

    public interface TrayOptionWatcher {
        void onTrayOptionSelectedListener(int optionId, String optionText, TrayOptionsList.Option option);
    }
}
