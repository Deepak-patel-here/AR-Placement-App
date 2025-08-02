package com.deepakjetpackcompose.artestapp.ui.navigation

import kotlinx.serialization.Serializable

sealed class NavigationHelper {
    @Serializable
    object HOMESCREEN: NavigationHelper()
    @Serializable
    data class ARSCREEN(val model:String): NavigationHelper()
    @Serializable
    object APLHABETSCREEN: NavigationHelper()

}