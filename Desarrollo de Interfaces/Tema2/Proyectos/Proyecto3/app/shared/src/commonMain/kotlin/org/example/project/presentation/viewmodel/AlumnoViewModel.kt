package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.repository.AlumnoRepositoryImplementation
import org.example.project.domain.usecase.CreateAlumno
import org.example.project.domain.usecase.GetAlumnoList
import org.example.project.presentation.mapper.toState
import org.example.project.states.AlumnoState
import org.example.project.states.AlumnoUiState

class AlumnoViewModel(
    private val getAlumnoList: GetAlumnoList,
    private val createAlumno: CreateAlumno
) : ViewModel() {
    private val _uiState = MutableStateFlow(AlumnoUiState())
    val uiState : StateFlow<AlumnoUiState> = _uiState.asStateFlow()

    init {
        loadAlumnos()
    }

    fun loadAlumnos(){
        viewModelScope.launch {
            _uiState.update { current ->
                current.copy(alumnos = getAlumnoList().map { it.toState() })
            }
        }
    }

    fun añadirAlumno(){
        viewModelScope.launch {
            createAlumno(uiState.value.newAlumno)
            loadAlumnos()
        }
    }

    fun onNameChange(name : String){
        _uiState.update { it.copy(newAlumno = it.newAlumno.copy(name = name)) }
    }

    fun onTGradeChange(grade : Double){
        _uiState.update { it.copy(newAlumno = it.newAlumno.copy(grades = listOf(grade,it.newAlumno.grades[1]))) }
    }

    fun onPGradeChange(grade : Double){
        _uiState.update { it.copy(newAlumno = it.newAlumno.copy(grades = listOf(it.newAlumno.grades[0],grade))) }
    }

}
