package com.school;

public class Kelas {

    private int id;
    private String namaKelas;

    // Konstruktor
    public Kelas(int id, String namaKelas) {
        this.id = id;
        this.namaKelas = namaKelas;
    }

    // Getter dan Setter untuk ID dan nama kelas
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
