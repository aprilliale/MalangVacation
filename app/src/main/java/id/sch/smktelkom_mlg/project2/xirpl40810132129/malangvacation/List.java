package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.TempatAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Tempat;

public class List extends AppCompatActivity implements TempatAdapter.ITempatAdapter {

    public static final String ANGKOT = "angkot";

    ArrayList<Tempat> mList = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFIlter = new ArrayList<>();
    ArrayList<Tempat> mListAll = new ArrayList<>();
    String mQuery;
    TempatAdapter mAdapter;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("Tempat List");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new TempatAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fileData();
    }

    private void fileData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.belanja);
        String[] arDeskripsi = resources.getStringArray(R.array.belanja_des);

    }

    @Override
    public void doClick(int pos) {

    }
}
