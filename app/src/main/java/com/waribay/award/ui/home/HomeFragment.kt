package com.waribay.award.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.waribay.award.Adapters.AwardsAdapter
import com.waribay.award.Models.AwardsModel
import com.waribay.award.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var listAwards: ListView

    private val arrType : Array<String> = arrayOf("V", "P", "V", "V", "G")
    private val arrPoin : IntArray = intArrayOf(100000, 300000, 250000, 50000, 450000)
    private val arrName : Array<String> = arrayOf("On Gift Card IDR 1.000.000", "On Gift Card IDR 500.000", "Old Fashion Cake", "On Gift Card IDR 1.500.000", "Young Fashion Cake")
    private val arrImage : IntArray = intArrayOf(R.drawable.background_1 ,R.drawable.background_2, R.drawable.background_3, R.drawable.background_4, R.drawable.background_5)
    private var arrAwards : ArrayList<AwardsModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val context : Context = this.activity!!.applicationContext

        listAwards = root.findViewById(R.id.list_awards)
        this.addingAwards()

        val awardsAdapter = AwardsAdapter( context, arrAwards)
        listAwards.adapter = awardsAdapter

        val footer: View = View.inflate(context, R.layout.footer_more, null)
        listAwards.addFooterView(footer)
        val btnMore : Button = footer.findViewById(R.id.btn_load_more)
        btnMore.setOnClickListener {
            this.addingAwards()
            awardsAdapter.notifyDataSetChanged()
        }

        homeViewModel.text.observe(this, Observer {

        })
        return root
    }

    private fun addingAwards (){
        var index = 0
        for (type in arrType) {
            val awardsModel = AwardsModel()
            awardsModel.setType(type)
            awardsModel.setName(this.arrName[index])
            awardsModel.setPoin(this.arrPoin[index])
            awardsModel.setImage(this.arrImage[index])
            this.arrAwards.add(awardsModel)
            index++
        }
    }
}
