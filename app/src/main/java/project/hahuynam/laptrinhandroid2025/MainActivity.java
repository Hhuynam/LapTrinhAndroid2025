package project.hahuynam.laptrinhandroid2025;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://57kmt.duckdns.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<LastId> call = apiService.getLastId();
        call.enqueue(new Callback<LastId>() {
            @Override
            public void onResponse(Call<LastId> call, Response<LastId> response) {
                if (!response.isSuccessful()) {
                    Log.e(TAG, "Request Failed. Code: " + response.code());
                    textView.setText("Request Failed. Code: " + response.code());
                    return;
                }

                LastId lastId = response.body();
                if (lastId != null) {
                    textView.setText("Last ID: " + lastId.getLastId());
                } else {
                    textView.setText("No data received");
                }
            }

            @Override
            public void onFailure(Call<LastId> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                textView.setText("Error: " + t.getMessage());
            }
        });
    }
}
