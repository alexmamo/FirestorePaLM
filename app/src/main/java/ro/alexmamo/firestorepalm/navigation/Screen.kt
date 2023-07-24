package ro.alexmamo.firestorepalm.navigation

import ro.alexmamo.firestorepalm.core.CHAT_SCREEN_ROUTE
import ro.alexmamo.firestorepalm.core.REQUEST_NAME_SCREEN_ROUTE

sealed class Screen(val route: String) {
    object RequestNameScreen: Screen(REQUEST_NAME_SCREEN_ROUTE)
    object ChatScreen: Screen(CHAT_SCREEN_ROUTE)
}