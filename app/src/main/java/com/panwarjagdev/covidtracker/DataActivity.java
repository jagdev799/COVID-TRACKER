package com.panwarjagdev.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class DataActivity extends AppCompatActivity {
String distname;
TextView Datastate,Datadist,Dataactive,Dataconfirm,Datamigeratedother,Datadeceased,Datarecovered,Deltarecovered,Deltadeceased,Deltaconfirmed;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        distname = getIntent().getStringExtra("distname");
        Datastate=findViewById(R.id.Datastate);
        Datadist=findViewById(R.id.Datadist);
        Dataactive=findViewById(R.id.Dataactive);
        Dataconfirm=findViewById(R.id.Dataconfirm);
        Datamigeratedother=findViewById(R.id.Datamigratedother);
       Datadeceased =findViewById(R.id.Datadeceased);
       Datarecovered=findViewById(R.id.Datarecovered);
       Deltaconfirmed=findViewById(R.id.Deltaconfirmed);
       Deltarecovered=findViewById(R.id.Deltarecovered);
       Deltadeceased=findViewById(R.id.Deltadeceased);
       fetchData();
    }


    private void fetchData() {

        String url = "https://data.covid19india.org/state_district_wise.json";

        StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject object = new JSONObject(response);
                    Iterator<String> states = object.keys();

                    while (states.hasNext()) {
                            String state = states.next();

                            JSONObject obj1 = object.getJSONObject(state);
                            JSONObject obj2 = obj1.getJSONObject("districtData");
                            Iterator<String> Districts = obj2.keys();

                            while (Districts.hasNext()) {

                                    String Dist = Districts.next();
                                if(Dist.equals(distname)) {
                                    JSONObject obj3 = obj2.getJSONObject(Dist);
                                    JSONObject obj4 = obj3.getJSONObject("delta");


                                    String active = obj3.getString("active");
                                    String confirmed = obj3.getString("confirmed");
                                    String migratedother = obj3.getString("migratedother");
                                    String deceased = obj3.getString("deceased");
                                    String recovered = obj3.getString("recovered");

                                    String deltaconfirmed = obj4.getString("confirmed");
                                    String deltadeceased = obj4.getString("deceased");
                                    String deltarecovered = obj4.getString("recovered");

                                    Dataactive.setText(active);
                                    Datastate.setText(state);
                                    Datadist.setText(Dist);
                                    Dataconfirm.setText(confirmed);
                                    Datamigeratedother.setText(migratedother);
                                    Datadeceased.setText(deceased);
                                    Datarecovered.setText(recovered);
                                    Deltaconfirmed.setText(deltaconfirmed);
                                    Deltadeceased.setText(deltadeceased);
                                    Deltarecovered.setText(deltarecovered);
                                    break;



                                }

                            }


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // In case of error it will run
                Toast.makeText(DataActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue reqQueue = Volley.newRequestQueue(this);
        reqQueue.add(req);
    }

}


