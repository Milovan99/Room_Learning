package com.milovanjakovljevic.room_learning.phone_database.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.phone_database.entities.App
import com.milovanjakovljevic.room_learning.phone_database.entities.Category

data class AppWithCategories (
    @Embedded val app: App,
    @Relation(
        parentColumn = "appName",
        entityColumn = "categoryName",
        associateBy = Junction(CategoryAppCrossRef::class)
    )
    val categories: List<Category>
        )