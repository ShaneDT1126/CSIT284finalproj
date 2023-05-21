package com.example.prjfinalproj;

import androidx.cardview.widget.CardView;

import com.example.prjfinalproj.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);

}
