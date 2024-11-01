package com.example.criminalintent

import android.app.Application

class CriminalIntentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // initialize the DB on app startup, not on MainActivity startup
        CrimeRepository.initialize(this)
    }
}