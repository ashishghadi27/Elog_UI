package com.example.elogui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.elogui.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

public class Sof extends Fragment {

    private BottomSheetDialog bottom_sheet_dialog;
    private ImageView add;

    public Sof() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sof, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottom_sheet_dialog = new BottomSheetDialog(Objects.requireNonNull(getContext()));
        add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSOFDetails();
            }
        });
    }

    private void addSOFDetails(){
        View dialog = View.inflate(getContext(), R.layout.bottomsheet_add_sof, null);
        bottom_sheet_dialog.setContentView(dialog);
        bottom_sheet_dialog.show();
    }
}
