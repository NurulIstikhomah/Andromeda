package com.mcrury.app.andromeda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyTiket {

    @SerializedName("id_tiket")
    @Expose
    private String idTiket;
    @SerializedName("tujuan")
    @Expose
    private String tujuan;

    // Ada perubahan nama field di REST API
    @SerializedName("tgl_brgkt")
    @Expose
    private String tanggalBerangkat;
    @SerializedName("nama_kereta")
    @Expose
    private String namaKereta;

    // Menambahkan field baru: tglBeli tiket
    @SerializedName("tgl_beli")
    @Expose
    private String tglBeli;

    @SerializedName("harga_tiket")
    @Expose
    private String harga;

    /**
     *
     * @param tujuan
     * @param namaKereta
     * @param idTiket
     * @param tanggalBerangkat
     * @param tglBeli
     * @param harga
     */
    public MyTiket(String idTiket, String tujuan, String tanggalBerangkat, String namaKereta, String
            tglBeli, String harga) {
        super();
        this.idTiket = idTiket;
        this.tujuan = tujuan;
        this.tanggalBerangkat = tanggalBerangkat;
        this.namaKereta = namaKereta;
        this.tglBeli = tglBeli;
        this.harga = harga;
    }

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public MyTiket withIdTiket(String idTiket) {
        this.idTiket = idTiket;
        return this;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public MyTiket withTujuan(String tujuan) {
        this.tujuan = tujuan;
        return this;
    }

    public String getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public MyTiket withTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
        return this;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    public MyTiket withNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
        return this;
    }

    public String getTglBeli() {
        return tglBeli;
    }

    public void setTglBeli(String tglBeli) {
        this.tglBeli = tglBeli;
    }

    public MyTiket withTglBeli(String tglBeli) {
        this.tglBeli = tglBeli;
        return this;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public MyTiket withHarga(String harga) {
        this.harga = harga;
        return this;
    }

}