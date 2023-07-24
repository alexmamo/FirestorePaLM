package ro.alexmamo.firestorepalm.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FieldValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import ro.alexmamo.firestorepalm.core.ADDED_AT
import ro.alexmamo.firestorepalm.core.ADDED_BY
import ro.alexmamo.firestorepalm.core.PROMPT
import ro.alexmamo.firestorepalm.domain.model.Question
import ro.alexmamo.firestorepalm.domain.model.Response.Failure
import ro.alexmamo.firestorepalm.domain.model.Response.Success
import ro.alexmamo.firestorepalm.domain.repository.ChatRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepositoryImpl @Inject constructor(
    private val questionsRef: CollectionReference
) : ChatRepository {
    override fun getQuestionsFromFirestore() = callbackFlow {
        val snapshotListener = questionsRef.orderBy(ADDED_AT).addSnapshotListener { snapshot, e ->
            val questionsResponse = if (snapshot != null) {
                val questions = snapshot.toObjects(Question::class.java)
                Success(questions)
            } else {
                Failure(e)
            }
            trySend(questionsResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun sendQuestionToFirestore(name: String, question: String) = try {
        questionsRef.add(mapOf(
            ADDED_AT to FieldValue.serverTimestamp(),
            ADDED_BY to name,
            PROMPT to question
        )).await()
        Success(true)
    } catch (e: Exception) {
        Failure(e)
    }
}