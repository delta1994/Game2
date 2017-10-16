package com.tor.sukrit.marksman.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marksman on 15/10/2560.
 */

public class Torsukrit2regis extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://jonhslim.pe.hu/sukrit/Registersukrittorkhadlae.php";
    private Map<String, String> params;

    public Torsukrit2regis(String buffalon, String baizonu, String copyandpastep, Response.Listener<String> Listener){
        super(Method.POST, REGISTER_REQUEST_URL, Listener, null);
        params = new HashMap<>();
        params.put("ikwai", baizonu);
        params.put("ingoong", copyandpastep);
        params.put("panyaon", buffalon);

    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
