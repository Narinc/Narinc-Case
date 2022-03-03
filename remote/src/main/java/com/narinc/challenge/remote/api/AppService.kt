package com.narinc.challenge.remote.api

import com.narinc.challenge.remote.models.response.HomePageResponse
import retrofit2.http.GET

interface AppService {
    @GET("files/MobileInterviewProjectData.json")
    suspend fun getData(): HomePageResponse
}
