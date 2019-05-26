package com.sk.recyclerviewwithgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class turbidity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turbidity);
        final TextView textView = (TextView) findViewById(R.id.text);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://api.thingspeak.com/channels/710010/feeds.json?api_key=7IEQ57I07WJNXMIQ&results=1";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       try{
                           JSONArray a=response.getJSONArray("feeds");
                           JSONObject b=a.optJSONObject(0);



                           textView.setText(b.getString("field1"));
                           Log.d("response","success");
                       }
                       catch (JSONException e) {
                           e.printStackTrace();
                       }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.d("response","failure");

                    }
                });
        requestQueue.add(jsonObjectRequest);

    }
}
