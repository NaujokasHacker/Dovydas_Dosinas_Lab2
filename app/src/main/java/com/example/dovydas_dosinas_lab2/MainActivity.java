package com.example.dovydas_dosinas_lab2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import utils.TextCounter;

public class MainActivity extends AppCompatActivity {

    private Spinner spSelectionOptions;
    private EditText edPhrase ;
    private TextView tvMain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edPhrase = findViewById(R.id.edPhrase);
        this.tvMain = findViewById(R.id.tvMain);
//        this.button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showToast();
//            }
//        });
//
//        public void showToast(){
//            LayoutInflater inflater = getLayoutInflater();
//            View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_root));
//
//            Toast toast = new Toast(getApplicationContext());
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.setDuration(Toast.LENGTH_LONG);
//            toast.setView(layout);
//            toast.show();
//
//        }

        this.spSelectionOptions = (Spinner) findViewById(R.id.spSelectionOptions);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String selectedOption = this.spSelectionOptions.getSelectedItem().toString();
        String defaultCharsSelectedOption = getResources().getString(R.string.chars_selection);

        if(selectedOption.equals(defaultCharsSelectedOption)){
            String userInputText = this.edPhrase.getText().toString();
            if(TextUtils.isEmpty(userInputText)){
                //TODO:
                Toast.makeText(getApplicationContext(), "Text field is empty!", Toast.LENGTH_LONG).show();
            }
            else {
                String charsCount = TextCounter.getCharsCount(userInputText);
                this.tvMain.setText(charsCount);
            }
        }
        else{
            String userInputText = this.edPhrase.getText().toString();
            if(TextUtils.isEmpty(userInputText)){
                //TODO:
                Toast.makeText(getApplicationContext(), "Text field is empty!", Toast.LENGTH_LONG).show();
            }
            else{
                String charsCount = TextCounter.getWordsCount(userInputText);
                this.tvMain.setText(charsCount);
            }
        }
    }
}