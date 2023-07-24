package ro.alexmamo.firestorepalm.presentation.request_name.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ro.alexmamo.firestorepalm.R

@Composable
fun RequestNameTopBar() {
    TopAppBar (
        title = {
            Text(
                text = stringResource(
                    id = R.string.app_name
                )
            )
        }
    )
}