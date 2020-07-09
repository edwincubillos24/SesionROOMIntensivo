package com.edwinacubillos.sesionroom.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edwinacubillos.sesionroom.model.local.Deudor
import com.edwinacubillos.sesionroom.model.local.DeudorDAO

@Database(entities = arrayOf(Deudor::class), version = 1)
abstract class DeudorDataBase : RoomDatabase(){

    abstract fun DeudorDAO() : DeudorDAO

}