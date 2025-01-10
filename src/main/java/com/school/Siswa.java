package com.school;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Siswa {

    private final IntegerProperty id;
    private final StringProperty namaSiswa;
    private final StringProperty jurusan;
    private final StringProperty kelas;

    public Siswa(int id, String namaSiswa, String jurusan, String kelas) {
        this.id = new SimpleIntegerProperty(id);
        this.namaSiswa = new SimpleStringProperty(namaSiswa);
        this.jurusan = new SimpleStringProperty(jurusan);
        this.kelas = new SimpleStringProperty(kelas);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNamaSiswa() {
        return namaSiswa.get();
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa.set(namaSiswa);
    }

    public StringProperty namaSiswaProperty() {
        return namaSiswa;
    }

    public String getJurusan() {
        return jurusan.get();
    }

    public void setJurusan(String jurusan) {
        this.jurusan.set(jurusan);
    }

    public StringProperty jurusanProperty() {
        return jurusan;
    }

    public String getKelas() {
        return kelas.get();
    }

    public void setKelas(String kelas) {
        this.kelas.set(kelas);
    }

    public StringProperty kelasProperty() {
        return kelas;
    }
}
