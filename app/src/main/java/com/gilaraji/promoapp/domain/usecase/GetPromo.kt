package com.gilaraji.promoapp.domain.usecase

import com.gilaraji.promoapp.data.api.Resource
import com.gilaraji.promoapp.domain.abstraction.PromoRepository
import com.gilaraji.promoapp.domain.models.PromoModels

class GetPromo(
    private val repository: PromoRepository
) {
    suspend operator fun invoke(): Resource<List<PromoModels>> {
        return repository.getPromo()
    }
}