package ro.alexmamo.firestorepalm.domain.model

data class Question(
    var prompt: String? = null,
    var createBy: String? = null,
    var response: String? = null,
)