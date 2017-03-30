package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.FoodAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Food;


public class ListFoodActivity extends AppCompatActivity implements FoodAdapter.IFoodAdapter {

    public static final String FOOD = "food";

    ArrayList<Food> mListFood = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFIlter = new ArrayList<>();
    ArrayList<Food> mListAll = new ArrayList<>();
    String mQuery;
    FoodAdapter mAdapterFood;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        setTitle("Food List");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerFood);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapterFood = new FoodAdapter(this, mListFood);
        recyclerView.setAdapter(mAdapterFood);

        fileData();
    }

    private void fileData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.foody);
        String[] arDeskripsi = resources.getStringArray(R.array.foody_desc);

        TypedArray a = resources.obtainTypedArray(R.array.gambar_food);
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
            mListFood.add(new Food(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapterFood.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return false;
            }
        });
        return true;
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mListFood);
            isFiltered = true;
        }

        mListFood.clear();
        if (query == null || query.isEmpty()) {
            mListFood.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFIlter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Food food = mListAll.get(i);
                if (food.judul.toLowerCase().contains(query) || food.deskripsi.toLowerCase().contains(query)) {
                    mListFood.add(food);
                    mListMapFIlter.add(i);
                }
            }
        }
        mAdapterFood.notifyDataSetChanged();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailFoodActivity.class);
        intent.putExtra(FOOD, mListFood.get(pos));
        startActivity(intent);
    }

}
