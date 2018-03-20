package com.bottomsheet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * ********************************
 * Created by lichenglan
 * Date: 2018/1/11 11:26.
 * ********************************
 */

public class BottomSheetAdapter extends RecyclerView.Adapter {

    private OnBottomItemClickListener bottomItemClickListener;

    private Context context;
    private List<String> mData;

    public BottomSheetAdapter( Context context, List<String> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;


        view = LayoutInflater.from(context).inflate(R.layout.my_sheet_layout, parent, false);
        return new CurtainViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        CurtainViewHolder viewHolder = (CurtainViewHolder) holder;
        viewHolder.image.setImageResource(R.mipmap.ic_launcher);
        viewHolder.text.setText(mData.get(position));

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    class CurtainViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;

        public CurtainViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }


    public void setOnItemClickListener(OnBottomItemClickListener bottomItemClickListener) {
        this.bottomItemClickListener = bottomItemClickListener;
    }

    public interface OnBottomItemClickListener {
        void onItemClick(int position, String text);
    }
}


