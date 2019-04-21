package com.example.transporterapp.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.transporterapp.model.Job;
import com.example.transporterapp.model.JobList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobDetail {
  private TransporterService transporterService;


  public LiveData<List<Job>> getJobList() {
    final MutableLiveData<List<Job>> data = new MutableLiveData<>();

    transporterService.getJob().enqueue(new Callback<JobList>() {
      @Override
      public void onResponse(Call<JobList> call, Response<JobList> response) {
        JobList temp;
        temp = response.body();

        data.setValue(temp.getJobs());
      }
      @Override
      public void onFailure(Call<JobList> call, Throwable t) {
        data.setValue(null);
      }

      // Error handling will be explained in the next article …
    });

    return data;
  }
}
