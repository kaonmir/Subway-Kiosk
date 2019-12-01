package com.example.fuckingviewpagedamn

import android.os.Parcel
import android.os.Parcelable

@Suppress("JAVA_CLASS_ON_COMPANION")
class Menu() : Parcelable {

    var name: String = ""
    var price: Int = 0
    var breadLength: BreadLength = BreadLength.NONE
    var breadType: BreadType = BreadType.NONE
    var cheese: CheeseType = CheeseType.NONE
    var vegetables = listOf<Int>()
    var sources = listOf<Int>()

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()!!
        price = parcel.readInt()
        breadLength = BreadLength.values()[parcel.readInt()]
        breadType = BreadType.values()[parcel.readInt()]
        cheese = CheeseType.values()[parcel.readInt()]

        parcel.readList(vegetables, Int.javaClass.classLoader)
        parcel.readList(sources, Int.javaClass.classLoader)
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.run {
            writeString(name)
            writeInt(price)
            writeInt(breadLength.ordinal)
            writeInt(breadType.ordinal)
            writeInt(cheese.ordinal)
            writeList(vegetables)
            writeList(sources)
        }
    }

    fun toJson(): String {
        val jsonstr = """{
            |   "name": "$name",
            |   "breadLength": "$breadLength",
            |   "breadType": "$breadType",
            |   "cheese": "$cheese",
            |   "vegetables": [${vegetables.map {SourceType.values()[it]}.joinToString { ","}}]
            |   "sources": [${sources.map {"${SourceType.values()[it]}"}.joinToString { ","}}]
            |}
        """.trimMargin()
        return jsonstr
    }

    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Menu> {
        override fun createFromParcel(parcel: Parcel): Menu {
            return Menu(parcel)
        }

        override fun newArray(size: Int): Array<Menu?> {
            return arrayOfNulls(size)
        }
    }
}
