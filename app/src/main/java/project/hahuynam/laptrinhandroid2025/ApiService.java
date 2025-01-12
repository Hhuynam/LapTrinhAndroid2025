package project.hahuynam.laptrinhandroid2025;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("posts")
    Call<List<Post>> getPosts();
}