package com.milovanjakovljevic.room_learning.phone_database.entities

import androidx.room.*
import com.milovanjakovljevic.room_learning.phone_database.entities.relations.*

@Dao
interface PhoneDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertPhone(phone: Phone)

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertApp(app: App)

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertCategoryAppCrossRef(crossRef: CategoryAppCrossRef)

    @Transaction
    @Query("SELECT * FROM phone WHERE phoneName = :phoneName")
    suspend fun getPhoneAndPersonWithPhoneName(phoneName:String): PhoneAndPerson

    @Transaction
    @Query("SELECT * FROM phone WHERE phoneName = :phoneName")
    suspend fun getPhoneWithApps(phoneName:String): List<PhoneWithApps>

    @Transaction
    @Query("SELECT * FROM category WHERE categoryName = :categoryName")
    suspend fun getCategoryWithApps(categoryName:String): List<CategoryWithApps>

    @Transaction
    @Query("SELECT * FROM app WHERE appName = :appName")
    suspend fun getAppWithCategories(appName:String): List<AppWithCategories>
}