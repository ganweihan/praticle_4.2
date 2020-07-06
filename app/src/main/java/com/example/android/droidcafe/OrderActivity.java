/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity shows the order chosen.  The order is sent as data
 * with the intent to launch this activity.
 */
public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        // Get the intent and its data.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }


    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void showboat(View view) {
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.chocolate_syrup);
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.sprinkles);
        CheckBox checkbox3 = (CheckBox) findViewById(R.id.crushed_nuts);
        CheckBox checkbox4 = (CheckBox) findViewById(R.id.cherries);
        CheckBox checkbox5 = (CheckBox) findViewById(R.id.orio_cookie_crumbles);
        String message = "Toppings: ";
        if (checkbox1.isChecked()) {
            message = "Toppings:chocolate syrup";
            if (checkbox2.isChecked()) {
                message = "Toppings:chocolate syrup sprinkles";
                if (checkbox3.isChecked()) {
                    message = "Toppings:chocolate syrup sprinkles crushed nuts";
                    if (checkbox4.isChecked()) {
                        message = "Toppings:chocolate syrup sprinkles crushed nuts cherries";
                        if (checkbox5.isChecked()) {
                            message = "Toppings:chocolate syrup sprinkles crushed nuts cherries orio cookie crumbles";
                        }

                    }
                    else if(checkbox1.isChecked()&&checkbox2.isChecked()&&checkbox3.isChecked()&&checkbox5.isChecked())
                    {
                        message = "Toppings:chocolate syrup sprinkles crushed nuts orio cookie crumbles";
                    }

                }
                else if(checkbox1.isChecked()&&checkbox2.isChecked()&&checkbox4.isChecked()){
                    message = "Toppings:chocolate syrup sprinkles cherries ";

                }
                else if(checkbox1.isChecked()&&checkbox2.isChecked()&&checkbox5.isChecked()){
                    message = "Toppings:chocolate syrup sprinkles orio cookie crumbles ";

                }

            }
            else if(checkbox1.isChecked()&&checkbox3.isChecked())
            {
                message = "Toppings:chocolate syrup crushed nuts ";
            }
            else if (checkbox1.isChecked()&&checkbox4.isChecked())
            {
                message = "Toppings:chocolate syrup cherries";
            }
            else if (checkbox1.isChecked()&&checkbox5.isChecked())
            {
                message = "Toppings:chocolate syrup orio cookie crumbles ";
            }

        }
            else if(checkbox2.isChecked()){
            message="Toppings: sprinkles ";
                if(checkbox2.isChecked()&&checkbox3.isChecked()){
            message="Toppings:sprinkles crushed nuts ";}
                else if(checkbox2.isChecked()&&checkbox4.isChecked())
                {
                    message="Toppings:sprinkles cherries ";
                }
                else if(checkbox2.isChecked()&&checkbox5.isChecked())
                {
                    message="Toppings:sprinkles orio cookie crumbles ";
                }
            else if (checkbox2.isChecked()&&checkbox3.isChecked()&&checkbox4.isChecked()){
                message="Toppings:sprinkles crushed nuts cherries ";
            }
                else if (checkbox2.isChecked()&&checkbox3.isChecked()&&checkbox5.isChecked()){
                    message="Toppings:sprinkles crushed nuts orio cookie crumbles ";
                }

            else if (checkbox2.isChecked()&&checkbox3.isChecked()&&checkbox4.isChecked()&&checkbox5.isChecked())
            { message="Toppings: sprinkles crushed nuts cherries orio cookie crumbles";}
            }
        else if(checkbox3.isChecked()) {
            message="Toppings:crushed nuts";
            if(checkbox3.isChecked()&&checkbox4.isChecked()){
            message="Toppings:crushed nuts cherries ";}
            else if (checkbox3.isChecked()&&checkbox5.isChecked()){
                message="Toppings:crushed nuts cherries orio cookie crumbles";
            }
            else if (checkbox3.isChecked()&&checkbox4.isChecked()&&checkbox5.isChecked())
            { message="Toppings:crushed nuts cherries orio cookie crumbles";}
        }
        else if(checkbox4.isChecked()){
            message="Toppings:cherries";
            if (checkbox4.isChecked()&&checkbox5.isChecked()){
                message="Toppings:cherries orio cookie crumbles";
            }
        }
        else if (checkbox5.isChecked())
        {
            message="Toppings:orio cookie crumbles";
        };


        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



    }






