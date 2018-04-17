package com.tallerdosclases.tallerdosclase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class ListPhones extends AppCompatActivity {
    private TableLayout table;
    private ArrayList<Phone> phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_phones);

        table = findViewById(R.id.table);
        phones = Data.getPhones();

        for (int i = 0; i < phones.size(); i++) {
            TableRow row = new TableRow(this);

            TextView phoneID = new TextView(this);
            TextView brand = new TextView(this);
            TextView color = new TextView(this);
            TextView price = new TextView(this);

            phoneID.setText(""+(i + 1));
            brand.setText(phones.get(i).getBrand());
            color.setText(phones.get(i).getColor());

            String formattedPrice = "$" + NumberFormat.getNumberInstance().format(phones.get(i).getPrice());
            price.setText(formattedPrice);

            row.addView(phoneID);
            row.addView(brand);
            row.addView(color);
            row.addView(price);

            table.addView(row);
        }
    }
}
