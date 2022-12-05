package com.tests.lifehackstudiotest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tests.lifehackstudiotest.R
import com.tests.lifehackstudiotest.domain.Companies

class CompaniesViewHolderAdapter(
    private val companies: List<Companies>,
    private val clickListener: OnCompanyCardClick
) : RecyclerView.Adapter<CompaniesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_companies, parent, false)

        return CompaniesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        holder.companyName.text = companies[position].name
        Picasso.get().load(companies[position].img).into(holder.companyImg)

        holder.companyCard.setOnClickListener {
            clickListener.companyCardClicked(position)
        }
    }

    override fun getItemCount(): Int = companies.size
}