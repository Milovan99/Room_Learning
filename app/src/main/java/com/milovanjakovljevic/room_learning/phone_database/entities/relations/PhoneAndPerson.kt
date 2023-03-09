package com.milovanjakovljevic.room_learning.phone_database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.phone_database.entities.Person
import com.milovanjakovljevic.room_learning.phone_database.entities.Phone

data class PhoneAndPerson (
    @Embedded val phone: Phone,
    @Relation(
        parentColumn = "phoneName",
        entityColumn = "phoneName"
    )
    val person: Person
        )