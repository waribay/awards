package com.waribay.award

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView
import java.text.DecimalFormat

class FilterActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var txtEndLimit : TextView
    private lateinit var seekPoin : SeekBar
    private lateinit var checkAll : CheckBox
    private lateinit var checkVoucher : CheckBox
    private lateinit var checkProduct : CheckBox
    private lateinit var checkGift : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        txtEndLimit = findViewById(R.id.txt_end_limit)
        txtEndLimit.text = "IDR 10,000"
        seekPoin = findViewById(R.id.seek_poin)
        seekPoin.setOnSeekBarChangeListener(this)

        checkAll = findViewById(R.id.check_all)
        checkProduct = findViewById(R.id.check_product)
        checkVoucher = findViewById(R.id.check_voucher)
        checkGift = findViewById(R.id.check_gift)

        checkAll.setOnCheckedChangeListener { buttonView, isChecked ->
            if ( isChecked ){
                checkProduct.isChecked = true
                checkVoucher.isChecked = true
                checkGift.isChecked = true
            } else {
                checkProduct.isChecked = false
                checkVoucher.isChecked = false
                checkGift.isChecked = false
            }
        }

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                   fromUser: Boolean) {
        val dec = DecimalFormat("#,###.##")
        val formatPoin = dec.format(progress)
        txtEndLimit.text = "IDR ".plus(formatPoin)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {
        // called when tracking the seekbar is started
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
        // called when tracking the seekbar is stopped
    }

    fun btnApplyFilter (view: View){}

    fun btnResetFilter (view: View){}


}
