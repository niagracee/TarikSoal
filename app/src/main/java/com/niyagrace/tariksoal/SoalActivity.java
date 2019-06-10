package com.niyagrace.tariksoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.niyagrace.tariksoal.network.ApiServices;
import com.niyagrace.tariksoal.network.InitRetrofit;
import com.niyagrace.tariksoal.response.ListMateriItem;
import com.niyagrace.tariksoal.response.ListSoalItem;
import com.niyagrace.tariksoal.response.ResponseMateri;
import com.niyagrace.tariksoal.response.ResponseSoal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoalActivity extends AppCompatActivity {

    // Deklarasi Widget
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        // Inisialisasi Widget
        recyclerView = (RecyclerView) findViewById(R.id.rvListSoal);
        // RecyclerView harus pakai Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Eksekusi method
        tampilSoal();
    }

    private void tampilSoal() {
        ApiServices api = InitRetrofit.getInstance();
        // Siapkan request
        Call<ResponseSoal> materiCall = api.request_show_all_soal();
        // Kirim request
        materiCall.enqueue(new Callback<ResponseSoal>() {
            @Override
            public void onResponse(Call<ResponseSoal> call, Response<ResponseSoal> response) {
                // Pasikan response Sukses
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    // tampung data response body ke variable
                    List<ListSoalItem> data_listsoal = response.body().getListSoal();
                    AdapterSoal adapter = new AdapterSoal(SoalActivity.this, data_listsoal);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseSoal> call, Throwable t) {
                // print ke log jika Error
                t.printStackTrace();
            }
        });
    }
}
