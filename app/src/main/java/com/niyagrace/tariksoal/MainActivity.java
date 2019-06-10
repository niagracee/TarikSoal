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

public class MainActivity extends AppCompatActivity {

    // Deklarasi Widget
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inisialisasi Widget
        recyclerView = (RecyclerView) findViewById(R.id.rvListMateri);
        // RecyclerView harus pakai Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Eksekusi method
        tampilMateri();
    }

    private void tampilMateri() {
        ApiServices api = InitRetrofit.getInstance();
        // Siapkan request
        Call<ResponseMateri> materiCall = api.request_show_all_materi();
        // Kirim request
        materiCall.enqueue(new Callback<ResponseMateri>() {
            @Override
            public void onResponse(Call<ResponseMateri> call, Response<ResponseMateri> response) {
                // Pasikan response Sukses
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    // tampung data response body ke variable
                    List<ListMateriItem> data_listmateri = response.body().getListMateri();
                    AdapterMateri adapter = new AdapterMateri(MainActivity.this, data_listmateri);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseMateri> call, Throwable t) {
                // print ke log jika Error
                t.printStackTrace();
            }
        });
    }
}
