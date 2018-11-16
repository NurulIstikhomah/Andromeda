package com.mcrury.app.andromeda.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTiket {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private List<Tiket> result = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public GetTiket() {
    }

    /**
     *
     * @param result
     * @param status
     */
    public GetTiket(String status, List<Tiket> result) {
        super();
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GetTiket withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Tiket> getResult() {
        return result;
    }

    public void setResult(List<Tiket> result) {
        this.result = result;
    }

    public GetTiket withResult(List<Tiket> result) {
        this.result = result;
        return this;
    }

}
