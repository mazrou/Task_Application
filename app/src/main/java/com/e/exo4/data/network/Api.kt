package com.e.exo4.data.network

import com.e.exo4.data.Task
import com.e.exo4.ui.TacheN
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val  BASE_URL : String = "https://my-json-server.typicode.com/mazrou/Task_Application/"
interface Api {


    @GET("task")
    suspend fun getAll(
    ) : Response<ArrayList<TacheN>>



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