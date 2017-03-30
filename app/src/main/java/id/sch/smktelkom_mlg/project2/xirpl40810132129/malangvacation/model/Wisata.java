package id.sch.smktelkom_mlg.project2.xirpl40810132129.malangvacation.model;

import java.io.Serializable;

/**
 * Created by SUPER USER on 28/03/2017.
 */

public class Wisata implements Serializable {
    public String judul;
    public String deskripsi;
    public String foto;
    public String detail;


    public Wisata(String judul, String deskripsi, String detail, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.foto = foto;
    }
}
