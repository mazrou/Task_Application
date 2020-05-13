package com.e.exo4.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.exo4.data.repository.TaskRepository

/**
 *  This class is for passing  the VideosRepository to the VideoFragment
 *  when we create the instance of the VideoViewModel
 */

class TaskViewModelFactory(
    private val repository: TaskRepository
   ) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TaskViewModel(repository) as T
    }

}