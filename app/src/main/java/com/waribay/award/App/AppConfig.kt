package com.waribay.award.App

class AppConfig {

    companion object{
        private var poin    : Int = 0
        private var voucher : Boolean? = false
        private var product : Boolean? = false
        private var gift    : Boolean? = false

        fun getPoin(): Int {
            return poin
        }

        fun setPoin(poin: Int) {
            this.poin = poin
        }

        fun getVoucher(): Boolean? {
            return voucher
        }

        fun setVoucher(voucher: Boolean) {
            this.voucher = voucher
        }

        fun getProduct(): Boolean? {
            return product
        }

        fun setProduct(product: Boolean) {
            this.product = product
        }

        fun getGift(): Boolean? {
            return gift
        }

        fun setGift(gift: Boolean) {
            this.gift = gift
        }
    }

}