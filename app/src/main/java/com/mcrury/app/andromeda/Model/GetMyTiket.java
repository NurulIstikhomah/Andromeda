package com.mcrury.app.andromeda.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMyTiket {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private List<MyTiket> result = null;

    /**
     *
     * @param result
     * @param status
     */
    public GetMyTiket(String status, List<MyTiket> result) {
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

    public GetMyTiket withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<MyTiket> getResult() {
        return result;
    }

    public void setResult(List<MyTiket> result) {
        this.result = result;
    }

    public GetMyTiket withResult(List<MyTiket> result) {
        this.result = result;
        return this;
    }

}
