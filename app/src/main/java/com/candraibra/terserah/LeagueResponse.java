package com.candraibra.terserah;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LeagueResponse {

    @SerializedName("leagues")
    private List<LeaguesItem> leagues;

    public List<LeaguesItem> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<LeaguesItem> leagues) {
        this.leagues = leagues;
    }

    @NotNull
    @Override
    public String toString() {
        return
                "LeagueResponse{" +
                        "leagues = '" + leagues + '\'' +
                        "}";
    }
}