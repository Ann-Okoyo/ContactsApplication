
package project.developer.contactlist.repository


import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import project.developer.contactlist.DataBase.ContactDB
import project.developer.contactlist.Model.ContactData
import project.developer.contactlist.MyContactsApp

class ContactsRepository {
    val database = ContactDB.getDataBase(MyContactsApp.appContext)

    suspend fun saveContact(contact: ContactData){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contact)
        }
    }

    fun getDbContacts(): LiveData<List<ContactData>>{
        return database.contactDao().getAllContacts()
    }

    fun getContactById(contactId: Int): LiveData<ContactData>{
        return  database.contactDao().getContactById(contactId)
    }
}