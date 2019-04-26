package com.example.transporterapp.di;

import com.example.transporterapp.modelview.JobListViewModel;
import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

  @Subcomponent.Builder
  interface Builder {

    ViewModelSubComponent build();
  }

  JobListViewModel jobListViewModel();
}