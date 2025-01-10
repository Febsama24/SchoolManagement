package com.school;

public class Jurusan {

    private int id;
    private String namaJurusan;

    // Konstruktor
    public Jurusan(int id, String namaJurusan) {
        this.id = id;
        this.namaJurusan = namaJurusan;
    }

    // Getter dan Setter untuk ID dan nama jurusan
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }
}
