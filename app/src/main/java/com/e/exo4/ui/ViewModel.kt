package com.e.exo4.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.exo4.data.repository.TaskRepository
import com.e.exo4.utilite.Coroutines
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class TaskViewModel (
    private val repository : TaskRepository
): ViewModel()
{
    var _taskList = MutableLiveData<ArrayList<TacheN>?>()

    private lateinit var job : Job

    val taskList : LiveData<ArrayList<TacheN>?>
        get() =_taskList


    fun getAll() { _taskList.value = repository.getAll()}




    override fun onCleared() {
        if(::job.isInitialized){
            job.cancel()
        }
    }





}

