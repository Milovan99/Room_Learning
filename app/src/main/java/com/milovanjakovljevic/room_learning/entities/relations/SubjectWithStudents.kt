package com.milovanjakovljevic.room_learning.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.entities.Student
import com.milovanjakovljevic.room_learning.entities.Subject

data class SubjectWithStudents (
    @Embedded val subject:Subject,
    @Relation (
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
            )
    val students:List<Student>
        )