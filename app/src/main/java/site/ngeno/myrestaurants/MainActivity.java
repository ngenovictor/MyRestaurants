package site.ngeno.myrestaurants;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.findRestaurants) Button mFindRestaurantsButton;
    @Bind(R.id.locationEdit) EditText mLocationEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Typeface robotoFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");
        mFindRestaurantsButton.setTypeface(robotoFont);
        mFindRestaurantsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v == mFindRestaurantsButton){
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
