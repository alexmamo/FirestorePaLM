package ro.alexmamo.firestorepalm.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ro.alexmamo.firestorepalm.core.HISTORY
import ro.alexmamo.firestorepalm.data.repository.ChatRepositoryImpl
import ro.alexmamo.firestorepalm.domain.repository.ChatRepository

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideQuestionsRef(): ChatRepository = ChatRepositoryImpl(
        questionsRef = Firebase.firestore.collection(HISTORY)
    )
}