package task.project.toodl.moviemodule.Interface;

import java.util.List;

import task.project.toodl.moviemodule.Utils.MoviesDataModel;

public interface MoviesLoadingListener {
     void onMoviesLoaded(List<MoviesDataModel> _data);
}
