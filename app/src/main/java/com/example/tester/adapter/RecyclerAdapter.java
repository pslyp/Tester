package com.example.tester.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tester.R;
import com.example.tester.models.User;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUserList;

    private OnItemClickListener mListener;

    private OnFavoriteCheckedChangedListener mFavoriteListener;

    public interface OnItemClickListener {
        void onItemClick(User item);
    }

    public interface OnFavoriteCheckedChangedListener {
        void onFavoriteCheckedChanged(boolean isChecked, User item);
    }

    public RecyclerAdapter(Context mContext, List<User> mUserList) {
        this.mContext = mContext;
        this.mUserList = mUserList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = mUserList.get(position);

        holder.nameText.setText(user.getName());

        holder.bind(user, mListener, mFavoriteListener);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public void setOnFavoriteCheckedChangedListener(OnFavoriteCheckedChangedListener listener) {
        this.mFavoriteListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameText;
        public ToggleButton favoriteToggle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.name_text_view);
            favoriteToggle = itemView.findViewById(R.id.favorite_toggle);
        }

        public void bind(final User item, final OnItemClickListener listener, final OnFavoriteCheckedChangedListener fListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });

            favoriteToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        favoriteToggle.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                    } else {
                        favoriteToggle.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
                    }

                    fListener.onFavoriteCheckedChanged(isChecked, item);
                }
            });
        }

    }

}
