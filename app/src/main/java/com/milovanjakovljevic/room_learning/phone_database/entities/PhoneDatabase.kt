package com.milovanjakovljevic.room_learning.phone_database.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.milovanjakovljevic.room_learning.phone_database.entities.relations.CategoryAppCrossRef

@Database(
    entities = [
        Phone::class,
        Person::class,
        App::class,
        Category::class,
        CategoryAppCrossRef::class
    ],
    version = 1
)
abstract class PhoneDatabase :RoomDatabase() {

    abstract val phoneDao:PhoneDao

    companion object{
        @Volatile
        private var INSTANCE:PhoneDatabase?=null

        fun getInstance(context: Context):PhoneDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    PhoneDatabase::class.java,
                    "phone_db"
                ).build().also { INSTANCE=it }
            }
        }
    }
}