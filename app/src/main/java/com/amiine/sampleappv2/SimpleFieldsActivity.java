package com.amiine.sampleappv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by G507041 on 29/12/2016.
 */

public class SimpleFieldsActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textfields_input_activity);
    }

    public void validateForm(View view){

        EditText name = (EditText)findViewById(R.id.text_name);
        Validation.isTextValid(name);
        EditText password = (EditText)findViewById(R.id.text_password);
        Validation.isTextValid(password);
        EditText mail = (EditText)findViewById(R.id.text_mail);
        Validation.isEmailValid(mail);
        EditText phone = (EditText)findViewById(R.id.text_phone);
        Validation.isPhoneValid(phone);
        EditText date = (EditText)findViewById(R.id.text_date);
        Validation.isDateValid(date);

    }
}
