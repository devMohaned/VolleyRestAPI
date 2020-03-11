package com.vrest.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.vrest.api.adapters.AnimalAdapter;
import com.vrest.api.models.Animal;
import com.vrest.api.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.android.volley.Request.Method.GET;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ID_animals_recyclerview)
    RecyclerView mRecyclerView;


    List<Animal> mAnimalList = new ArrayList<Animal>();
    AnimalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new AnimalAdapter(mAnimalList);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        getAnimals();
    }

    private void getAnimals() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = Utils.getEntriesGetRequestUrl("animals");
        JsonArrayRequest jsonRequest = new JsonArrayRequest(GET,
                url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject currentJSONObject = response.getJSONObject(i);
                            Animal animal = new Animal(
                                    currentJSONObject.getString(Utils.Constants.JSON_API),
                                    currentJSONObject.getString(Utils.Constants.JSON_DESCRIPTION),
                                    currentJSONObject.getString(Utils.Constants.JSON_AUTH),
                                    currentJSONObject.getString(Utils.Constants.JSON_HTTPS),
                                    currentJSONObject.getString(Utils.Constants.JSON_CORS),
                                    currentJSONObject.getString(Utils.Constants.JSON_LINK),
                                    currentJSONObject.getString(Utils.Constants.JSON_CATEGORY));
                            mAnimalList.add(animal);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }finally {
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
    }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Well, Error has occured, fix it.", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(jsonRequest);

    }
}
