package project.hahuynam.laptrinhandroid2025;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("android/api.aspx?action=last_id")
    Call<LastId> getLastId();
}
