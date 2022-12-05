package com.tests.lifehackstudiotest.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView
import com.tests.lifehackstudiotest.R

class CompaniesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val companyImg = itemView.findViewById<ShapeableImageView>(R.id.itemImage)
    val companyName = itemView.findViewById<TextView>(R.id.itemCompanyName)
    val companyCard = itemView.findViewById<MaterialCardView>(R.id.itemCard)
}