package com.milovanjakovljevic.room_learning.phone_database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.phone_database.entities.App
import com.milovanjakovljevic.room_learning.phone_database.entities.Phone

data class PhoneWithApps (
    @Embedded val phone: Phone,
    @Relation(
        parentColumn = "phoneName",
        entityColumn = "phoneName"
    )
    val apps :List<App>
        )