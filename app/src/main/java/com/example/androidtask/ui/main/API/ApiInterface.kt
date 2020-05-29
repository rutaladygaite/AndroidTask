package com.example.androidtask.ui.main.API

import com.example.androidtask.ui.main.Authentification.AuthResponse
import com.example.androidtask.ui.main.Authentification.SafeApiRequest
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    //Class that uses Post and Get requests

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("/v1/tokens")
    suspend fun userLogin(
        @Field("username") username: String?,
        @Field("password") password: String?
    ) : Response<AuthResponse>

    @Headers("Content-Type: text/xml")
    @FormUrlEncoded
    @GET("/v1/tokens")
    fun getUser(
        @Query("Authorization") authorizationKey: String?,  // authentication header
        @Query("UserID") name: String?
    )

    companion object{
        operator fun invoke(instance: Any): ApiInterface{
            val okkHttpclient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://playground.tesonet.lt")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }
}

