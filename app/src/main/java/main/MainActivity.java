package main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gun0912.tedpicker.ImagePickerActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import common.method.Method;
import common.utils.FileUtils;
import interfaces.Webservices;
import model.M_upload_photo;
import model.M_user_path_res;
import model.M_user_signup_form_res;
import model.M_user_signup_req;
import model.M_user_signup_res;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zeroturnaround.org.jrebel4androidgettingstarted.R;

public class MainActivity extends AppCompatActivity {

    private static final int INTENT_REQUEST_GET_IMAGES = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPathRx();
        //postJson();
        //postForm();
        //postFormQueryMap();
        //getPath();
        //postMultipart();
        //getFileDownload();
    }


    public void postJson(){

        Webservices webservices = Method.getRetrofit().create(Webservices.class);
        M_user_signup_req m_user_signup_req = new M_user_signup_req.Builder()
                .email_address("testwts06@gmail.com")
                .password("wings123")
                .username("testabc")
                .build();

        Call<M_user_signup_res> m_user_signup_resCall = webservices.signInJson(m_user_signup_req);
        m_user_signup_resCall.enqueue(new Callback<M_user_signup_res>() {
            @Override
            public void onResponse(Call<M_user_signup_res> call, Response<M_user_signup_res> response) {
                Log.e("REs", response.body().getUser().getEmail_address());
            }

            @Override
            public void onFailure(Call<M_user_signup_res> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }



    public void postForm(){
        Webservices webservices = Method.getRetrofit().create(Webservices.class);
        Call<M_user_signup_form_res> m_user_signup_form_resCall = webservices.signInForm("Android", "andro12345", "android@google.com");
        m_user_signup_form_resCall.enqueue(new Callback<M_user_signup_form_res>() {
            @Override
            public void onResponse(Call<M_user_signup_form_res> call, Response<M_user_signup_form_res> response) {
                Log.e("REs", response.body().getUser().getEmail_address()+"...");
            }

            @Override
            public void onFailure(Call<M_user_signup_form_res> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }


    public void postFormQueryMap(){
        Map<String, String> map = new HashMap<>();
        map.put("username","smit satodia");
        map.put("password","dasfwef5tw67rew$#@#$");
        map.put("email_address", "satodiasmit@gmail.com");

        Method.Dialogue.sD(MainActivity.this);
        Webservices webservices = Method.getRetrofit().create(Webservices.class);
        Call<M_user_signup_form_res> m_user_signup_form_resCall = webservices.signInMapForm(map);
        m_user_signup_form_resCall.enqueue(new Callback<M_user_signup_form_res>() {
            @Override
            public void onResponse(Call<M_user_signup_form_res> call, Response<M_user_signup_form_res> response) {
                Log.e("REs", response.body().getUser().getPassword()+"...");
                Method.Dialogue.hD();
            }

            @Override
            public void onFailure(Call<M_user_signup_form_res> call, Throwable t) {
                Log.e("Error", t.toString());
                Method.Dialogue.hD();
            }
        });


    }

    public void getPath(){
        Webservices webservices = Method.getRetrofit().create(Webservices.class);

        Call<M_user_path_res> m_user_signup_form_resCall = webservices.signInGet("6");
        m_user_signup_form_resCall.enqueue(new Callback<M_user_path_res>() {
            @Override
            public void onResponse(Call<M_user_path_res> call, Response<M_user_path_res> response) {
                Log.e("REs", response.body().getUser().getEmail_address() + "...");
            }

            @Override
            public void onFailure(Call<M_user_path_res> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }

    public void getPathRx(){
        Webservices apiService = Method.getRetrofit().create(Webservices.class);
        apiService.signInGetRx("6")
                .subscribeOn(Schedulers.io()) // optional if you do not wish to override the default behavior
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<M_user_path_res>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error",e.toString()+"...");
                    }

                    @Override
                    public void onNext(M_user_path_res user) {
                        Log.e("REs", user.getUser().getUsername() + "...");
                    }
                });
    }

    public void postMultipart(){

        Intent intent  = new Intent(this, ImagePickerActivity.class);
        startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES);
    }



    public void getFileDownload(){
        new AsyncTask<Void, Long, Void>(){
            String fileUrl = "http://cdn.allwallpaper.in/wallpapers/6230x1720/16897/sunrise-night-widescreen-6230x1720-wallpaper.jpg";

            @Override
            protected void onPreExecute() {
                Method.Dialogue.sD(MainActivity.this);

                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Method.Dialogue.hD();

                super.onPostExecute(aVoid);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                Webservices webservices = Method.getRetrofit().create(Webservices.class);
                Call<ResponseBody> call = webservices.downloadFileWithDynamicUrlSync(fileUrl);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            boolean writtenToDisk = writeResponseBodyToDisk(response.body());
                            Log.e("File download status", "file download was a success? " + writtenToDisk);
                        }
                        else {
                            Log.e("Server error", "server contact failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

                return null;
            }
        }.execute();
    }


    @Override
    protected void onActivityResult(int requestCode, int resuleCode, Intent intent) {
        super.onActivityResult(requestCode, resuleCode, intent);

        if (requestCode == INTENT_REQUEST_GET_IMAGES && resuleCode == Activity.RESULT_OK ) {

            ArrayList<Uri> image_uris = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
            Uri one = image_uris.get(0);
            File file = new File(one.getPath());
            Webservices webservices = Method.getRetrofit().create(Webservices.class);

            if(file==null){
                Log.e("ERROR","File is null");

            }else{
                Log.e("URI NAME",""+file.getPath());
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("photo_path", file.getName(), requestFile);
                String filenamestring = System.currentTimeMillis()+ FileUtils.getExtension(file.getPath());
                RequestBody filename = RequestBody.create(MediaType.parse("multipart/form-data"), filenamestring);

                Call<M_upload_photo> resultCall = webservices.uploadImage(body, filename);

                resultCall.enqueue(new Callback<M_upload_photo>() {
                    @Override
                    public void onResponse(Call<M_upload_photo> call, Response<M_upload_photo> response) {

                        if (response.isSuccessful()) {
                            Response<M_upload_photo> m_upload_photo = response;
                            Log.e("Response", response.message()+"..."+m_upload_photo.body().getFlag());
                        } else {
                            Log.e("Response", "Unknown error occured");
                        }
                    }

                    @Override
                    public void onFailure(Call<M_upload_photo> call, Throwable t) {
                        Log.e("Error", t.getMessage()+"...");
                    }
                });
            }
        }
    }

    private boolean writeResponseBodyToDisk(ResponseBody body){


        try {
            // todo change the file location/name according to your needs
            //File futureStudioIconFile = new File(getExternalFilesDir(null) + File.separator + "Future Studio Icon.png");
            File futureStudioIconFile = new File(Environment.getExternalStorageDirectory() + File.separator + "zzz.png");
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    Log.e("SUCCESS", "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
}
