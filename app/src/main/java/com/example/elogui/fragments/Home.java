package com.example.elogui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.elogui.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

public class Home extends Fragment {

    private BottomSheetDialog bottom_sheet_dialog;
    private View homeLay;
    private ImageView add;

    public Home() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottom_sheet_dialog = new BottomSheetDialog(Objects.requireNonNull(getContext()));
        homeLay = view.findViewById(R.id.homeLay);
        ImageView threeDotMenu = homeLay.findViewById(R.id.three_dot_menu);
        add = view.findViewById(R.id.add);

        threeDotMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePinDialogue();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginSheet();
            }
        });

    }

    private void changePinDialogue(){
        View dialog = View.inflate(getContext(), R.layout.bottomsheet_changepin, null);
        bottom_sheet_dialog.setContentView(dialog);

        RelativeLayout change = dialog.findViewById(R.id.changePin);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinView();
                bottom_sheet_dialog.dismiss();

            }
        });
        bottom_sheet_dialog.show();

    }

    private void pinView(){
        BottomSheetDialog bottom_sheet_dialog_new = new BottomSheetDialog(Objects.requireNonNull(getContext()));
        View dialog = View.inflate(getContext(), R.layout.bottomsheet_pin_view, null);
        bottom_sheet_dialog_new.setContentView(dialog);
        bottom_sheet_dialog_new.show();
    }

    private void loginSheet(){
        View dialog = View.inflate(getContext(), R.layout.bottomsheet_login, null);
        bottom_sheet_dialog.setContentView(dialog);
        bottom_sheet_dialog.show();
    }

}
