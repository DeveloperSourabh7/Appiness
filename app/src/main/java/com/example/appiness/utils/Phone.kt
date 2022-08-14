package com.example.appiness.utils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import com.example.appiness.ui.screen.MainActivity

class Phone{
    fun phoneCall(phoneNumber:String,context:Context) {
        val intentCall = Intent(Intent.ACTION_CALL)
        val telNum: String = phoneNumber
        intentCall.data = Uri.parse("tel:$telNum")
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            checkpermission(context)
        } else {
            context.startActivity(intentCall)
        }
    }


    private fun checkpermission(context: Context) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                context as MainActivity,
                arrayOf(Manifest.permission.CALL_PHONE),
                101
            )
        }
    }
}