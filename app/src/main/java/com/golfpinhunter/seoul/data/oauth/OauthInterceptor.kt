package com.golfpinhunter.seoul.data.oauth

import com.f2prateek.rx.preferences2.Preference
import com.golfpinhunter.seoul.di.AccessToken
import com.golfpinhunter.seoul.di.ApplicationScope
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

/**
 * Created by nicholaspark on 5/29/17.
 */
@ApplicationScope
class OauthInterceptor
@Inject
constructor(@AccessToken private val accessToken: Preference<String>) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if (accessToken.isSet) {
            builder.header("Authorization", "token " + accessToken.get()!!)
        }

        return chain.proceed(builder.build())
    }
}