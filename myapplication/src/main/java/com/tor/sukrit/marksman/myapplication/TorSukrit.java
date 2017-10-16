package com.tor.sukrit.marksman.myapplication;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marksman on 15/10/2560.
 */

public class TorSukrit extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "http://jonhslim.pe.hu/sukrit/Loginsukrittorkhadlae.php";
    private Map<String, String> params;

    public TorSukrit(String username, String password, Response.Listener<String> Listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, Listener, null);
        params = new HashMap<>();
        params.put("goomaibok", username);
        params.put("araikongmung", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
