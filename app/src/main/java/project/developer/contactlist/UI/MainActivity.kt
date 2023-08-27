package project.developer.contactlist.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import project.developer.contactlist.Model.ContactData
import project.developer.contactlist.ViewModel.ContactsViewModel
import project.developer.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val contactViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fab.setOnClickListener {
            val intent=Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        contactViewModel.getContacts().observe(this, ::displayContacts)
        super.onResume()


    }


    private fun displayContacts(contactsList: List<ContactData>){
        val contactAdapter= NamesRvAdapter(contactsList,this)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactAdapter

    }




}