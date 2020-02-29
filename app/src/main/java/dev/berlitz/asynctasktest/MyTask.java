package dev.berlitz.asynctasktest;

import android.os.AsyncTask;

public class MyTask extends AsyncTask<Integer, Integer, String> {

    private AsyncTaskHandler<Integer, String> ctx;

    MyTask(AsyncTaskHandler<Integer, String> ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(Integer... integers) {
        Integer integer = integers[0];
        for (int i = 0; i < integer; i++) {
            try {
                Thread.sleep(1000);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "oi";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.ctx.handlePreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        ctx.handleProgress(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ctx.handlePostExecute(s);
    }
}
