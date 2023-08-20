package com.gilaraji.promoapp.presentation.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilaraji.promoapp.data.api.Resource
import com.gilaraji.promoapp.domain.models.PromoModels
import com.gilaraji.promoapp.domain.usecase.UsecasePromo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(
    private val usecasePromo: UsecasePromo) : ViewModel() {

    fun getData(): LiveData<Resource<List<PromoModels>>> {
        val dataResult = MutableLiveData<Resource<List<PromoModels>>>()
        dataResult.value = Resource.loading()

        viewModelScope.launch {
            try {
                val resource = usecasePromo.getPromo.invoke()
                dataResult.value = resource
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: "Unknown error occurred"
                dataResult.value = Resource.error(errorMessage)
            }
        }
        return dataResult
    }


}