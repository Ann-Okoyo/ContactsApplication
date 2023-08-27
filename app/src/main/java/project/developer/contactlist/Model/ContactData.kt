package project.developer.contactlist.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "Contacts")
data class ContactData(
    @PrimaryKey(autoGenerate = true)
    var contactId: Int,
    val contactName: String,
    val phoneNumber: String,
    val emailAddress: String,
    val image: String,

    )
