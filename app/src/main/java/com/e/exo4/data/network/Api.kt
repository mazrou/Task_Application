package com.e.exo4.data.network

import com.e.exo4.data.Task
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val  BASE_URL : String = "som"
interface Api {


    @GET()
    suspend fun getAll(
        //@Query("nom du paramatre") npq : Any
    ) : Response<List<Task>>



    companion object {
        operator fun invoke() : Api{

            return  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(Api::class.java)

        }
    }
}