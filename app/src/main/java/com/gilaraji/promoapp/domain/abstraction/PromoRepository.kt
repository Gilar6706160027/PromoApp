package com.gilaraji.promoapp.domain.abstraction

import com.gilaraji.promoapp.data.api.Resource
import com.gilaraji.promoapp.domain.models.PromoModels


interface PromoRepository {
    suspend fun getPromo(): Resource<List<PromoModels>>
}