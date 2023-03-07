package com.milovanjakovljevic.room_learning

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.milovanjakovljevic.room_learning.entities.Director
import com.milovanjakovljevic.room_learning.entities.School
import com.milovanjakovljevic.room_learning.entities.Student
import com.milovanjakovljevic.room_learning.entities.Subject
import com.milovanjakovljevic.room_learning.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
    StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase(){

    abstract val schoolDao:SchoolDao

    companion object{
        @Volatile
        private var INSTANCE:SchoolDatabase?=null

        fun getInstance(context:Context):SchoolDatabase{
            synchronized(this){

                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE=it
                }
            }
        }
    }
}