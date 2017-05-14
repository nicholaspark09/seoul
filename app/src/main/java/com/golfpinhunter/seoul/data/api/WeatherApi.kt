package com.golfpinhunter.seoul.data.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by nicholaspark on 5/14/17.
 */
interface WeatherApi {

    @GET("location/search")
    fun searchWeather(@Query("query") query: String): Observable<Response<ResponseBody>>

    @GET("location/{woeid}")
    fun searchById(@Path("woeid") id: String): Observable<Response<ResponseBody>>
}