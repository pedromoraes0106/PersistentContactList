package br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.ContactViewModel
import br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.model.Operation
import br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.ui.composable.screen.ListScreen


@Composable
fun ListRoute(contactViewModel: ContactViewModel, modifier: Modifier = Modifier, onNavigate: () -> Unit){
    val contactList by contactViewModel.contactList.collectAsStateWithLifecycle()
    ListScreen(
        contactList = contactList,
        onViewContact = { contact ->
            contactViewModel.updateCurrentContactAndOperation(
                contact = contact,
                Operation.VIEW
            )
            onNavigate()
        },
        onEditContact = { contact ->
            contactViewModel.updateCurrentContactAndOperation(
                contact = contact,
                Operation.NEW_OR_EDIT
            )
            onNavigate()
        },
        onRemoveContact = { contact ->
            contactViewModel.removeContact(contact)
        },
        modifier = modifier
    )
}
