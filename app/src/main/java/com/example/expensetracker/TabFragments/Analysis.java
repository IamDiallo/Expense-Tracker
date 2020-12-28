package com.example.expensetracker.TabFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensetracker.DatabaseHandler;
import com.example.expensetracker.Expense;
import com.example.expensetracker.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Analysis extends Fragment {


    public TextView balanceNumberView;
    private DatabaseHandler db;

    public Analysis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_analysis, container, false);
        balanceNumberView = v.findViewById(R.id.balanceNumberView);

        db = new DatabaseHandler(getContext());
       // db.clear();
        display();

        return v;
    }


    public void display()   {
        String total= Double.toString(db.getTotal());
        db = new DatabaseHandler(getContext());
        ArrayList<Expense> expenses = db.getAllRows();
        if (expenses.size() > 0) {
            balanceNumberView.setText(String.valueOf(total));
        }
        else {
            makeToast("Your lsit of expenses is empty");
        }
    }

    private void makeToast(String msg)  {
        Toast.makeText(this.getContext(), msg , Toast.LENGTH_LONG).show();
    }

}
