package com.example.androidcodes.SharedElementTransition;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mehta on 4/23/2017.
 */

public class DetailActivity extends AppCompatActivity {

    private String appName = "";

    private Bitmap bitmap = null;

    private ArrayList<Model> modelsList = null;

    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_activity);

        activity = DetailActivity.this;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            if (getIntent().hasExtra("myappName")) {

                appName = bundle.getString("myappName");

            }

            /*if (getIntent().hasExtra("bitmap")) {

                bitmap = getIntent().getParcelableExtra("bitmap");

            }*/

            if (getIntent().hasExtra("parcebleList")) {

                modelsList = bundle.getParcelableArrayList("parcebleList");

            }
        }

        /*if (modelsList != null) {

            for (Model model : modelsList) {

                Toast.makeText(activity, "AppName : ".concat(model.getAppName()).
                                concat(", CompanyName : ").concat(model.getCompanyName()),
                        Toast.LENGTH_SHORT).show();

            }
        }*/

        ((TextView) findViewById(R.id.tv_appName)).setText(appName);

        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        //if (bitmap != null) {

        imageView.setImageResource(R.drawable.image);

        //}
    }
}
