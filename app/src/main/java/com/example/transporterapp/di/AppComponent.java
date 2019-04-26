package com.example.transporterapp.di;

import android.app.Activity;
import android.app.Application;
import com.example.transporterapp.TransporterApplication;
import com.example.transporterapp.service.TransporterService;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    AndroidInjectionModule.class,
    AppModule.class,
    MainActivityModule.class
})
public interface AppComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder application(Application application);
    AppComponent build();
  }
  void inject(TransporterApplication transporterApplication);
}
