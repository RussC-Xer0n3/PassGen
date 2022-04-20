package com.local.russellclarke.passgen;
/**
 * PassGen - Password Generator - Free Version.
 * Created by russellclarke on 18/11/2017.
 * Contact: Russell Clarke - +44(0)7965579198 - russellclarke82@gmail.com
 * Main Activity
 */
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private PopupWindow window;
    private TextView textview;
    Jenny jenny = new Jenny();

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultiSelectionSpinner spinner = (MultiSelectionSpinner) findViewById(R.id.spinner_selector);
        setList();
        spinner.setItems(list);

        Button gen = (Button)findViewById(R.id.generate_button);
        Button clear = (Button)findViewById(R.id.clear_button);
        Button save = (Button) findViewById(R.id.save_button);

        gen.setOnClickListener(this);
        clear.setOnClickListener(this);
        save.setOnClickListener(this);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(256);
        seekBar.setProgress(8); //Sets minimum value for progress./

        // Create a pop up referencing password character count on seekbar change.
        window = new PopupWindow(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textview = new TextView(this);
        textview.setTextSize(15);
        textview.setTextColor(Color.DKGRAY);
        window.setContentView(textview);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress <= 8){
                    //Ensures the user only sees '8' when attempting to set lower value./
                    seekBar.setProgress(8);
                    // Ensure the count is 8
                    textview.setText("8");
                }else{
                    seekBar.setProgress(Integer.parseInt(String.valueOf(progress)));
                    textview.setText("" + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Sets the location of the value display window in the activity.
                window.showAtLocation(findViewById(R.id.seekBar), 8, 1,-1);
                window.showAsDropDown(seekBar);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() <= 8){
                    seekBar.setProgress(8);
                    jenny.setULength(8);
                }else {
                    jenny.setULength(seekBar.getProgress());
                }
                window.dismiss();
            }
        });
    }

    public void setList() {
        list.add("@"); list.add("#"); list.add("$"); list.add("%"); list.add("^"); list.add("~");
        list.add("&"); list.add("*"); list.add(";"); list.add(":"); list.add("\""); list.add("+");
        list.add("-"); list.add("_"); list.add("="); list.add("/"); list.add("£"); list.add(".");
    }

    public void onCheckboxClicked(View view) {

        // Is the checkbox checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked and do something.
        switch (view.getId()) {
            case R.id.lower_checkbox:
                if (checked) {
                    jenny.setDCase("abcdefghijklmnopqrstuvwxyz");
                } else {
                    jenny.setDCase("");
                }
                break;
            case R.id.upper_checkbox:
                if (checked) {
                    jenny.setUCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                } else {
                    jenny.setUCase("");
                }
                break;
            case R.id.numerical_checkbox:
                if (checked) {
                    jenny.setNum("0123456789");
                } else {
                    jenny.setNum("");
                    break;
                }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.passText: {
                EditText pass = (EditText)findViewById(R.id.passText);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                // Gets a handle to the clipboard service.
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(pass.getWindowToken(), 0);
                } else {
                    imm.hideSoftInputFromWindow(pass.getWindowToken(), 0);
                }
                if (pass.getText() == null || pass.getText().length() < 7) {
                    // Notify.
                    Toast.makeText(getApplicationContext(), "No Data to copy.", Toast.LENGTH_SHORT).show();
                    break;
                }else{
                    ClipData clip = ClipData.newPlainText(" ", pass.getText());
                    // Set the clipboard's primary clip.
                    clipboard.setPrimaryClip(clip);
                    // Notify.
                    Toast.makeText(getApplicationContext(), "Data copied to Clipboard.", Toast.LENGTH_SHORT).show();
                }break;
            }
            case R.id.generate_button: {
                if (jenny.getDCase() == "" && jenny.getUCase() == "" && jenny.getNum() == "" && jenny.getSym() == ""){
                    // Notify
                    Toast.makeText(getApplicationContext(), "No Password Generated.", Toast.LENGTH_SHORT).show();
                    // Clear the text area
                    EditText pass = (EditText) findViewById(R.id.passText);
                    pass.setText("");
                }else {
                    EditText pass = (EditText) findViewById(R.id.passText);
                    jenny.Generate();
                    pass.setText(jenny.getKee());
                    jenny.setKee("");
                }
                break;
            }
            case R.id.save_button: {
                //TODO sort out the DB



                //TODO sort out the crypt
                //TODO Android account links

                break;
            }
            case R.id.clear_button: {
                EditText pass = (EditText)findViewById(R.id.passText);
                //Can't just toggle as everytime 'clear' is clicked the CheckBox is checked./
                CheckBox lower = (CheckBox)findViewById(R.id.lower_checkbox);
                CheckBox upper = (CheckBox)findViewById(R.id.upper_checkbox);
                CheckBox number = (CheckBox)findViewById(R.id.numerical_checkbox);

                // Creating a new spinner resets it to default./
                MultiSelectionSpinner spinner = (MultiSelectionSpinner) findViewById(R.id.spinner_selector);
                setList();
                spinner.setItems(list);

                //Creating a new seekBar resets it./
                SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
                seekBar.setProgress(8);
                textview.setText("8");
                jenny.setULength(8);//Just to make sure./

                pass.setText("");
                jenny.setSym("");

                if(jenny.getDCase().matches("^[a-zA-Z0-9]+")) {
                    lower.toggle();
                    jenny.setDCase("");
                }else{
                    jenny.setDCase("");
                }

                if(jenny.getUCase().matches("^[a-zA-Z0-9]+")) {
                    upper.toggle();
                    jenny.setUCase("");
                }else{
                    jenny.setUCase("");
                }

                if(jenny.getNum().matches("^[a-zA-Z0-9]+")) {
                    number.toggle();
                    jenny.setNum("");
                }else{
                    jenny.setNum("");
                }

                break;
            }
            //TODO: Start ads for free version.
        }
    }
}
