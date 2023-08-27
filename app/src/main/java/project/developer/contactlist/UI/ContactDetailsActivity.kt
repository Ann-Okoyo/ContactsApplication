package project.developer.contactlist.UI

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import project.developer.contactlist.Model.ContactData
import project.developer.contactlist.ViewModel.ContactsViewModel
import project.developer.contactlist.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    val viewModel: ContactsViewModel by viewModels()
    lateinit var binding: ActivityContactDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactId = intent.getIntExtra("CONTACT_ID", 0)
        viewModel.getContactById(contactId).observe(this, Observer {
            if (it != null) {
                displayContactDetails(it)
            } else {
                Toast.makeText(this, "Contact not found", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun displayContactDetails(contact: ContactData) {
        binding.tvNameDetails.text = contact.contactName
        binding.tvPhoneNumberDetails.text = contact.phoneNumber
        binding.tvEmailDetails.text = contact.emailAddress
    }
}