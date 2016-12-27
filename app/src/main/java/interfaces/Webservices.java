package interfaces;

import java.util.Map;

import model.M_upload_photo;
import model.M_user_path_res;
import model.M_user_req;
import model.M_user_res;
import model.M_user_signup_form_res;
import model.M_user_signup_req;
import model.M_user_signup_res;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

public interface Webservices {

    @GET("user/details/{id}")
    Observable<M_user_path_res> signInGetRx(@Path("id") String id);

    @POST("signin")
    Call<M_user_res> signIn(@Body M_user_req m_user_req);

    @POST("user/signup/json")
    Call<M_user_signup_res> signInJson(@Body M_user_signup_req m_user_signup_req);

    @FormUrlEncoded
    @POST("user/signup/post")
    Call<M_user_signup_form_res> signInForm(@Field("username") String username,@Field("password") String password,@Field("email_address") String email_address);

    @FormUrlEncoded
    @POST("user/signup/post")
    Call<M_user_signup_form_res> signInMapForm(@FieldMap Map<String, String> map);

    @GET("user/details/{id}")
    Call<M_user_path_res> signInGet(@Path("id") String id);

    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);

    @Multipart
    @POST("upload_img.php")
    Call<M_upload_photo> uploadImage(@Part MultipartBody.Part file, @Part("file_name") RequestBody filename);

}
