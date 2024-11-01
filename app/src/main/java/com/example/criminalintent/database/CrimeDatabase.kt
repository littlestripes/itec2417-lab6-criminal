package com.example.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.criminalintent.Crime

@Database(entities = [ Crime::class ], version=1)  // version gets incremented as the schema changes
@TypeConverters(CrimeTypeConverters::class)  // make sure our DB can access our TypeConverters
abstract class CrimeDatabase: RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
}