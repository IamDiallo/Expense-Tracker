package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.expensetracker.TabFragments.List;

public class ViewExpense extends AppCompatActivity {
    private Expense expense;
    public static String TAG = "ViewExpense";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expense);

        expense =  (Expense)  getIntent().getSerializableExtra(List.EXPENSE_EXTRA);
        TextView date = findViewById(R.id.date);
        date.setText(expense.getDate());
        TextView time = findViewById(R.id.time);
        time.setText(expense.getTime());
        TextView type = findViewById(R.id.type);
        type.setText(expense.getType());
        TextView montant = findViewById(R.id.montant);
        montant.setText(String.valueOf(expense.getMontant()));

    }
}