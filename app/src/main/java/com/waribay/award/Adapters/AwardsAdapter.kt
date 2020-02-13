package com.waribay.award.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import com.waribay.award.Models.AwardsModel
import com.waribay.award.R
import java.text.DecimalFormat
import java.text.NumberFormat


class AwardsAdapter(private val context: Context,
                    private val dataSource: ArrayList<AwardsModel>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rowView = inflater.inflate(R.layout.item_award, parent, false)
        val typeAwards = rowView.findViewById(R.id.type_awards) as TextView
        val imageAwards = rowView.findViewById(R.id.image_awards) as RelativeLayout
        val poinAwards = rowView.findViewById(R.id.poin_awards) as TextView
        val giftAwards = rowView.findViewById(R.id.gift_awards) as TextView

        val award = getItem(position) as AwardsModel
        val type : String = award.getType()
        val poin : Int = award.getPoin()
        var txtType : String = "-"

        if ( type.toUpperCase() == "V" ){
            txtType = "Vouchers"
        } else if ( type.toUpperCase() == "P" ){
            txtType = "Products"
        } else if ( type.toUpperCase() == "G" ){
            txtType = "Gifts"
        }

        val dec = DecimalFormat("#,###.##")
        val formatPoin = dec.format(poin)

        typeAwards.text = txtType
        poinAwards.text = formatPoin.toString().plus(" POIN")
        giftAwards.text = award.getName()
        imageAwards.background = context.getDrawable(award.getImage())

        return rowView
    }
}
