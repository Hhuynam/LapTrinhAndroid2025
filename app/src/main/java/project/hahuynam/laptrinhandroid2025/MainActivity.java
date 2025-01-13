package project.hahuynam.laptrinhandroid2025;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Gọi API để lấy last_id
        fetchLastId();
    }

    private void fetchLastId() {
        ApiService apiService = RetrofitInstance.getApiService();
        Call<Post> call = apiService.getLastId("last_id");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Hiển thị last_id lên giao diện người dùng
                    int lastId = response.body().getLast_id();
                    textView.setText("Last ID: " + lastId);
                } else {
                    textView.setText("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText("Failure: " + t.getMessage());
            }
        });
    }
}