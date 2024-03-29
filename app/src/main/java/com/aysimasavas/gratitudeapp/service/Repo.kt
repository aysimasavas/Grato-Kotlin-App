package com.aysimasavas.gratitudeapp.service

import android.content.Context
import com.aysimasavas.gratitudeapp.model.NoteModel

class Repo {


    companion object{

        private var noteDatabase:NoteDatabase?=null

        private fun initialiseDB(context: Context):NoteDatabase?
        {
            return  NoteDatabase.invoke(context)
        }


        fun update(context:Context,noteModel: NoteModel)
        {
            noteDatabase= initialiseDB(context)

                noteDatabase?.noteDao()?.updateNotes(noteModel)

        }



        fun insert(context: Context,noteModel: NoteModel)
        {
            noteDatabase= initialiseDB(context)

             noteDatabase?.noteDao()?.insertAll(noteModel)

        }


        fun delete(context: Context,noteModel: NoteModel)
        {
            noteDatabase= initialiseDB(context)

            noteDatabase?.noteDao()?.deleteNotes(noteModel)

        }

        fun search(context: Context,note:String): List<NoteModel>?
        {
            noteDatabase= initialiseDB(context)

            return noteDatabase?.noteDao()?.getSearchResults(note)
        }

    }

}