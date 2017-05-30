package com.golfpinhunter.seoul.data

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Resources
import com.f2prateek.rx.preferences2.Preference
import com.f2prateek.rx.preferences2.RxSharedPreferences
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.golfpinhunter.seoul.BuildConfig
import com.golfpinhunter.seoul.data.oauth.OauthInterceptor
import com.golfpinhunter.seoul.di.AccessToken
import com.golfpinhunter.seoul.di.ApplicationScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by nicholaspark on 5/10/17.
 */
@Module
class DataModule {

    @Provides
    @ApplicationScope
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE)
    }

    @Provides
    @ApplicationScope
    fun provideRxSharedPreferences(prefs: SharedPreferences): RxSharedPreferences {
        return RxSharedPreferences.create(prefs)
    }

    @Provides
    @ApplicationScope
    @AccessToken
    fun provideAccessToken(prefs: RxSharedPreferences): Preference<String> {
        return prefs.getString("access_token")
    }

    @Provides
    @ApplicationScope
    fun provideGson(): Gson = Gson()

    @Provides
    @ApplicationScope
    fun provideResources(application: Application): Resources = application.resources

    @Provides
    @ApplicationScope
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().client(client)
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    companion object {
        val API_URL = BuildConfig.GITHUB_URL
        val SHARED_PREFERENCES = "seoul.preferences"
        val CACHE_SIZE = 50 * 1024 * 1024 // 50MB Disk Cache Size

        fun createClient(): OkHttpClient.Builder {
            return OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
        }

        fun createOkHttpClient(app: Application, interceptor: OauthInterceptor): OkHttpClient.Builder {
            val cacheDir = File(app.cacheDir, "http")
            val cache = Cache(cacheDir, CACHE_SIZE.toLong())
            return createClient()
                    .addNetworkInterceptor(StethoInterceptor())
                    .addInterceptor(interceptor)
                    .cache(cache)
        }
    }
}