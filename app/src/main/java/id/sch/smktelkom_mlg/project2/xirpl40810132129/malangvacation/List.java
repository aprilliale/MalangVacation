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
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.TempatAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Tempat;

public class List extends AppCompatActivity implements TempatAdapter.ITempatAdapter {

    public static final String TEMPAT = "tempat";

    ArrayList<Tempat> mList = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFIlter = new ArrayList<>();
    ArrayList<Tempat> mListAll = new ArrayList<>();
    String mQuery;
    TempatAdapter mAdapter;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("Tempat List");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new TempatAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbarTempat);
        setSupportActionBar(toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        fileData();
    }

    private void fileData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.belanja);
        String[] arDeskripsi = resources.getStringArray(R.array.belanja_des);

        TypedArray a = resources.obtainTypedArray(R.array.gambar_tempat);
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
            mList.add(new Tempat(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
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

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailTempatActivity.class);
        intent.putExtra(TEMPAT, mList.get(pos));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right_fast, R.anim.slide_out_left_fast);
    }

    //onbackpressed
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
