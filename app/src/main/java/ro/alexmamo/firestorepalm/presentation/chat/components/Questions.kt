package ro.alexmamo.firestorepalm.presentation.chat.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firestorepalm.components.ProgressBar
import ro.alexmamo.firestorepalm.core.Utils.Companion.print
import ro.alexmamo.firestorepalm.domain.model.Response.Failure
import ro.alexmamo.firestorepalm.domain.model.Response.Loading
import ro.alexmamo.firestorepalm.domain.model.Response.Success
import ro.alexmamo.firestorepalm.domain.repository.Questions
import ro.alexmamo.firestorepalm.presentation.chat.ChatViewModel

@Composable
fun Questions(
    viewModel: ChatViewModel = hiltViewModel(),
    chatContent: @Composable (questions: Questions) -> Unit
) {
    when(val questionsResponse = viewModel.questionsResponse) {
        is Loading -> ProgressBar()
        is Success -> chatContent(questionsResponse.data)
        is Failure -> print(questionsResponse.e)
    }
}