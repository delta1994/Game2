package com.tor.sukrit.marksman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText sukritname = (EditText) findViewById(R.id.etR_nametor);
        final EditText sukrituser = (EditText) findViewById(R.id.etR_usernametor);
        final EditText sukritpass = (EditText) findViewById(R.id.etR_passwordtor);
        final Button btnsukritregister = (Button) findViewById(R.id.btnR_registertor);
        btnsukritregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String buffalon = sukritname.getText().toString();
                final String baizonu = sukrituser.getText().toString();
                final String copyandpastep = sukritpass.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("ลงทะเบียน สำเร็จ")
                                        .setNegativeButton("OK", null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(Register.this, MainActivity.class);
                                Register.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("ลงทะเบียน ไม่สำเร็จ")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Torsukrit2regis torsukrit2regis = new Torsukrit2regis(buffalon, baizonu, copyandpastep, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(torsukrit2regis);
            }
        });
    }
}
