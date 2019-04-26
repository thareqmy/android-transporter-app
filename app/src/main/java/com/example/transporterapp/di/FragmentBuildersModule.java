package com.example.transporterapp.di;


import com.example.transporterapp.view.ui.SortJobFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
  @ContributesAndroidInjector
  abstract SortJobFragment contributeProjectListFragment();
}