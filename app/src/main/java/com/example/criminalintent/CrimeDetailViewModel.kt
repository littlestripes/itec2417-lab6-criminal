package com.example.criminalintent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import java.io.File
import java.util.UUID

class CrimeDetailViewModel(): ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    // a LiveData stream containing the details for the Crimes by their crimeIds
    var crimeLiveData: LiveData<Crime?> = crimeIdLiveData.switchMap { crimeId ->
        crimeRepository.getCrime(crimeId)
    }

    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId
    }

    fun saveCrime(crime: Crime) {
        crimeRepository.updateCrime(crime)
    }

    fun getPhotoFile(crime: Crime): File {
        // exposes file info to CrimeFragment
        return crimeRepository.getPhotoFile(crime)
    }
}