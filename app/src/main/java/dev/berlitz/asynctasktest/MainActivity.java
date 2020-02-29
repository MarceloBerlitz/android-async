package dev.berlitz.asynctasktest;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AsyncTaskHandler<Integer, String> {

    private boolean taskIsOn = false;

    private ProgressBar progressBar;
    private Integer progressMax = 10;
    private Switch taskSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(progressMax);

        taskSwitch = findViewById(R.id.switch2);
    }

    public void toggleAsyncTask(View view) {
        MyTask task = new MyTask(this);
        task.execute(progressMax);
    }

    @Override
    public void handleProgress(Integer... integers) {
        progressBar.setProgress(integers[0]);
    }

    @Override
    public void handlePostExecute(String result) {
        progressBar.setProgress(0);
        taskSwitch.setChecked(false);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handlePreExecute() {

    }
}