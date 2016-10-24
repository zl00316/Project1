package com.example.lab4;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.*;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView mTextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RequestQueue queue = Volley.newRequestQueue(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView = (TextView) findViewById(R.id.textView);
                editText = (EditText) findViewById(R.id.editText);
                final String test = editText.getText().toString();
                final String url = "http://api.openweathermap.org/data/2.5/weather?zip="+test+",us&appid=181debbe9663adb188f8cce64f2dbef7&units=imperial";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                mTextView.setText("Response is: "+ response);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText(test);

                    }
                });

                queue.add(stringRequest);

            }
        });
    }
}