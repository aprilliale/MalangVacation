package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.HomeAdapter;

public class MainActivity extends AppCompatActivity implements HomeAdapter.IHomeAdapter {

    ImageButton maps, aboutus, vacation, food, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maps = (ImageButton) findViewById(R.id.maps);
        aboutus = (ImageButton) findViewById(R.id.aboutus);
        vacation = (ImageButton) findViewById(R.id.vacation);
        food = (ImageButton) findViewById(R.id.food);
        search = (ImageButton) findViewById(R.id.search);

        findViewById(R.id.food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFood();
            }
        });

        findViewById(R.id.vacation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVacation();
            }
        });

        findViewById(R.id.aboutus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

        findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch();
            }
        });
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
//
    }

    private void openSearch() {
        //intent diatas ini
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    private void openAbout() {
        Intent intent = new Intent(MainActivity.this, aboutfix.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    private void openVacation() {
        //intent diatas ini
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    private void openFood() {
        Intent intent = new Intent(MainActivity.this, ListFoodActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void doClick(int pos) {

    }
}
