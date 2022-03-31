package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textview_0;
    int num =0;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniDatePicker();
        dateButton = findViewById(R.id.datePickerbutton);
        dateButton.setText(getTodayDate());



        textview_0 = findViewById(R.id.textView12);
        textview_0.setText("" +num);


        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Cites));

        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.back));

        ArrayAdapter <String> adapter3 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Levels));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);


    }

    private String getTodayDate(){

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month =month +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }


    private void iniDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener =  new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = makeDateString (day,month,year);
                dateButton.setText(date);

            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style ,dateSetListener,year,month,day);


    }

    private String makeDateString(int day, int month, int year) {
    return getMonthFormat(month) + " " + day +" " +year;

    }

    private String getMonthFormat(int month) {
        if (month ==1)
            return "JAN";
        if (month ==2)
            return "FEB";
        if (month ==3)
            return "MAR";
        if (month ==4)
            return "APR";
        if (month ==5)
            return "MAY";
        if (month ==6)
            return "JUN";
        if (month ==7)
            return "JUL";
        if (month ==8)
            return "AUG";
        if (month ==9)
            return "SEP";
        if (month ==10)
            return "OCT";
        if (month ==11)
            return "NOV";
        if (month ==12)
            return "DEC";

        return "JAN";

    }
    public void openDatePicker (View view){
        datePickerDialog.show();
    }

    public void increment (View view){
    num++;
        textview_0.setText("" +num);

    }
    public void decrement (View view){
    num--;
        textview_0.setText("" +num);

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}