package com.mcrury.app.andromeda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tiket {

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

    /**
     *
     * @param tujuan
     * @param namaKereta
     * @param idTiket
     * @param tanggalBerangkat
     */
    public Tiket(String idTiket, String tujuan, String tanggalBerangkat, String namaKereta) {
        super();
        this.idTiket = idTiket;
        this.tujuan = tujuan;
        this.tanggalBerangkat = tanggalBerangkat;
        this.namaKereta = namaKereta;
    }

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public Tiket withIdTiket(String idTiket) {
        this.idTiket = idTiket;
        return this;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Tiket withTujuan(String tujuan) {
        this.tujuan = tujuan;
        return this;
    }

    public String getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public Tiket withTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
        return this;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    public Tiket withNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
        return this;
    }

}
