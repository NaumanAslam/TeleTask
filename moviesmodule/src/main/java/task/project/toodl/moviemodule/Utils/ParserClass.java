package task.project.toodl.moviemodule.Utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import task.project.toodl.moviemodule.Interface.MoviesLoadingListener;

import static com.android.volley.VolleyLog.TAG;

public class ParserClass {
    Context context;

    public ParserClass(Context context) {
        this.context = context;
    }
    public ParserClass() {
    }

    public static List<MoviesDataModel> fetchMovieDetails(Application context, final MoviesLoadingListener loadResCompletionListener){

        final List<MoviesDataModel> _data = new ArrayList<>();
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                CONSTANTS.url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                try {
                    //JSONArray jsonArray = response.getJSONArray("results");
                    for (int i =0;i<response.length();i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        MoviesDataModel moviesDataModel=new MoviesDataModel();
                        moviesDataModel.setTitle(jsonObject.getString("title"));
                        moviesDataModel.setDescription(jsonObject.getString("description"));
                        moviesDataModel.setDirector(jsonObject.getString("director"));
                        moviesDataModel.setProducer(jsonObject.getString("producer"));
                        moviesDataModel.setReleaseDate(jsonObject.getInt("release_date"));
                    _data.add(moviesDataModel);
                    }
                    loadResCompletionListener.onMoviesLoaded(_data);
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Toast.makeText(context, "Error: " + e.getMessage(),
                    //   Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // Toast.makeText(context,error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
            }
        });
// Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
        return _data;
    }


}
