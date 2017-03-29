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
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Home;

/**
 * Created by rongrong on 29/03/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    ArrayList<Home> homeList;
    IHomeAdapter mIHomeAdapter;

    public HomeAdapter(Context context, ArrayList<Home> homelist) {
        this.homeList = homelist;
        mIHomeAdapter = (IHomeAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Home home = homeList.get(position);
        holder.Textvw.setText(home.judul);
        holder.image.setImageURI(Uri.parse(home.foto));
    }

    @Override
    public int getItemCount() {
        if (homeList != null)
            return homeList.size();
        return 0;
    }

    public interface IHomeAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView Textvw;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageHome);
            Textvw = (TextView) itemView.findViewById(R.id.textJudul);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHomeAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
