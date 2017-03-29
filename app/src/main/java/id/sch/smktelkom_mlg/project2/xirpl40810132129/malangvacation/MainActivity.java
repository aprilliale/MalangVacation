package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.HomeAdapter;
import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Home;

public class MainActivity extends AppCompatActivity implements HomeAdapter.IHomeAdapter {

    public static final String HOME = "home";

    ArrayList<Home> mListHome = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFIlter = new ArrayList<>();
    ArrayList<Home> mListAll = new ArrayList<>();
    String mQuery;
    HomeAdapter mAdapterHome;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Malang");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerHome);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapterHome = new HomeAdapter(this, mListHome);
        recyclerView.setAdapter(mAdapterHome);

        fileData();
//        findViewById(R.id.buttonAngkot).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, List.class));
//            }
//        });
//
//        findViewById(R.id.buttonInfo).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, ListFoodActivity.class));
//
//            }
//
//        });
//        findViewById(R.id.buttonkontol).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, ListWisataActivity.class));
//
//            }
//
//        });

    }

    private void fileData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.homee);
        TypedArray a = resources.obtainTypedArray(R.array.gambar_home);
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
            mListHome.add(new Home(arJudul[i], arFoto[i]));
        }
        mAdapterHome.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {

    }
}
