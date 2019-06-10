package com.niyagrace.tariksoal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.niyagrace.tariksoal.response.ListSoalItem;

import java.util.List;

public class AdapterSoal extends RecyclerView.Adapter<AdapterSoal.MyViewHolder> {
    // Buat Global variable untuk manampung context
    Context context;
//    List<ListMateriItem> materi;
    List<ListSoalItem> soal;
    public AdapterSoal(Context context, List<ListSoalItem> data_listsoal) {
        // Inisialisasi
        this.context = context;
        this.soal = data_listsoal;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.soal_item, parent, false);

        // Hubungkan dengan MyViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Set widget
//        holder.tvJudul.setText(soal.get(position).getJudul());
        holder.tvNomor.setText(soal.get(position).getNoSoal());
        holder.tvSoal.setText(soal.get(position).getSoal());
        holder.tvjawab1.setText(soal.get(position).getJawab1());
        holder.tvjawab2.setText(soal.get(position).getJawab2());
        holder.tvjawab3.setText(soal.get(position).getJawab3());
        holder.tvjawab4.setText(soal.get(position).getJawab3());


        // Event klik ketika item list nya di klik
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Mulai activity Detail
//                Intent varIntent = new Intent(context, SoalActivity.class);
//                // sisipkan data ke intent
////                varIntent.putExtra("judul_materi", soal.get(position).getMateri());
////                varIntent.putExtra("no_soal", soal.get(position).getNoSoal());
////                varIntent.putExtra("soal", soal.get(position).getSoal());
////                varIntent.putExtra("jawab1", soal.get(position).getJawab1());
////                varIntent.putExtra("jawab2", soal.get(position).getJawab2());
////                varIntent.putExtra("jawab3", soal.get(position).getJawab3());
////                varIntent.putExtra("jawab4", soal.get(position).getJawab4());
//
//                // method startActivity cma bisa di pake di activity/fragment
//                // jadi harus masuk ke context dulu
//                context.startActivity(varIntent);
//            }
//        });
    }
    // Menentukan Jumlah item yang tampil
    @Override
    public int getItemCount() {
        return soal
                .size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi widget
        TextView tvJudul, tvMateri, tvNomor, tvSoal, tvjawab1,tvjawab2, tvjawab3,tvjawab4;
        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
//            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvMateri = (TextView) itemView.findViewById(R.id.tvMateri);
            tvNomor = (TextView) itemView.findViewById(R.id.tvNomor);
            tvSoal = (TextView) itemView.findViewById(R.id.tvSoal);
            tvjawab1 = (TextView) itemView.findViewById(R.id.tvjawab1);
            tvjawab2 = (TextView) itemView.findViewById(R.id.tvjawab2);
            tvjawab3 = (TextView) itemView.findViewById(R.id.tvjawab3);
            tvjawab4 = (TextView) itemView.findViewById(R.id.tvjawab4);
        }
    }
}
