package ro.alexmamo.firestorepalm.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.firestorepalm.domain.model.Question
import ro.alexmamo.firestorepalm.domain.model.Response

typealias Questions = List<Question>
typealias QuestionsResponse = Response<Questions>
typealias SendQuestionResponse = Response<Boolean>

interface ChatRepository {
    fun getQuestionsFromFirestore(): Flow<QuestionsResponse>

    suspend fun sendQuestionToFirestore(name: String, question: String): SendQuestionResponse
}