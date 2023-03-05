package com.milovanjakovljevic.room_learning

import androidx.room.*
import com.milovanjakovljevic.room_learning.entities.Director
import com.milovanjakovljevic.room_learning.entities.School
import com.milovanjakovljevic.room_learning.entities.Student
import com.milovanjakovljevic.room_learning.entities.relations.SchoolAndDirector
import com.milovanjakovljevic.room_learning.entities.relations.SchoolWithStudents


@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student:Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String):List<SchoolWithStudents>

}