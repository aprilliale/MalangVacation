package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model.Tempat;

public class DetailTempatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Tempat tempat = (Tempat) getIntent().getSerializableExtra(List.TEMPAT);
        setTitle(tempat.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFotoTempat);
        ivFoto.setImageURI(Uri.parse((tempat.foto)));
        TextView tvDeskripsi = (TextView) findViewById(R.id.deskripsitempat);
        tvDeskripsi.setText(tempat.deskripsi);
        TextView tvDetail = (TextView) findViewById(R.id.lokasitempat);
        tvDetail.setText(tempat.deskripsi);

    }
}
