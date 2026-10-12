package br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.ui.composable.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.model.Contact
import br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.model.Operation
import br.edu.ifsp.scl.prdm.sc304775x.persistentcontactlist.ui.theme.PersistentContactListTheme

@Composable
fun ContactScreen(contact: Contact, operation: Operation, modifier: Modifier = Modifier, onSaveAndQuit: (Contact) -> Unit) {
    var currentContact by rememberSaveable { mutableStateOf(contact) }
    var idFieldsEnabled = operation == Operation.NEW_OR_EDIT
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = currentContact.name,
            label = { Text(text = "Name") },
            onValueChange = {
                currentContact = currentContact.copy(name = it)
            },
            enabled = idFieldsEnabled,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = currentContact.address,
            label = { Text(text = "Address") },
            onValueChange = {
                currentContact = currentContact.copy(address = it)
            },
            enabled = idFieldsEnabled,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = currentContact.phone,
            label = { Text(text = "Phone") },
            onValueChange = {
                currentContact = currentContact.copy(phone = it)
            },
            enabled = idFieldsEnabled,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = currentContact.email,
            label = { Text(text = "Email") },
            onValueChange = {
                currentContact = currentContact.copy(email = it)
            },
            enabled = idFieldsEnabled,
            modifier = Modifier.fillMaxWidth()
        )

        if(idFieldsEnabled) {
            Button(
                onClick = {
                    onSaveAndQuit(currentContact)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Save and quit")
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ContactScreenPreview() {
    PersistentContactListTheme {
        ContactScreen(
            contact = Contact(),
            operation = Operation.VIEW
        ) { }
    }
}