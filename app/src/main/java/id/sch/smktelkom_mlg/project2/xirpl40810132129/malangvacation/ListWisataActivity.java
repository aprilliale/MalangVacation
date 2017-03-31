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

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.WisataAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Wisata;

public class ListWisataActivity extends AppCompatActivity implements WisataAdapter.IWisataAdapter {
    public static final String WISATA = "wisata";

    ArrayList<Wisata> mListWisata = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFIlter = new ArrayList<>();
    ArrayList<Wisata> mListAll = new ArrayList<>();
    String mQuery;
    WisataAdapter mWisata;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);
        setTitle("Tempat Wisata");
        RecyclerView recyclerWisata = (RecyclerView) findViewById(R.id.recyclerWisata);
        LinearLayoutManager layoutWisata = new LinearLayoutManager(this);
        recyclerWisata.setLayoutManager(layoutWisata);
        mWisata = new WisataAdapter(this, mListWisata);
        recyclerWisata.setAdapter(mWisata);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        filldata();
    }

    private void filldata() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.wisata);
        String[] arDeskripsi = resources.getStringArray(R.array.wisata_desc);
        String[] arDetail = resources.getStringArray(R.array.wisata_detail);

        TypedArray a = resources.obtainTypedArray(R.array.gambar_wisata);
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
            mListWisata.add(new Wisata(arJudul[i], arDeskripsi[i], arDetail[i], arFoto[i]));
        }
        mWisata.notifyDataSetChanged();
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
            mListAll.addAll(mListWisata);
            isFiltered = true;
        }

        mListWisata.clear();
        if (query == null || query.isEmpty()) {
            mListWisata.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFIlter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Wisata tempat = mListAll.get(i);
                if (tempat.judul.toLowerCase().contains(query) || tempat.deskripsi.toLowerCase().contains(query)) {
                    mListWisata.add(tempat);
                    mListMapFIlter.add(i);
                }
            }
        }
        mWisata.notifyDataSetChanged();
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
        Intent intent = new Intent(this, DetailWisataActivity.class);
        intent.putExtra(WISATA, mListWisata.get(pos));
        startActivity(intent);

    }
}
