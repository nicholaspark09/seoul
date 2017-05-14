package com.golfpinhunter.seoul.data

import android.app.Application
import com.golfpinhunter.seoul.BuildConfig
import com.golfpinhunter.seoul.di.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import java.util.concurrent.TimeUnit

/**
 * Created by nicholaspark on 5/14/17.
 */
@Module()
class DebugDataModule {


    // TODO Change the behavior to be settable
    @Provides
    @ApplicationScope
    fun provideNetworkBehavior(): NetworkBehavior {
        var behavior = NetworkBehavior.create()
        behavior.setDelay(1000, TimeUnit.MILLISECONDS)
        behavior.setFailurePercent(2)
        return behavior
    }

    @Provides
    @ApplicationScope
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return DataModule.createClient().addInterceptor(loggingInterceptor)
                .build()
    }

    @Provides
    @ApplicationScope
    fun provideMockRetrofit(retrofit: Retrofit, networkBehavior: NetworkBehavior): MockRetrofit {
        return MockRetrofit.Builder(retrofit).networkBehavior(networkBehavior).build()
    }
}