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
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Food;

/**
 * Created by SUPER USER on 28/03/2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    ArrayList<Food> foodList;
    IFoodAdapter mIFoodAdapter;

    public FoodAdapter(Context context, ArrayList<Food> foodList) {
        this.foodList = foodList;
        mIFoodAdapter = (IFoodAdapter) context;
    }

    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_food, parent, false);
        FoodAdapter.ViewHolder vh = new FoodAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.tvJudul.setText(food.judul);
        holder.tvDeskripsi.setText(food.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(food.foto));
    }

    @Override
    public int getItemCount() {
        if (foodList != null)
            return foodList.size();
        return 0;
    }

    public interface IFoodAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageViewFood);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudulFood);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsiFood);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIFoodAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
