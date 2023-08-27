package project.developer.contactlist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import project.developer.contactlist.Model.ContactData

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: ContactData)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<ContactData>>

    @Query("SELECT * FROM Contacts WHERE contactId= :contactId")
    fun getContactById(contactId:Int): LiveData<ContactData>


}