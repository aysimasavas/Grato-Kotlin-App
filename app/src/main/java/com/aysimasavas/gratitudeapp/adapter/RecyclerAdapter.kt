package com.aysimasavas.gratitudeapp.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.aysimasavas.gratitudeapp.R
import com.aysimasavas.gratitudeapp.helpers.DateFormatHelper
import com.aysimasavas.gratitudeapp.model.NoteModel
import kotlinx.android.synthetic.main.row_time.view.*
import java.text.SimpleDateFormat

class RecyclerAdapter (private val noteList: ArrayList<NoteModel>,private val listener : Listener): RecyclerView.Adapter<RecyclerAdapter.RowHolder>(){



    interface Listener {
        fun onItemClick(noteModel:NoteModel,view: View)
    }
    class RowHolder(view: View):RecyclerView.ViewHolder(view) {


        @SuppressLint("SimpleDateFormat")
        fun bind(noteModel:NoteModel, position: Int, listener:Listener)
        {

            itemView.setOnClickListener {
                listener.onItemClick(noteModel,it)
            }


            val dateTextStr=SimpleDateFormat("dd MMMM yyyy")
                    .format(DateFormatHelper().stringToDate(noteModel.date.toString()))

            itemView.note_date_text.text=dateTextStr
            itemView.gratitude_text.text=noteModel.note



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_time,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(noteList[position],position,listener)
        holder.itemView.animation=AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_anim)
    }

    override fun getItemCount(): Int {
        return noteList.count()
    }


}
