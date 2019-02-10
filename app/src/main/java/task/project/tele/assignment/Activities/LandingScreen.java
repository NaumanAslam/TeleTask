package task.project.tele.assignment.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import task.project.tele.assignment.Adapters.MoviewsRecyclerAdapter;
import task.project.tele.assignment.R;
import task.project.tele.assignment.Utils.Utils;
import task.project.toodl.assignment.ViewModels.MoviesViewModel;
import task.project.toodl.moviemodule.Utils.MoviesDataModel;

public class LandingScreen extends AppCompatActivity {
     ViewModel viewModel;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        viewModel=ViewModelProviders.of(this).get(MoviesViewModel.class);
        ((MoviesViewModel) viewModel).getMoviesList().observe(this, new Observer<List<MoviesDataModel>>() {
            @Override
            public void onChanged(@Nullable List<MoviesDataModel> moviesDataModels) {
                MoviewsRecyclerAdapter weatherAdapter = new MoviewsRecyclerAdapter(moviesDataModels);
                recyclerView.setAdapter(weatherAdapter);
                //hiding the loading popUp view.
                Utils.loadingDialog(LandingScreen.this,false);
            }
        });
    }

    private void initViews() {
         Utils.loadingDialog(LandingScreen.this,true);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                llm.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
     }
    @Override
    protected void onResume() {
        super.onResume();

    }



}
