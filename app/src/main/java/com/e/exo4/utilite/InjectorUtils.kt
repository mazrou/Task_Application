package solutus.coronawatch.utilities

import com.e.exo4.data.network.Api
import com.e.exo4.data.repository.TaskRepository
import com.e.exo4.ui.TaskViewModelFactory

object InjectorUtils {

    fun provideVideosViewModelFactory() : TaskViewModelFactory {
        val videosRepository = TaskRepository(Api())
        return TaskViewModelFactory(videosRepository)
    }
}