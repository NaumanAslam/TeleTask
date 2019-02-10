package task.project.tele.assignment.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import task.project.tele.assignment.R;


public class DetailScreen extends AppCompatActivity {
    TextView tvDirector,tvDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //initialising the views.
        initViews();
    }
    private void initViews(){
        tvDesc=findViewById(R.id.textView2);
        tvDirector=findViewById(R.id.textView);
        setData();
    }
    private void setData(){
        if (getIntent().getExtras()!=null){
            tvDirector.setText("Directed by: "+getIntent().getStringExtra("_director"));
            tvDesc.setText(getIntent().getStringExtra("_desc"));

        }
    }
}
