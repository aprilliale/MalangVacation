package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Wisata;

public class DetailWisataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Wisata wisata = (Wisata) getIntent().getSerializableExtra(ListWisataActivity.WISATA);
        setTitle(wisata.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFotoWisata);
        ivFoto.setImageURI(Uri.parse((wisata.foto)));
        TextView tvDeskripsi = (TextView) findViewById(R.id.deskripsiwisata);
        tvDeskripsi.setText(wisata.deskripsi);
        TextView tvDetail = (TextView) findViewById(R.id.lokasiwisata);
        tvDetail.setText(wisata.detail);
    }
}
