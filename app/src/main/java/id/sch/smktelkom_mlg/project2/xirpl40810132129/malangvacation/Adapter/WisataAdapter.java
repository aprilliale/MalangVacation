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
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Wisata;

/**
 * Created by SUPER USER on 28/03/2017.
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {

    ArrayList<Wisata> wisataList;
    IWisataAdapter mIWisataAdapter;

    public WisataAdapter(Context context, ArrayList<Wisata> wisataList) {
        this.wisataList = wisataList;
        mIWisataAdapter = (IWisataAdapter) context;
    }

    @Override
    public WisataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.relative_wisata, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(WisataAdapter.ViewHolder holder, int position) {
        Wisata wisata = wisataList.get(position);
        holder.textWisata.setText(wisata.judul);
        holder.txtWisata.setText(wisata.deskripsi);
        holder.imgWisata.setImageURI(Uri.parse(wisata.foto));
    }

    @Override
    public int getItemCount() {
        if (wisataList != null)
            return wisataList.size();
        return 0;
    }

    public interface IWisataAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgWisata;
        TextView textWisata, txtWisata;

        public ViewHolder(View itemView) {
            super(itemView);
            imgWisata = (ImageView) itemView.findViewById(R.id.imageWisata);
            textWisata = (TextView) itemView.findViewById(R.id.textJudulWisata);
            txtWisata = (TextView) itemView.findViewById(R.id.textDeskripsiWisata);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIWisataAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
