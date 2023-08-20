package com.gilaraji.promoapp.data.repository


import com.gilaraji.promoapp.data.api.ApiService
import com.gilaraji.promoapp.data.api.Resource
import com.gilaraji.promoapp.domain.abstraction.PromoRepository
import com.gilaraji.promoapp.domain.models.PromoModels
import javax.inject.Inject

class PromoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
): PromoRepository {

    override suspend fun getPromo(): Resource<List<PromoModels>> {
        return try {
            val response = apiService.getDataPage()
            if (response.isSuccessful) {
                val userResponse = response.body()
                Resource.success(userResponse)
            } else {
                Resource.error("Data failed")
            }
        } catch (e: Exception) {
            Resource.error(e.localizedMessage ?: "Unknown error occurred")
        }
    }
}