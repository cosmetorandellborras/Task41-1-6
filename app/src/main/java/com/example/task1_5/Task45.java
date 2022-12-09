package com.example.task1_5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.task1_5.databinding.ActivityTask45Binding;

import java.text.DateFormat;
import java.util.Calendar;

public class Task45 extends AppCompatActivity {

    private ActivityTask45Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTask45Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.testAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicDialog();
            }
        });
        binding.timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime(view);
            }
        });
        binding.dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalendar(view);
            }

        });

    }
    private void basicDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Click OK to continue, or Cancel to stop: ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    public void showCalendar(View v){
            Calendar c = Calendar.getInstance();
            int day = c.get(Calendar.DAY_OF_MONTH);
            int month = c.get(Calendar.MONTH);
            int year = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    Toast.makeText(getApplicationContext(),"The date selected is "+dayOfMonth+"/"+monthOfYear+"/"+year,Toast.LENGTH_SHORT).show();
                }
            },year,month,day);
            datePickerDialog.show();
        }
        public void showTime(View v){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(),"The time selected is: "+hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();
            }
        },hour,min,false);
        timePickerDialog.show();
    }
}

