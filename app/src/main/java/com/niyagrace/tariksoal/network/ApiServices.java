package com.niyagrace.tariksoal.network;

import com.niyagrace.tariksoal.response.ResponseMateri;
import com.niyagrace.tariksoal.response.ResponseSoal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("semuamateri")
    Call<ResponseMateri> request_show_all_materi();
    // <ModelData> nama_method()

    @GET("semuasoal")
    Call<ResponseSoal> request_show_all_soal();

}
