package com.example.prjfinalproj.GoalSetting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.prjfinalproj.GoalSetting.GoalSettingModel;
import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Utils.DatabaseHandler;

import java.util.List;


public class GoalSettingAdapter extends RecyclerView.Adapter<GoalSettingAdapter.ViewHolder> {

    private List<GoalSettingModel> GoalList;
    private Goals goals;
    private DatabaseHandler2 db2;

    public GoalSettingAdapter(DatabaseHandler2 db2, Goals goals){
        this.db2 = db2;
        this.goals = goals;
    }

    public void setGoals(List<GoalSettingModel> GoalList){
        this.GoalList = GoalList;
        notifyDataSetChanged();
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goal_layout, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int pos){
        db2.openDatabase();
        final GoalSettingModel item = GoalList.get(pos);
        holder.goals.setText(item.getGoal());
        holder.goals.setChecked(toBoolean(item.getStatus()));
        holder.goals.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    db2.updateStatus(item.getId(), 1);
                }else {
                    db2.updateStatus(item.getId(), 0);
                }
            }
        });
    }

    public int getItemCount(){
        return GoalList.size();
    }
    private boolean toBoolean(int n){
        return n!=0;
    }

    public void deleteItem(int position){
        GoalSettingModel item = GoalList.get(position);
        db2.deleteGoal(item.getId());
        GoalList.remove(position);
        notifyItemRemoved(position);
    }
    public void editItem(int position){
        GoalSettingModel item = GoalList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("goal", item.getGoal());
        AddNewGoal fragment = new AddNewGoal();
        fragment.setArguments(bundle);
        fragment.show(goals.getSupportFragmentManager(), AddNewGoal.TAG);
    }

    public Context getContext() {
        return goals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox goals;

        ViewHolder(View view){
            super(view);
            goals = view.findViewById(R.id.todoCheck2);
        }
    }
}
