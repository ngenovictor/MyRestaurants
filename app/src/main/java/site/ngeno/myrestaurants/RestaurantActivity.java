package site.ngeno.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {
    private TextView mLocationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationText = (TextView) findViewById(R.id.locationTextView);
        mLocationText.setText("Here are all the restaurants near "+location);

    }
}
