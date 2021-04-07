package ir.tinyroid.testokhttp;

import android.os.AsyncTask;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
public class MainActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();
    TextView txtString;
    public String url= "https://reqres.in/api/users/2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtString= (TextView)findViewById(R.id.txtString);
        OkHttpHandler okHttpHandler= new OkHttpHandler();
        okHttpHandler.execute(url);
    }
     class OkHttpHandler extends  AsyncTask<String,String,String>{

         @Override
         protected String doInBackground(String... params) {

             Request.Builder builder = new Request.Builder();
             builder.url(params[0]);
             Request request = builder.build();
             try {
                 Response response = client.newCall(request).execute();
                 return response.body().string();
             }catch (Exception e){
                 e.printStackTrace();
             }
             return null;
         }
         protected void onPostExecute(String s) {
             super.onPostExecute(s);
             txtString.setText(s);
         }
     }

}