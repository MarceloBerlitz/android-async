package dev.berlitz.asynctasktest;

public interface AsyncTaskHandler<Progress, Result> {

    void handleProgress(Progress... progress);

    void handlePostExecute(Result result);

    void handlePreExecute();

}
