package com.milovanjakovljevic.room_learning.school_database.entities

import androidx.room.*
import com.milovanjakovljevic.room_learning.school_database.entities.Director
import com.milovanjakovljevic.room_learning.school_database.entities.School
import com.milovanjakovljevic.room_learning.school_database.entities.Student
import com.milovanjakovljevic.room_learning.school_database.entities.Subject
import com.milovanjakovljevic.room_learning.school_database.entities.relations.*
import com.milovanjakovljevic.room_learning.school_database.entities.relations.*


@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String):List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String):List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectOfStudent(studentName:String):List<StudentWithSubjects>

}