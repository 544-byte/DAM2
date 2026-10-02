package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.Alumno
import org.example.project.states.AlumnoS

class AlumnoVM : ViewModel() {
    private val _uiState = MutableStateFlow(AlumnoS())
    val uiState : StateFlow<AlumnoS> = _uiState.asStateFlow()

    fun añadirAlumno(){
        _uiState.update { current ->
            current.copy(alumnos = current.alumnos.plus(current.newAlumno).sortedBy { it.name })
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
