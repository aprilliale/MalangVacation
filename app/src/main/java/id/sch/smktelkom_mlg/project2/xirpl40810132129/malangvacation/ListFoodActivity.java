package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.FoodAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Food;


public class ListFoodActivity extends AppCompatActivity {
    ArrayList<Food> mList = new ArrayList<>();
    FoodAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        setTitle("Food List");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerviewfood);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new FoodAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fileData();
    }

    private void fileData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.belanja);
        String[] arDeskripsi = resources.getStringArray(R.array.belanja_des);

        TypedArray a = resources.obtainTypedArray(R.array.gambar);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Food(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }
}
