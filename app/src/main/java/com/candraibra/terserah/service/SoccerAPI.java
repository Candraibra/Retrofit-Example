/*
 * *
 *  * Created by Candra Ibra Sanie on 12/5/19 7:02 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/5/19 7:01 AM
 *
 */

package com.candraibra.terserah.service;

import com.candraibra.terserah.LeagueResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerAPI {

    @GET("all_leagues.php")
    Call<LeagueResponse> getAllLeague();

}
