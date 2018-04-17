package com.tallerdosclases.tallerdosclase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private ListView listView;
    private String [] options;
    private Intent in;
    private AlertDialog alertDialog;
    String reportName, message;
    int blackIphones;
    Double average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listView = findViewById(R.id.lstOptions);
        options = getResources().getStringArray(R.array.home_options);

        alertDialog = new AlertDialog.Builder(Principal.this).create();

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in = new Intent(Principal.this, CreatePhone.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Principal.this, ListPhones.class);
                        startActivity(in);
                        break;
                    case 2:
                        blackIphones = Data.getBlackApplesCount(getResources());
                        reportName = getResources().getString(R.string.report_one);
                        message = getResources().getString(R.string.report_one_message) + ": " + blackIphones;
                        showDialog(reportName, message);

                        break;
                    case 3:
                        average = Data.getNokiaPriceAverage(getResources());
                        reportName = getResources().getString(R.string.report_two);
                        message = getResources().getString(R.string.report_two_message) + ": " + String.format("%.2f", average);
                        showDialog(reportName, message);

                        break;
                }
            }
        });
    }

    public void showDialog(String reportName, String message){
        alertDialog.setTitle(reportName);

        alertDialog.setMessage(message);

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
