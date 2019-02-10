package task.project.tele.assignment.ViewModels;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import task.project.toodl.moviemodule.Interface.MoviesLoadingListener;
import task.project.toodl.moviemodule.Utils.ParserClass;
import task.project.toodl.moviemodule.Utils.MoviesDataModel;

public class MoviesViewModel extends AndroidViewModel {
Application application;

    private MutableLiveData<List<MoviesDataModel>> moviesList;

    public MoviesViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
    }

    //we will call this method to get the data
    public LiveData<List<MoviesDataModel>> getMoviesList() {
//if the list is null
        if (moviesList == null) {
            moviesList = new MutableLiveData<List<MoviesDataModel>>();
//we will load it asynchronously from server in this method
            loadMovies();
        }
//finally we will return the list
        return moviesList;
    }

 //calling my library to return parsed movies data in an arraylist
     private void loadMovies() {
        ParserClass.fetchMovieDetails(application, new MoviesLoadingListener() {
            @Override
            public void onMoviesLoaded(List<MoviesDataModel> _data) {
                 moviesList.setValue(_data);
            }
        });
    }
}
