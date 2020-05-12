package com.e.exo4.data.repository

import com.e.exo4.data.network.Api
import com.e.exo4.data.network.SafeApiRequest

class TaskRepository (
    private val api : Api
) : SafeApiRequest(){

    suspend fun getAll() = apiRequest { api.getAll() }

}