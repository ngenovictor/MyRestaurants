package site.ngeno.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
    public static final String TAG = RestaurantActivity.class.getSimpleName();
    @Bind(R.id.listView) ListView mRestaurantListView;
    @Bind(R.id.locationTextView) TextView mLocationText;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private RestaurantListAdapter mAdapter;

    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        ButterKnife.bind(this);
        Intent intent = getIntent();


        String location = intent.getStringExtra("location");
        if(location.equals("")){
            mLocationText.setText("You wont get any info if you don't input location");
        }else{
            mLocationText.setText("Here are all the restaurants near "+location);
        }

        getRestaurants(location);
        Log.d(TAG, "In the onCreate method!");

    }
    private void getRestaurants(String location){
        final YelpService yelpService = new YelpService();
        yelpService.findRestaurants(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mRestaurants = yelpService.processResult(response);
                RestaurantActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new RestaurantListAdapter(getApplicationContext(), mRestaurants);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(false);

                    }
                });
            }
        });
    }
}
