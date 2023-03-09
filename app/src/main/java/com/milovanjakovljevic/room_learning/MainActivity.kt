package com.milovanjakovljevic.room_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.milovanjakovljevic.room_learning.phone_database.entities.*
import com.milovanjakovljevic.room_learning.phone_database.entities.relations.CategoryAppCrossRef
import com.milovanjakovljevic.room_learning.school_database.entities.*
import com.milovanjakovljevic.room_learning.school_database.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dao = PhoneDatabase.getInstance(this).phoneDao

        val persons= listOf(
            Person("Milovan Jakovljevic","Samsung"),
            Person("Djordje Vasilic","Huawei"),
            Person("Srdjan Ostojic","Iphone")
        )

        val apps = listOf(
            App("Instagram","Samsung"),
            App("Tinder","Huawei"),
            App("Cugopol","Iphone")
        )

        val categories= listOf(
            Category("Social"),
            Category("Gaming")
        )

        val phones = listOf(
            Phone("Samsung"),
            Phone("Huawei"),
            Phone("Iphone")
        )

        val appCategoryRelations = listOf(
            CategoryAppCrossRef("Social","Instagram"),
            CategoryAppCrossRef("Social","Tinder"),
            CategoryAppCrossRef("Gaming","Cugopol"),
            CategoryAppCrossRef("Gaming","Tinder")
        )


        lifecycleScope.launch{
            persons.forEach{dao.insertPerson(it)}
            apps.forEach{dao.insertApp(it)}
            phones.forEach{dao.insertPhone(it)}
            categories.forEach{dao.insertCategory(it)}
            appCategoryRelations.forEach{dao.insertCategoryAppCrossRef(it)}
        }




        /*
        val directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Jake Wharton School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRef("Beff Jezos", "Avoiding depression"),
            StudentSubjectCrossRef("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectCrossRef("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRef("Hom Tanks", "Avoiding depression"),
            StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
        )

        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            }*/
    }
}