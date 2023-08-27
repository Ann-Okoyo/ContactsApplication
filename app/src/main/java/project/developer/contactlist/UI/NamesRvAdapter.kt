
package project.developer.contactlist.UI

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.developer.contactlist.Model.ContactData
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import project.developer.contactlist.databinding.ContactlistBinding

class NamesRvAdapter(var contactList: List<ContactData>, val context: Context): RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var contactsDetails = contactList[position]

        holder.binding.apply {
            tvName.text = contactsDetails.contactName
            tvNumber.text = contactsDetails.phoneNumber
            tvEmail.text = contactsDetails.emailAddress
            if (contactsDetails.image.isNotBlank()) {

                Picasso
                    .get()
                    .load(contactsDetails.image)
                    .resize(80, 80)
                    .centerCrop()
                    .transform(CropCircleTransformation())
                    .into(holder.binding.ivContactImage)


            }
            holder.binding.cvContact.setOnClickListener{
                val intent = Intent(context, ContactDetailsActivity::class.java)
                intent.putExtra("CONTACT_ID",contactsDetails.contactId)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}


class ContactViewHolder(var binding: ContactlistBinding): RecyclerView.ViewHolder(binding.root)