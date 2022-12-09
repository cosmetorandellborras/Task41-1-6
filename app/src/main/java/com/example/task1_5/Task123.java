package com.example.task1_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task1_5.databinding.ActivityTask123Binding;

public class Task123 extends AppCompatActivity {

    private ActivityTask123Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTask123Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(savedInstanceState !=null){
            binding.emailSpinnerTextView.setText(savedInstanceState.getString("phoneSpinner"));

        }

        binding.showName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),binding.editName.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        binding.showNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),binding.editNumber.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        binding.showEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),binding.editEmail.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        binding.editTextOnEditorActionListener.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String dni = charSequence.toString();
                if(dni.length()==9){
                    binding.editTextOnEditorActionListener.setTextColor(Color.GREEN);
                }
                else{
                    binding.editTextOnEditorActionListener.setTextColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        binding.showDNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editTextOnEditorActionListener.getText().length() == 9){
                    Toast.makeText(getApplicationContext(),binding.editTextOnEditorActionListener.getText().toString()+" is correct",Toast.LENGTH_SHORT).show();
                    binding.editTextOnEditorActionListener.setTextColor(Color.BLACK);
                }
                else{
                    Toast.makeText(getApplicationContext(),binding.editTextOnEditorActionListener.getText().toString()+" incorrect format",Toast.LENGTH_SHORT).show();
                    binding.editTextOnEditorActionListener.setTextColor(Color.BLACK);
                    binding.editTextOnEditorActionListener.setText("");
                }
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.places ,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.PhoneType.setAdapter(adapter);

        binding.PhoneType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.emailSpinnerTextView.setText("Phone number: "+binding.editPhoneSpinner.getText().toString()+" - "+adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("phoneSpinner",binding.emailSpinnerTextView.getText().toString());
    }
}