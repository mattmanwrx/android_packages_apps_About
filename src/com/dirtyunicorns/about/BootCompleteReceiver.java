/*
 * Copyright (C) 2012 Crossbones Software
 * This code has been modified.  Portions copyright (C) 2013, Dirty Unicorns Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dirtyunicorns.about;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;


public class BootCompleteReceiver extends BroadcastReceiver {

    private static final String ABOUT_INTENT = "com.dirtyunicorns.about.AboutActivity";
    private static final String TAG = "AboutBootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        AboutActivity aboutActivity = new AboutActivity();

        SharedPreferences prefs = context.getSharedPreferences(aboutActivity.PREFS_NAME, 0);

        String previousDuVersion = prefs.getString(aboutActivity.DU_VERSION, "0.0.0");
        String currentDuVersion = Utils.getDuVersion();

        Log.d(TAG, "Previous DU Version: " + previousDuVersion);
        Log.d(TAG, "Current DU Version: " + currentDuVersion);

        if (!currentDuVersion.equals(previousDuVersion)) {
        //if (currentDuVersion.equals(previousDuVersion)) { //DEBUGGING
            Log.d(TAG, "Running About Activity");

            Intent i = new Intent();
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setClassName(context, ABOUT_INTENT);
            context.startActivity(i);
        } else {
            Log.d(TAG, "About Activity has already run");
        }

    }
}
