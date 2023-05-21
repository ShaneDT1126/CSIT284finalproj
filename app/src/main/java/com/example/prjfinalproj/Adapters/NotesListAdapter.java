package com.example.prjfinalproj.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prjfinalproj.Models.Notes;
import com.example.prjfinalproj.NotesClickListener;
import com.example.prjfinalproj.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{
    Context context;
    List<Notes> list;
    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.txtViewTitle.setText(list.get(position).getTitle());
        holder.txtViewTitle.setSelected(true);

        holder.txtViewNotes.setText(list.get(position).getNotes());

        holder.txtDate.setText(list.get(position).getDate());
        holder.txtDate.setSelected(true);

        if(list.get(position).isPinned()){
            holder.imageView_pin.setImageResource(R.drawable.pin);
        }else{
            holder.imageView_pin.setImageResource(0);
        }

        int color_code = getRandomColor();
        holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code,null));
        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongClick(list.get(holder.getAdapterPosition()),holder.notes_container);
                return true;
            }
        });
    }

    private int getRandomColor(){
        List<Integer> colorCode = new ArrayList<>();

        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);

        Random random = new Random();
        int random_color = random.nextInt(colorCode.size());

    return colorCode.get(random_color);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
class NotesViewHolder extends RecyclerView.ViewHolder {

    CardView notes_container;
    TextView txtViewTitle,txtViewNotes,txtDate;
    ImageView imageView_pin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        notes_container = itemView.findViewById(R.id.notes_container);
        txtViewTitle = itemView.findViewById(R.id.txtViewTitle);
        txtViewNotes = itemView.findViewById(R.id.txtViewNotes);
        txtDate = itemView.findViewById(R.id.txtDate);
        imageView_pin = itemView.findViewById(R.id.imageView_pin);
    }
}