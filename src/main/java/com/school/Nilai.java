package com.school;

public class Nilai {

    private int id;
    private int siswaId;
    private int mataPelajaranId;
    private double nilai;

    // Konstruktor
    public Nilai(int id, int siswaId, int mataPelajaranId, double nilai) {
        this.id = id;
        this.siswaId = siswaId;
        this.mataPelajaranId = mataPelajaranId;
        this.nilai = nilai;
    }

    // Getter dan Setter untuk ID, siswaId, mataPelajaranId, dan nilai
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiswaId() {
        return siswaId;
    }

    public void setSiswaId(int siswaId) {
        this.siswaId = siswaId;
    }

    public int getMataPelajaranId() {
        return mataPelajaranId;
    }

    public void setMataPelajaranId(int mataPelajaranId) {
        this.mataPelajaranId = mataPelajaranId;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
}
