package org.example.project.states

import org.example.project.models.UserHealth

data class UserHealthState(
    val userHealth: UserHealth? = UserHealth(60.0,1.70,9999)
)