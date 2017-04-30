package com.example.androidcodes.SharedElementTransition;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* Use following links for more details:-

    https://github.com/lgvalle/Material-Animations

    https://github.com/codepath/android_guides/wiki/Shared-Element-Activity-Transition

    http://www.androidauthority.com/using-shared-element-transitions-activities-fragments-631996/ */

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        activity = MainActivity.this;

        ArrayList<Model> arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            Model model = new Model();
            model.setAppName(getString(R.string.app_name).concat("-").concat(String.valueOf(i)));
            model.setCompanyName("AndroidCodes-".concat(String.valueOf(i)));

            arrayList.add(model);

        }

        RecyclerView rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,
                false));
        rv_list.setAdapter(new RecyclerViewCustomAdapter(activity, arrayList));

    }
}
