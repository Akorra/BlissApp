package recruitment.blissapp;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public interface Requests {

    final String HEALTH = "https://private-anon-33c3c59231-blissrecruitmentapi.apiary-mock.com/health";
    final String LIST_QUESTIONS = "https://private-anon-33c3c59231-blissrecruitmentapi.apiary-mock.com/questions?";
    final String RETRIEVE = "https://private-anon-33c3c59231-blissrecruitmentapi.apiary-mock.com/questions/";
    final String CREATE = "https://private-anon-33c3c59231-blissrecruitmentapi.apiary-mock.com/questions/";
    final String UPDATE = "https://private-anon-33c3c59231-blissrecruitmentapi.apiary-mock.com/questions";
    final String SHARE = "https://private-anon-33c3c59231-blissrecruitmentapi.apiary-mock.com/share?";

    public void makeRequest();

}
