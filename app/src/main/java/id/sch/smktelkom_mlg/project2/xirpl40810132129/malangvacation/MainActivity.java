package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

    @Override
    public void doClick(int pos) {

    }
}
