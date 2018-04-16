package com.example.yui06.flushcardplus;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CardAdapter extends ArrayAdapter<card>{
    List<card> mCards;

    public CardAdapter(Context context,int layoutResourceId,List<card> objects){
        super(context,layoutResourceId,objects);

        mCards=objects;
    }

    @Override
    public int getCount(){
        return  mCards.size();
    }

    @Override
    public card getItem(int position){
        return  mCards.get(position);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.card, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(convertView);
        }else {
            viewHolder =(ViewHolder)convertView.getTag();
        }
        final  card item=getItem(position);

        if (item!=null){
            viewHolder.iconImageView.setBackgroundResource(item.imageId);
            viewHolder.titleTextView.setText(item.title);
            viewHolder.contentTextView.setText(item.content);
            viewHolder.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.likeNum++;
                    viewHolder.likeTextView.setText(item.likeNum+"Likes");

                }
            });
            viewHolder.iconImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),item.meaning,Toast.LENGTH_SHORT).show();
                }
            });
        }


        return convertView;

    }

    public static class ViewHolder{
        ImageView iconImageView;
        TextView titleTextView;
        TextView likeTextView;
        TextView contentTextView;
        ImageView likeButton;

        public ViewHolder(View view){

            iconImageView=(ImageView)view.findViewById(R.id.icon);
            titleTextView=(TextView)view.findViewById(R.id.title_textview);
            likeTextView=(TextView)view.findViewById(R.id.like_textview);
            contentTextView=(TextView)view.findViewById(R.id.content);
            likeButton=(ImageView)view.findViewById(R.id.like_button);
        }

    }

}
