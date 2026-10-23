package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.data.repository.BasicRepositoryImplement
import org.example.project.domain.repository.BasicRepository
import org.example.project.domain.usecase.GetBasicListItems
import org.example.project.viewModels.BasicViewModel
import org.example.project.views.BaseScreen

@Composable
fun App() {
    MaterialTheme {
        val viewModel: BasicViewModel = viewModel {
            var repository : BasicRepository = BasicRepositoryImplement()
            var getBasicListItems : GetBasicListItems = GetBasicListItems(repository)
            BasicViewModel(getBasicListItems)
        }
        BaseScreen(viewModel = viewModel)
    }
}