package com.udacity

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat


private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0
fun NotificationManager.sendNotification(
    messageBody: String,
    applicationContext: Context,
    contentIntent: Intent
) {


    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    val bigStyle = NotificationCompat.BigTextStyle()
        .setBigContentTitle(applicationContext.getString(R.string.notification_title))

    // Build the notification
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.download_channel_id)
    )
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)
        .setSmallIcon(R.drawable.ic_assistant_black_24dp)
        .setContentIntent(contentPendingIntent)
        .addAction(R.drawable.ic_assistant_black_24dp, "Check Status", contentPendingIntent)

        .setPriority(NotificationCompat.PRIORITY_LOW)
        .setAutoCancel(true)

    // Deliver the notification
    notify(NOTIFICATION_ID, builder.build())
}

