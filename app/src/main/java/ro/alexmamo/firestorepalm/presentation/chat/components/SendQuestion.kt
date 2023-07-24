package ro.alexmamo.firestorepalm.presentation.chat.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firestorepalm.components.ProgressBar
import ro.alexmamo.firestorepalm.core.Utils.Companion.print
import ro.alexmamo.firestorepalm.domain.model.Response.Failure
import ro.alexmamo.firestorepalm.domain.model.Response.Loading
import ro.alexmamo.firestorepalm.domain.model.Response.Success
import ro.alexmamo.firestorepalm.presentation.chat.ChatViewModel

@Composable
fun SendQuestion(
    viewModel: ChatViewModel = hiltViewModel()
) {
    when(val sendQuestionResponse = viewModel.sendQuestionResponse) {
        is Loading -> ProgressBar()
        is Success -> Unit
        is Failure -> print(sendQuestionResponse.e)
    }
}