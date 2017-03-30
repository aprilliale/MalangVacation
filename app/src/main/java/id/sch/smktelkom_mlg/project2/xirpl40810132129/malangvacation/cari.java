package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.FoodAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.TempatAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.WisataAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Food;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Tempat;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Wisata;

public class cari extends AppCompatActivity {

    ArrayList<Tempat> mList = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFIlter = new ArrayList<>();
    ArrayList<Tempat> mListAll = new ArrayList<>();
    String mQuery;
    TempatAdapter mAdapter;

    ArrayList<Food> mListFood = new ArrayList<>();
    boolean isFilteredFood;
    ArrayList<Integer> mListMapFIlterFood = new ArrayList<>();
    ArrayList<Food> mListAllFood = new ArrayList<>();
    String mQueryFood;
    FoodAdapter mAdapterFood;

    ArrayList<Wisata> mListWisata = new ArrayList<>();
    boolean isFilteredWisata;
    ArrayList<Integer> mListMapFIlterWisata = new ArrayList<>();
    ArrayList<Wisata> mListAllWisata = new ArrayList<>();
    String mQueryWisata;
    WisataAdapter mWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);
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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQueryFood = newText.toLowerCase();
                doFil(mQueryFood);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQueryWisata = newText.toLowerCase();
                doFilte(mQueryWisata);
                return false;
            }
        });

        return true;
    }

    private void doFilte(String queryWisata) {
        if (!isFilteredWisata) {
            mListAllWisata.clear();
            mListAllWisata.addAll(mListWisata);
            isFilteredWisata = true;
        }

        mListWisata.clear();
        if (queryWisata == null || queryWisata.isEmpty()) {
            mListWisata.addAll(mListAllWisata);
            isFilteredWisata = false;
        } else {
            mListMapFIlterWisata.clear();
            for (int i = 0; i < mListAllWisata.size(); i++) {
                Wisata tempat = mListAllWisata.get(i);
                if (tempat.judul.toLowerCase().contains(queryWisata) || tempat.deskripsi.toLowerCase().contains(queryWisata)) {
                    mListWisata.add(tempat);
                    mListMapFIlterWisata.add(i);
                }
            }
        }
        mWisata.notifyDataSetChanged();
    }

    private void doFil(String queryFood) {
        if (!isFilteredFood) {
            mListAllFood.clear();
            mListAllFood.addAll(mListFood);
            isFilteredFood = true;
        }

        mListFood.clear();
        if (queryFood == null || queryFood.isEmpty()) {
            mListFood.addAll(mListAllFood);
            isFilteredFood = false;
        } else {
            mListMapFIlterFood.clear();
            for (int i = 0; i < mListAllFood.size(); i++) {
                Food food = mListAllFood.get(i);
                if (food.judul.toLowerCase().contains(queryFood) || food.deskripsi.toLowerCase().contains(queryFood)) {
                    mListFood.add(food);
                    mListMapFIlterFood.add(i);
                }
            }
        }
        mAdapterFood.notifyDataSetChanged();
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }

        mList.clear();
        if (query == null || query.isEmpty()) {
            mList.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFIlter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Tempat tempat = mListAll.get(i);
                if (tempat.judul.toLowerCase().contains(query) || tempat.deskripsi.toLowerCase().contains(query)) {
                    mList.add(tempat);
                    mListMapFIlter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
