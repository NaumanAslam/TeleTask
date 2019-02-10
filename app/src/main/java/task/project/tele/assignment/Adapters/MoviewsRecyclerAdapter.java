package task.project.tele.assignment.Adapters;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Calendar;
import java.util.List;

import task.project.tele.assignment.Activities.DetailScreen;
 import task.project.tele.assignment.R;
import task.project.toodl.moviemodule.Utils.MoviesDataModel;

public class MoviewsRecyclerAdapter extends RecyclerView.Adapter<MoviewsRecyclerAdapter.MyViewHolder>   {
    Calendar calendar;
    private List<MoviesDataModel> _moviesDataList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvReleaseDate;
        public TextView resRating;

        public MyViewHolder(View view) {
            super(view);
            tvTitle =  view.findViewById(R.id.name);
            tvReleaseDate =  view.findViewById(R.id.release_date);
            tvReleaseDate.setTypeface(null, Typeface.BOLD);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(),DetailScreen.class);
                    intent.putExtra("_director",_moviesDataList.get(getLayoutPosition()).getDirector());
                    intent.putExtra("_desc",_moviesDataList.get(getLayoutPosition()).getDescription());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public MoviewsRecyclerAdapter(List<MoviesDataModel> weatherList) {
        this._moviesDataList = weatherList;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MoviesDataModel moviesDataModel = _moviesDataList.get(position);
        holder.tvTitle.setText(moviesDataModel.getTitle());
        holder.tvReleaseDate.setText(moviesDataModel.getReleaseDate()+"");
    }

    @Override
    public int getItemCount() {
        return _moviesDataList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_recyclerview_content,parent, false);
        calendar = Calendar.getInstance();
        return new MyViewHolder(v);
    }
}

