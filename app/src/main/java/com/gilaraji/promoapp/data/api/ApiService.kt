package com.gilaraji.promoapp.data.api

import com.gilaraji.promoapp.domain.models.PromoModels
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("promos")
    suspend fun getDataPage(
    ): Response<List<PromoModels>>
}

