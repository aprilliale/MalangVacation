package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.TempatAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.WisataAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Wisata;

public class ListWisataActivity extends AppCompatActivity implements WisataAdapter.IWisataAdapter {
    public static final String WISATA = "wisata";

    ArrayList<Wisata> mList = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFIlter = new ArrayList<>();
    ArrayList<Wisata> mListAll = new ArrayList<>();
    String mQuery;
    TempatAdapter mAdapter;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);
    }

    @Override
    public void doClick(int pos) {

    }
}
