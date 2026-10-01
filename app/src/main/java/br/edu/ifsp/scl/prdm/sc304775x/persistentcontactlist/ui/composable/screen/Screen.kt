package br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.ui.composable.screen

sealed class Screen (val route: String) {
    data object List: Screen("list_screen")
    data object Contact: Screen("contact_screen")
}