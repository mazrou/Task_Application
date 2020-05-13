package com.e.exo4.ui


data class TacheN(
    val title : String,
    val annee : Int,
    val mois: Int,
    val jour: Int) : Comparable<TacheN>{



    fun dateToString() : String{
        return "$jour-${mois+1}-$annee"
    }

    override fun compareTo(other: TacheN): Int {
        return ("$title-$annee-$mois-$jour").compareTo("${other.title}-${other.annee}-${other.mois}-${other.jour}")
    }

    override fun hashCode(): Int {
        return ("$title-$annee-$mois-$jour").hashCode()
    }
}
