package com.example.weather_ayanur12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.weather_ayanur12.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.Date;

import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LottieAnimationView lotty_bad_weather;
    String my_time =
            java.text.DateFormat.getDateTimeInstance()
                    .format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        lotty_bad_weather = findViewById(R.id.lotty_bad_weather);
        lotty_bad_weather.setAnimation(R.raw.bad_weather);

        binding.badWeatherCloud1.setVisibility(View.INVISIBLE);
        binding.badWeatherCloud2.setVisibility(View.INVISIBLE);
        lotty_bad_weather.setVisibility(View.INVISIBLE);

        binding.sun.setVisibility(View.VISIBLE);
        binding.goodWeatherSky.setVisibility(View.VISIBLE);

        binding.currentTime.setText(my_time);

        binding.btnShow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                RetrofitBuilder.getInstance().getCurrentWeather(
                        binding.editCity.getText().toString()
                                .trim(), apiKey).enqueue(new Callback<Example>(){
                                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response){
                                        if (response.isSuccessful() && response.body()  null)
                                    }

                });
            }

            final String apiKey = "e7bf8a312b66c1202aa796104b012af7";

        });
        LinearLayout m = findViewById(R.id.bottom.sheet.layout);

        sheetBehavior = BottomSheetBehavior.from(m);

    }
}