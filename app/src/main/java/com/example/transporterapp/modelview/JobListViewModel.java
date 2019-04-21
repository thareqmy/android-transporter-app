package com.example.transporterapp.modelview;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.transporterapp.model.Job;
import com.example.transporterapp.service.JobDetail;

import java.util.List;


import androidx.annotation.NonNull;

public class JobListViewModel extends AndroidViewModel {
  private final LiveData<List<Job>> jobListObservable;


  public JobListViewModel(@NonNull JobDetail jobDetail, @NonNull Application application) {
    super(application);

    // If any transformation is needed, this can be simply done by Transformations class ...
    jobListObservable = jobDetail.getJobList();
  }

  /**
   * Expose the LiveData Projects query so the UI can observe it.
   */
  public LiveData<List<Job>> getJobListObservable() {
    return jobListObservable;
  }


}
