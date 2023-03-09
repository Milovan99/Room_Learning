package com.milovanjakovljevic.room_learning.school_database.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.school_database.entities.Student
import com.milovanjakovljevic.room_learning.school_database.entities.Subject

data class StudentWithSubjects (
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects:List<Subject>
        )
