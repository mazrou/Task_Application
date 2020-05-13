package com.e.exo4.data.repository

import com.e.exo4.data.network.Api
import com.e.exo4.data.network.SafeApiRequest
import com.e.exo4.exception.GetDataFromApiException
import com.e.exo4.ui.TacheN
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskRepository (
    private val api : Api
) : SafeApiRequest(){

      fun getAll()   : ArrayList<TacheN>? = runBlocking {  apiRequest { api.getAll() } }



}