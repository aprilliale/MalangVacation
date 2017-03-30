package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton maps, aboutus, vacation, food, places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maps = (ImageButton) findViewById(R.id.maps);
        aboutus = (ImageButton) findViewById(R.id.aboutus);
        vacation = (ImageButton) findViewById(R.id.vacation);
        food = (ImageButton) findViewById(R.id.food);
        places = (ImageButton) findViewById(R.id.places);

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

        findViewById(R.id.places).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaces();
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

    private void openPlaces() {
        Intent intent = new Intent(MainActivity.this, List.class);
        startActivity(intent);
    }

    private void openAbout() {
        Intent intent = new Intent(MainActivity.this, aboutfix.class);
        startActivity(intent);
    }

    private void openVacation() {
        Intent intent = new Intent(MainActivity.this, ListWisataActivity.class);
        startActivity(intent);

    }

    private void openFood() {
        Intent intent = new Intent(MainActivity.this, ListFoodActivity.class);
        startActivity(intent);
    }


}
