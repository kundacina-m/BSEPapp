package com.example.museum.presentation.certificates.list

import android.view.View
import com.dropit.ambassador.core.presentation.BaseViewHolder
import com.example.museum.data.model.Certificate
import kotlinx.android.synthetic.main.item_certificate.view.*

class CertificateViewHolder(itemView: View) : BaseViewHolder<Certificate>(itemView) {
    override fun bind(item: Certificate) {
        itemView.tvCertificateDetail.text = item.serialNumberSubject
    }
}