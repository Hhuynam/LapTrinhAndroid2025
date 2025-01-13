package project.hahuynam.laptrinhandroid2025;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("android/api.aspx")
    Call<Post> getLastId(@Query("action") String action);
}
