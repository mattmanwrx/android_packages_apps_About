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

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class AboutActivity extends Activity {
    public static Context appContext;

    public static final String PREFS_NAME = "About";
    public static final String DU_VERSION = "du_version";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        appContext = getApplicationContext();

        //ActionBar
        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        ActionBar.Tab AboutTab = actionbar.newTab().setText(R.string.about_tab_title);
        ActionBar.Tab FeaturesTab = actionbar.newTab().setText(R.string.features_tab_title);
        ActionBar.Tab MaintainersTab = actionbar.newTab().setText(R.string.maintainers_tab_title);
        ActionBar.Tab ContributorsTab = actionbar.newTab().setText(R.string.contributors_tab_title);
        ActionBar.Tab SocialTab = actionbar.newTab().setText(R.string.social_tab_title);
        
        Fragment AboutFragment = new AboutFragment();
        Fragment FeaturesFragment = new FeaturesFragment();
        Fragment MaintainersFragment = new MaintainersFragment();
        Fragment ContributorsFragment = new ContributorsFragment();
        Fragment SocialFragment = new SocialFragment();

        AboutTab.setTabListener(new MyTabsListener(AboutFragment));
        FeaturesTab.setTabListener(new MyTabsListener(FeaturesFragment));
        MaintainersTab.setTabListener(new MyTabsListener(MaintainersFragment));
        ContributorsTab.setTabListener(new MyTabsListener(ContributorsFragment));
        SocialTab.setTabListener(new MyTabsListener(SocialFragment));

        actionbar.addTab(AboutTab);
        actionbar.addTab(FeaturesTab);
        actionbar.addTab(MaintainersTab);
        actionbar.addTab(ContributorsTab);
        actionbar.addTab(SocialTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuitem_exit:
                String duVersion = Utils.getDuVersion();

                SharedPreferences prefs = this.getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString(DU_VERSION, duVersion);
                prefEditor.commit();

                finish();
                return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }

    public void launchGoogleplus(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.googleplus_url)));
        startActivity(intent);
    }
    public void launchTwitter(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.twitter_url)));
        startActivity(intent);
    }
    public void launchGithub(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.github_url)));
        startActivity(intent);
    }
    public void launchPaul(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.paul_url)));
        startActivity(intent);
    }
    public void launchDennis(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.dennis_url)));
        startActivity(intent);
    }
    public void launchKenneth(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.kenneth_url)));
        startActivity(intent);
    }
    public void launchBrian(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.brian_url)));
        startActivity(intent);
    }
    public void launchAokp(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.aokp_url)));
        startActivity(intent);
    }
    public void launchCm(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.cm_url)));
        startActivity(intent);
    }
    public void launchPa(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.pa_url)));
        startActivity(intent);
    }
    public void launchCarbon(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.carbon_url)));
        startActivity(intent);
    }
    public void launchChaos(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.chaos_url)));
        startActivity(intent);
    }
    public void launchPreludedrew(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.preludedrew_url)));
        startActivity(intent);
    }
    public void launchLordclockan(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.lordclockan_url)));
        startActivity(intent);
    }
    public void launchDaxxmax(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.daxxmax_url)));
        startActivity(intent);
    }
}

class MyTabsListener implements ActionBar.TabListener {
    public Fragment fragment;

    public MyTabsListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // nothing
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

}
