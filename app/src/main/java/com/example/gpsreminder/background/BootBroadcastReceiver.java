//package com.example.gpsreminder.background;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//
//public class BootBroadcastReceiver extends BroadcastReceiver {
//    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        // BOOT_COMPLETED” start Service
//        if (intent.getAction().equals(ACTION)) {
//            //Service
//            Intent serviceIntent = new Intent(context, TimeChecker.class);
//            context.startService(serviceIntent);
//        }
//    }
//}