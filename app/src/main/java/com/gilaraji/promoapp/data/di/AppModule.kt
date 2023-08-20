package com.gilaraji.promoapp.data.di


import android.annotation.SuppressLint
import android.app.Application
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.gilaraji.promoapp.data.api.ApiService
import com.gilaraji.promoapp.data.repository.PromoRepositoryImpl
import com.gilaraji.promoapp.domain.abstraction.PromoRepository
import com.gilaraji.promoapp.domain.usecase.GetPromo
import com.gilaraji.promoapp.domain.usecase.UsecasePromo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun OkHttpClient.Builder.insertInterceptors(
        app: Application,
    ) = apply {

        val logInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val chuckerInterceptor = ChuckerInterceptor.Builder(app)
            .collector(ChuckerCollector(app))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()

        addInterceptor(logInterceptor)
        addInterceptor(chuckerInterceptor)

    }

    private fun createHttpClient(app: Application) = OkHttpClient.Builder()
        .insertInterceptors(app)
        .retryOnConnectionFailure(true)
        .connectTimeout(40, TimeUnit.SECONDS)
        .writeTimeout(40, TimeUnit.SECONDS)
        .readTimeout(50, TimeUnit.SECONDS)
        .build()


    @SuppressLint("HardwareIds")
    @Singleton
    @Provides
    fun provideApiService(app: Application): ApiService {
        val client = createHttpClient(app)
        client.dispatcher.maxRequests = 20
        return createApiService(client)
    }

    private fun createApiService(client: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://content.digi46.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providePromoRepository(
        api: ApiService
    ) = PromoRepositoryImpl(api) as PromoRepository

    @Provides
    @Singleton
    fun provideUseCasePromo(repository: PromoRepository): UsecasePromo {
        return UsecasePromo(
            getPromo = GetPromo(repository)
        )
    }

}
