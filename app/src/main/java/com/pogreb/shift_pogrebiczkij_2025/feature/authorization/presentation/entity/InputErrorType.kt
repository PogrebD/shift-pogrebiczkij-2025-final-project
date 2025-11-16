package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.entity

enum class InputErrorType {
    PASSWORDS_MISMATCH,
    INVALID_LOGIN_FORMAT,
    USER_NOT_FOUND,
    NONE;

    fun getErrorText(): String = when (this) {
        PASSWORDS_MISMATCH -> "Пароли не совпадают"
        INVALID_LOGIN_FORMAT -> "Только цифры и латинские буквы"
        USER_NOT_FOUND -> "Пользователь не найден"
        NONE -> ""
    }
}