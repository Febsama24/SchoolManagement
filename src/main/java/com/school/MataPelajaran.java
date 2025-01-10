package com.school;

public class MataPelajaran {

    private int id;
    private String namaMapel;

    // Konstruktor
    public MataPelajaran(int id, String namaMapel) {
        this.id = id;
        this.namaMapel = namaMapel;
    }

    // Getter dan Setter untuk ID dan nama mata pelajaran
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaMapel() {
        return namaMapel;
    }

    public void setNamaMapel(String namaMapel) {
        this.namaMapel = namaMapel;
    }
}
