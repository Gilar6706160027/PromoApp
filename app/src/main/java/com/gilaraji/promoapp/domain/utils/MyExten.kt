package com.gilaraji.promoapp.domain.utils

import com.google.gson.Gson


fun Any.toJson(): String = Gson().toJson(this)

