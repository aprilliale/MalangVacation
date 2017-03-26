package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.R;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Tempat;

/**
 * Created by rongrong on 26/03/2017.
 */

public class TempatAdapter extends RecyclerView.Adapter<TempatAdapter.ViewHolder> {
    ArrayList<Tempat> tempatList;
    ITempatAdapter mITempatAdapter;

    public TempatAdapter(Context context, ArrayList<Tempat> tempatList) {
        this.tempatList = tempatList;
        mITempatAdapter = (ITempatAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tempat tempat = tempatList.get(position);
        holder.tvJudul.setText(tempat.judl);
        holder.tvDeskripsi.setText(tempat.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(tempat.foto));
    }

    @Override
    public int getItemCount() {
        if (tempatList != null)
            return tempatList.size();
        return 0;
    }

    public interface ITempatAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mITempatAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
