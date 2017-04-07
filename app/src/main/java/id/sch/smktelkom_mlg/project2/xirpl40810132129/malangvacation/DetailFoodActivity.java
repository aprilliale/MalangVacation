package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Food;

public class DetailFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Food food = (Food) getIntent().getSerializableExtra(ListFoodActivity.FOOD);
        setTitle(food.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFotoFood);
        ivFoto.setImageURI(Uri.parse((food.foto)));
        TextView tvDeskripsi = (TextView) findViewById(R.id.deskripsifood);
        tvDeskripsi.setText(food.deskripsi);
        TextView tvDetail = (TextView) findViewById(R.id.lokasifood);
        tvDetail.setText(food.detail);

    }

    //onbackpressed
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right_fast, R.anim.slide_out_left_fast);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
