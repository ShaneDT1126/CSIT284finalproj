package com.example.prjfinalproj.GoalSetting;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.core.content.ContextCompat;

import com.example.prjfinalproj.GoalSetting.GoalSettingModel;
import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Utils.DatabaseHandler;
import com.example.prjfinalproj.Utils.DialogCloseListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

public class AddNewGoal extends BottomSheetDialogFragment {

    public static final String TAG = "ActionBottomDialog";

    private EditText newGoalText;
    private Button newGoalSaveButton;
    private DatabaseHandler2 db;

    public static AddNewGoal newInstance(){

        return new AddNewGoal();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);
    }
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.new_goal, container, false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newGoalText = requireView().findViewById(R.id.newGoalText);
        newGoalSaveButton = getView().findViewById(R.id.newGoalSaveButton);
        boolean isUpdate = false;
        final Bundle bundle = getArguments();
        if(bundle != null){
            isUpdate = true;
            String Goal = bundle.getString("Goal");
            newGoalText.setText(Goal);
            assert Goal != null;
            if(Goal.length()>0)
                newGoalSaveButton.setTextColor(ContextCompat.getColor(requireContext(), com.google.android.material.R.color.design_default_color_primary_dark));
        }
        db = new DatabaseHandler2(getActivity());
        db.openDatabase();
        newGoalText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    newGoalSaveButton.setEnabled(false);
                    newGoalSaveButton.setTextColor(Color.GRAY);
                }
                else{
                    newGoalSaveButton.setEnabled(true);
                    newGoalSaveButton.setTextColor(ContextCompat.getColor(requireContext(), com.google.android.material.R.color.design_default_color_primary_dark));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        final boolean finalIsUpdate = isUpdate;
        newGoalSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = newGoalText.getText().toString();
                if(finalIsUpdate){
                    db.updateGoal(bundle.getInt("id"), text);
                }
                else {
                    GoalSettingModel Goal = new GoalSettingModel();
                    Goal.setGoal(text);
                    Goal.setStatus(0);
                    db.insertGoal(Goal);
                }
                dismiss();
            }
        });
    }
    @Override
    public void onDismiss(@NonNull DialogInterface dialog){
        Activity activity = getActivity();
        if(activity instanceof DialogCloseListener)
            ((DialogCloseListener)activity).handleDialogClose(dialog);
    }
}

