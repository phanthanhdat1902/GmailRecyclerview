package com.example.gmailrecyclerview.Adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gmailrecyclerview.MainActivity;
import com.example.gmailrecyclerview.Models.gmail_item;
import com.example.gmailrecyclerview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<gmail_item> listItems;
    List<gmail_item> displayItem;
    String keyword;
    boolean FavoriteLayout;
    public ItemAdapter(List<gmail_item> listItems) {
        this.listItems = listItems;
        displayItem =new ArrayList<gmail_item>();
        displayItem.addAll(listItems);
        keyword="";
        FavoriteLayout=false;
    }
    public void showAllItem(){
        keyword="";
        displayItem.clear();
        displayItem.addAll(listItems);
        notifyDataSetChanged();
        FavoriteLayout=false;
    }
    public void displaySearch(String keyword){
        this.keyword=keyword;
        displayItem.clear();
        for (gmail_item item:listItems) {
            if(item.getUsername().contains(keyword)||item.getTitle().contains(keyword)||item.getContent().contains(keyword)){
                displayItem.add(item);
            }
        }
        FavoriteLayout=false;
        notifyDataSetChanged();
    }
    public void displayFavorite(){
        this.keyword="";
        displayItem.clear();
        for (gmail_item item:listItems) {
            if(item.isFavorite()){
                displayItem.add(item);
            }
        }
        FavoriteLayout=true;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*Tao so Holder du kich thuoc man hinh,chon kieu layout phu hop*/
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        /*Ket hop giua Model va Layout, holder la layout*/
        final gmail_item item=displayItem.get(position);
        ViewHolder viewHolder=(ViewHolder) holder;
        if(keyword.length()>2){
            String name=item.getUsername().replace(keyword,"<b>"+keyword+"</b>");
            String title=item.getTitle().replace(keyword,"<b>"+keyword+"</b>");
            String content=item.getContent().replace(keyword,"<b>"+keyword+"</b>");
            viewHolder.content.setText(Html.fromHtml(content));
            viewHolder.title.setText(Html.fromHtml(title));
            viewHolder.userName.setText(Html.fromHtml(name));
        }else{
            viewHolder.content.setText(item.getContent());
            viewHolder.title.setText(item.getTitle());
            viewHolder.userName.setText(item.getUsername());
        }
        viewHolder.textAvt.setText(item.getUsername().substring(0,1));
        viewHolder.textAvt.getBackground().setColorFilter(new PorterDuffColorFilter(item.getColorAvt(),PorterDuff.Mode.SRC_ATOP));
        if(item.isFavorite()){
            viewHolder.isFavorite.setImageResource(R.drawable.ic_favorite_true);
        }else{
            viewHolder.isFavorite.setImageResource(R.drawable.ic_favorite_false);
        }
        viewHolder.isFavorite.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean isFavorite=item.isFavorite();
                item.setFavorite(!isFavorite);
                if(FavoriteLayout==true){
                    displayItem.remove(item);
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return displayItem.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        /*Tao holder +Adapter+Models,xay dung Hodel gom cac thanh phan trong layout*/
        TextView textAvt ;
        TextView userName;
        TextView title;
        TextView content;
        TextView time;
        ImageView isFavorite;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textAvt=itemView.findViewById(R.id.avt);
            userName=itemView.findViewById(R.id.user_name);
            title=itemView.findViewById(R.id.title_mail);
            content=itemView.findViewById(R.id.content_mail);
            time=itemView.findViewById(R.id.time_mail);
            isFavorite=itemView.findViewById(R.id.icon_favorite);
        }
    }
}

