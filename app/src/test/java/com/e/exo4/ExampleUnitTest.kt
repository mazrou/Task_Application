package com.e.exo4

import com.e.exo4.data.network.Api
import com.e.exo4.data.repository.TaskRepository
import com.e.exo4.ui.TaskViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun getFromApi() {
        val repository  = TaskRepository(Api.invoke())
        assertEquals("Post 1",repository.getAll()!![0].title)
    }

    @Test
    fun theViewModelTest(){
        val repository  = TaskRepository(Api.invoke())
        val viewModel = TaskViewModel(repository)
        viewModel.getAll()
        assertEquals("Post 1" , viewModel.taskList.value!![0].title)

    }
}
