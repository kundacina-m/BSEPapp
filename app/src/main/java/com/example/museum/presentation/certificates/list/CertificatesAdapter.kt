package com.example.museum.presentation.certificates.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dropit.ambassador.core.presentation.BaseAdapter
import com.dropit.ambassador.core.presentation.BaseViewHolder
import com.example.museum.R
import com.example.museum.data.model.Certificate
import kotlinx.android.synthetic.main.item_certificate.view.*

class CertificatesAdapter : BaseAdapter<Certificate>() {

    lateinit var onRevokeClicked: (Certificate) -> Unit
    lateinit var onIsRevokedClicked: (Certificate) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Certificate> =
        CertificateViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_certificate, parent, false
            )
        )

    override fun onBindViewHolder(holder: BaseViewHolder<Certificate>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.run {
            btRevoke.setOnClickListener { onRevokeClicked.invoke(getItemOnPosition(position)) }
            btIsRevoked.setOnClickListener { onIsRevokedClicked.invoke(getItemOnPosition(position))}
        }
    }

}