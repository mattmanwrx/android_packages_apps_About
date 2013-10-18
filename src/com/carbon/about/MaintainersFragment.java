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

package com.carbon.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MaintainersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View maintainersView = inflater.inflate(R.layout.maintainers_fragment, container, false);

        TextView maintainersVersion = (TextView) maintainersView.findViewById(R.id.maintainers_version);
        String version =  Utils.getCarbonVersion();
        maintainersVersion.append(" ");

        // Inflate the layout for this fragment
        return maintainersView;
    }
}
