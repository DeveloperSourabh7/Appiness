package com.example.appiness.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
class Message{
    fun sendMsg(phoneNumber: String, context: Context) {
        val sendIntent = Intent(Intent.ACTION_VIEW)
        sendIntent.data = Uri.parse("sms:")
        sendIntent.putExtra("address", phoneNumber)
        context.startActivity(sendIntent)
    }
}