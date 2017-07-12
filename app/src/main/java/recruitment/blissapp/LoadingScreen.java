package recruitment.blissapp;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class LoadingScreen extends AppCompatActivity implements Requests {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        makeRequest();
    }

    @Override
    public void makeRequest() {

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, HEALTH, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String mResponse;

                try{
                    mResponse= response.getString("status");
                    if(mResponse.compareTo("OK")==0){
                        goToListScreen();
                    }else{
                        retryAction();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Log.d("HEALTH", "ERROR");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HEALTH", "ERROR");
            }
        });
        MySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(jsObjRequest);
    }

    public void retryAction(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.ServerDown).setTitle(R.string.DownTitle).setPositiveButton(R.string.tryA, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                makeRequest();
            }
        }).setNegativeButton("Go Away", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void goToListScreen(){}
}
