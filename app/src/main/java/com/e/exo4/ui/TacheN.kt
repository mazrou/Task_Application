package com.e.exo4.ui


class TacheN(tacheName : String, annee : Int, mois: Int, jour: Int) : Comparable<TacheN>{
    var name = tacheName
    var annee = annee
    var mois = mois
    var  jour = jour

    fun dateToString() : String{
        return "$jour-${mois+1}-$annee"
    }

    override fun compareTo(other: TacheN): Int {
        return ("$name-$annee-$mois-$jour").compareTo("${other.name}-${other.annee}-${other.mois}-${other.jour}")
    }

    override fun hashCode(): Int {
        return ("$name-$annee-$mois-$jour").hashCode()
    }
}
