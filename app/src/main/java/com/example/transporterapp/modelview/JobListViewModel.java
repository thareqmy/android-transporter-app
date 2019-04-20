package com.example.transporterapp.modelview;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import com.example.transporterapp.model.Job;
import com.example.transporterapp.service.JobDetail;
import java.util.List;

public class JobListViewModel {
  private final LiveData<List<Job>> jobListObservable;

  public JobListViewModel(Application application) {
    super(application);

    // If any transformation is needed, this can be simply done by Transformations class ...
    jobListObservable = JobDetail.getJobList();
  }

  /**
   * Expose the LiveData Projects query so the UI can observe it.
   */
  public LiveData<List<Job>> getJobListObservable() {
    return jobListObservable;
  }


}
