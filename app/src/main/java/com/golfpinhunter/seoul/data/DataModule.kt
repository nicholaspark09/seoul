package com.golfpinhunter.seoul.data

import android.app.Application
import android.content.res.Resources
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.golfpinhunter.seoul.BuildConfig
import com.golfpinhunter.seoul.di.ApplicationScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by nicholaspark on 5/10/17.
 */
@Module
class DataModule {

    companion object {
        @JvmStatic val SHARED_PREFERENCES = "seoul.preferences"
        @JvmStatic fun createClient() : OkHttpClient.Builder {
            return OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
        }
        @JvmStatic fun createApiClient(okHttpClient: OkHttpClient, interceptor: Interceptor) : OkHttpClient.Builder {
            return okHttpClient.newBuilder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .addInterceptor(interceptor)
        }
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
                .baseUrl(BuildConfig.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}