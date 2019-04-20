package com.example.transporterapp.service;

import com.example.transporterapp.model.Job;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface TransporterService {
  String baseUrl = "http://5cac1d41c85e05001452eef0.mockapi.io/";

  @GET("/jobs")
  Call<List<Job>> getJob();


}

