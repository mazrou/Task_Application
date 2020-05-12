package com.e.exo4.ui


import android.app.DatePickerDialog
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.exo4.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    var tachList : MutableList<TacheN> = ArrayList()
    lateinit var adapter: TachAdapter
    lateinit var layoutManager : LinearLayoutManager
    lateinit var List : MutableList<Int>
    var pos: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        List = getToutesTaches(tachList)
        adapter = TachAdapter(this)
        recyclerView.adapter = adapter


        val isTablet = ((this.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE)
        val isLandscape = this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE

        if (!isTablet){


        }else if (!isLandscape){

            val spinner: Spinner = findViewById(R.id.combobox)
            ArrayAdapter.createFromResource(
                this,
                R.array.options,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }

            combobox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    pos = position
                    changerTaches(position)

                }

            }

        } else {

            aujourdhuiTachBtn.setOnClickListener {
                pos = 0
                changerTaches(pos)
            }

            moisTacheBtn.setOnClickListener{
                pos = 1
                changerTaches(pos)
            }

            tachesBtn.setOnClickListener{
                pos = 2
                changerTaches(pos)
            }


        }

        val c = Calendar.getInstance()
        val annee = c.get(Calendar.YEAR)
        val mois = c.get(Calendar.MONTH)
        val jour = c.get(Calendar.DAY_OF_MONTH)

        addTacheBtn!!.setOnClickListener {
            val tacheName = taskInputView.text.toString()
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, annee, mois, jour ->
                val tache = TacheN(tacheName, annee, mois, jour)
                tachList.add(tache)

                val list = tachList.distinct()

                changerTaches(pos)
            }, annee, mois, jour)

            datePickerDialog.show()


        }


    }


    fun changerTaches(position : Int){
        if (position == 0){
            List.clear()
            List = getToutesTaches(tachList)
            adapter.notifyDataSetChanged()
        }

        if (position == 1){
            List.clear()
            List = getToutesTaches(tachList)
            adapter.notifyDataSetChanged()
        }

        if (position == 2){
            List.clear()
            List = getToutesTaches(tachList)
            adapter.notifyDataSetChanged()
        }
    }





    fun getToutesTaches(mainList : MutableList<TacheN>):MutableList<Int>{
        var list : MutableList<Int> = ArrayList()
        for (i in 0 until mainList.size){
            list.add(i)
        }
        return list
    }


    class TachAdapter(val activity : MainActivity) : RecyclerView.Adapter<TachAdapter.TachViewHolder>(){
        class TachViewHolder(v : View) : RecyclerView.ViewHolder(v){
            val TacheName = v.findViewById<TextView>(R.id.tacheView)
            val TacheDate = v.findViewById<TextView>(R.id.tacheDateView)
            val tacheLayout = v.findViewById<RelativeLayout>(R.id.tacheLayoutView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TachViewHolder {
            return TachViewHolder(LayoutInflater.from(activity).inflate(R.layout.tache_view, parent, false))
        }

        override fun getItemCount(): Int {
            return activity.List.size
        }

        override fun onBindViewHolder(holder: TachViewHolder, position: Int) {
            holder.TacheName.text = activity.tachList[activity.List[position]].name
            holder.TacheDate.text = activity.tachList[activity.List[position]].dateToString()
            holder.tacheLayout.setOnClickListener {
                activity.tachList.removeAt(activity.List[position])
                activity.changerTaches(activity.pos)
            }
        }
    }
}