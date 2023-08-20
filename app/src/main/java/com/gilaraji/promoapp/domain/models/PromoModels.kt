package com.gilaraji.promoapp.domain.models

import com.google.gson.annotations.SerializedName

data class PromoModels(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("Title") var Title: String? = null,
    @SerializedName("published_at") var publishedAt: String? = null,
    @SerializedName("created_at") var created_at: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("name_promo") var namePromo: String? = null,
    @SerializedName("desc_promo") var descPromo: String? = null,
    @SerializedName("nama") var nama: String? = null,
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null,
    @SerializedName("alt") var alt: String? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("lokasi") var lokasi: String? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("img") var img: Img? = Img()
)


data class Img(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("alternativeText") var alternativeText: String? = null,
    @SerializedName("caption") var caption: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("formats") var formats: Formats? = Formats(),
    @SerializedName("hash") var hash: String? = null,
    @SerializedName("ext") var ext: String? = null,
    @SerializedName("mime") var mime: String? = null,
    @SerializedName("size") var size: Double? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("previewUrl") var previewUrl: String? = null,
    @SerializedName("provider") var provider: String? = null,
    @SerializedName("provider_metadata") var providerMetadata: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null

)

data class Small(

    @SerializedName("ext") var ext: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("hash") var hash: String? = null,
    @SerializedName("mime") var mime: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("path") var path: String? = null,
    @SerializedName("size") var size: Double? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null

)

data class Medium(

    @SerializedName("ext") var ext: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("hash") var hash: String? = null,
    @SerializedName("mime") var mime: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("path") var path: String? = null,
    @SerializedName("size") var size: Double? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null

)


data class Thumbnail(

    @SerializedName("ext") var ext: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("hash") var hash: String? = null,
    @SerializedName("mime") var mime: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("path") var path: String? = null,
    @SerializedName("size") var size: Double? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null

)

data class Formats(

    @SerializedName("small") var small: Small? = Small(),
    @SerializedName("medium") var medium: Medium? = Medium(),
    @SerializedName("thumbnail") var thumbnail: Thumbnail? = Thumbnail()

)