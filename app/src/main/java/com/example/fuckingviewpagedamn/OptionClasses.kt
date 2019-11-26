package com.example.fuckingviewpagedamn

import android.os.Parcel
import android.os.Parcelable
import javax.xml.transform.Source
import javax.xml.transform.SourceLocator

enum class BreadLength {
    SHORT, LONG, NONE
}
enum class BreadType {
    WHEAT, ITALIANHERB, FLATBREAD, ITALIAN, NONE
}
enum class CheeseType {
    SHREDDED, WHITE, MOZZARELLA, NONE
}
enum class VegetableType() {
    PICKLE, CUCUMBER, JALAPENO,
    OLIVE, ONION, PIMENTO,
    LETTUCE, TOMATO, NONE
}
enum class SourceType {
    SWEETCHILI, SALT, BPEPPER,
    THOUSANDISLANDS, RANCH, ITALITAN,
    HONEYMUSTARD, MAYONNAISE, SMOKEBBQ, NONE
}
enum class HowMuch() {
    LESS, REGULAR, MORE, NONE
}

@Suppress("JAVA_CLASS_ON_COMPANION")
class Menu() : Parcelable {

    var name: String = ""
    var price: Int = 0
    var breadLength: BreadLength = BreadLength.NONE
    var breadType: BreadType = BreadType.NONE
    var cheese: CheeseType = CheeseType.NONE
    var vegetable: List<VegetableType> = listOf()
    var sources: List<SourceType> = listOf()

    constructor(parcel: Parcel) : this() {
        breadLength = BreadLength.values()[parcel.readInt()]
        breadType = BreadType.values()[parcel.readInt()]
        cheese = CheeseType.values()[parcel.readInt()]
        parcel.readList(sources, Menu.javaClass.classLoader)
        parcel.readList(vegetable, Menu.javaClass.classLoader)
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(breadLength.ordinal)
        dest?.writeInt(breadType.ordinal)
        dest?.writeInt(cheese.ordinal)
        dest?.writeList(vegetable)
        dest?.writeList(sources)

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
