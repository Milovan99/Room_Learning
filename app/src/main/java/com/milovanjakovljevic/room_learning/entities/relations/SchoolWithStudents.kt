package com.milovanjakovljevic.room_learning.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.entities.School
import com.milovanjakovljevic.room_learning.entities.Student

data class SchoolWithStudents (
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student:List<Student>
        )