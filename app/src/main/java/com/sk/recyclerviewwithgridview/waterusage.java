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
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class waterusage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterusage);
        final TextView textView = (TextView) findViewById(R.id.textView12);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://api.thingspeak.com/channels/737801/feeds.json?api_key=R7R0NKNJFKHSQB82&results=1";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray a=response.getJSONArray("feeds");
                            JSONObject b=a.optJSONObject(0);



                            textView.setText(b.getString("field1").substring(0,5)+"L");
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
