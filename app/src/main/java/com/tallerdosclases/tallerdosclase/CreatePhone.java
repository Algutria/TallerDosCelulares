package com.tallerdosclases.tallerdosclase;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreatePhone extends AppCompatActivity {

    private Spinner brandSpinner, colorSpinner;
    private Resources resources;
    private String brands[], colors[];
    private EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_phone);
        resources = this.getResources();
        price = findViewById(R.id.phonePrice);

        brandSpinner = findViewById(R.id.brandSpinner);
        colorSpinner = findViewById(R.id.colorSpinner);

        brands = resources.getStringArray(R.array.brands_list);
        colors = resources.getStringArray(R.array.colors_list);

        ArrayAdapter<String> brandsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brands);
        brandSpinner.setAdapter(brandsAdapter);

        ArrayAdapter<String> colorsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, colors);
        colorSpinner.setAdapter(colorsAdapter);
    }


    public void savePhone(View v){
        if(isAValidPrice(price)){
            int selectedBrand, selectedColor;

            selectedBrand = brandSpinner.getSelectedItemPosition();
            selectedColor = colorSpinner.getSelectedItemPosition();

            String brandValue = brands[selectedBrand];
            String colorValue = colors[selectedColor];
            double phonePrice = Double.parseDouble(price.getText().toString());

            Phone phone = new Phone(brandValue, colorValue, phonePrice);
            phone.save();

            Toast.makeText(this, resources.getString(R.string.phone_saved),
                    Toast.LENGTH_SHORT).show();

            delete(v);
        }
    }

    public boolean isAValidPrice(EditText input) {
        if (input.getText().toString().trim().isEmpty()) {
            input.requestFocus();
            input.setError(getResources().getString(R.string.blank_quantity));
            return false;
        }

        if (input.getText().toString().trim().equals(".")) {
            input.requestFocus();
            input.setError(getString(R.string.invalid_value));
            return false;
        }

        if (Double.parseDouble(input.getText().toString()) == 0) {
            input.requestFocus();
            input.setError(getResources().getString(R.string.quantity_greater_than_zero));
            return false;
        }

        return true;
    }

    public void delete(View v) {
        price.setText("");
        brandSpinner.setSelection(0);
        colorSpinner.setSelection(0);
    }
}
