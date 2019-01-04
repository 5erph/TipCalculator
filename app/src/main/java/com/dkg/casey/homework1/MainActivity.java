package com.dkg.casey.homework1;

//CASEY LORIA
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billTotal;
    SeekBar customTip;
    double total= 0.0;
    TextView tipPercent, tenPercent, fifteenPercent, twentyPercent, tenTotal, fifteenTotal, twentyTotal, customTipText, customTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billTotal = (EditText) findViewById(R.id.editText);
        customTip = (SeekBar) findViewById(R.id.seekBar);
        tipPercent = (TextView) findViewById(R.id.textView16);
        tenPercent = (TextView) findViewById(R.id.textView8);
        tenTotal = (TextView) findViewById(R.id.textView12);
        fifteenPercent = (TextView) findViewById(R.id.textView9);
        fifteenTotal = (TextView) findViewById(R.id.textView13);
        twentyPercent = (TextView) findViewById(R.id.textView10);
        twentyTotal = (TextView) findViewById(R.id.textView14);
        customTipText = (TextView) findViewById(R.id.customTip2);
        customTotal = (TextView) findViewById(R.id.customTip4);

        billTotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                 total = Double.parseDouble(billTotal.getText().toString());
                 //10%
                 tenPercent.setText(Double.toString(total*.1));
                 tenTotal.setText(Double.toString(total + (total * .1)));

                 //15%
                fifteenPercent.setText(Double.toString(total*.15));
                fifteenTotal.setText(Double.toString(total + (total*.15)));

                //20%
                twentyPercent.setText(Double.toString(total*.2));
                twentyTotal.setText(Double.toString((total*.2) + total));

            }
        });

        customTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tipPercent.setText(Integer.toString(i));
                customTipText.setText(Double.toString((total * (Integer.parseInt(tipPercent.getText().toString()))/100)));
                customTotal.setText(Double.toString(total + (Double.parseDouble(customTipText.getText().toString()))));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
