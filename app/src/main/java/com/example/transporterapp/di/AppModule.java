package com.example.transporterapp.di;


import androidx.lifecycle.ViewModelProvider;
import com.example.transporterapp.modelview.JobViewModelFactory;
import com.example.transporterapp.service.TransporterService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
  @Singleton
  @Provides
  TransporterService provideTransporterService() {
    return new Retrofit.Builder()
        .baseUrl(TransporterService.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TransporterService.class);
  }

  @Singleton
  @Provides
  ViewModelProvider.Factory provideViewModelFactory(
      ViewModelSubComponent.Builder viewModelSubComponent) {

    return new JobViewModelFactory(viewModelSubComponent.build());
  }
}
