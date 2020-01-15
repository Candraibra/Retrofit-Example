package com.candraibra.terserah;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.candraibra.terserah.service.ApiClient;
import com.candraibra.terserah.service.SoccerAPI;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static SoccerAPI apiClient = ApiClient.getClient().create(SoccerAPI.class);
    private List<LeaguesItem> leaguesItems = new ArrayList<>();
    private Adapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvLeague);
        mAdapter = new Adapter(this, leaguesItems);
        getLeagues(leaguesItems);
        initRv();

    }

    public void getLeagues(final List<LeaguesItem> leagues) {
        Call<LeagueResponse> leagueResponseCall = apiClient.getAllLeague();
        leagueResponseCall.enqueue(new Callback<LeagueResponse>() {
            @Override
            public void onResponse(@NotNull Call<LeagueResponse> call, @NotNull Response<LeagueResponse> response) {
                if (response.isSuccessful()) {
                    LeagueResponse leagueResponse = response.body();
                    if (leagueResponse != null && leagueResponse.getLeagues() != null) {
                        leagues.addAll(leagueResponse.getLeagues());
                        mAdapter.notifyDataSetChanged();
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<LeagueResponse> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getLeague()/Failure");
            }
        });
    }

    public void initRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }
}
