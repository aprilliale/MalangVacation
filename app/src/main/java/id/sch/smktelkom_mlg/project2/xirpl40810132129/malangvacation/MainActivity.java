package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.Adapter.HomeAdapter;

public class MainActivity extends AppCompatActivity implements HomeAdapter.IHomeAdapter {

    ImageButton button1, button2, button3, button4, button5;

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
//
    }

    @Override
    public void doClick(int pos) {

    }
}
