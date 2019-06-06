package com.ynovaix.smartydays.model

data class Contact(
    val id: Int,
    val firstname: String,
    val lastname: String,
    val email: String,
    val address: String
) {
    fun checkIntegrity(): Boolean {
        var res = true
        if (firstname.trim().isEmpty() || lastname.trim().isEmpty()) {
            res = false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            res = false
        }
        return res
    }
}