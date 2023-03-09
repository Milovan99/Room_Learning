package com.milovanjakovljevic.room_learning.phone_database.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.phone_database.entities.App
import com.milovanjakovljevic.room_learning.phone_database.entities.Category

data class CategoryWithApps (
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryName",
        entityColumn = "appName",
        associateBy = Junction(CategoryAppCrossRef::class)
    )
    val apps: List<App>
)