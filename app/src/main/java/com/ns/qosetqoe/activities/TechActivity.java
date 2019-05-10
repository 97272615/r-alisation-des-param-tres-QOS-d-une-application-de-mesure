package com.ns.qosetqoe.activities;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ns.qosetqoe.R;
import com.ns.qosetqoe.models.ItemClass;
import com.ns.qosetqoe.utils.KpiDialog;
import com.ns.qosetqoe.utils.LoadJson;

import java.util.ArrayList;
import java.util.List;

import static com.ns.qosetqoe.utils.UtilsClass.getSmallestDistance;

public class TechActivity extends AppCompatActivity implements LoadJson.OnLoadJson, LocationListener {
    private Button BtnKpi;
    private List<ItemClass> items = new ArrayList<>();
    private Dialog dialog;
    private LocationManager locationManager;
    private Location location;
    private KpiDialog kpiDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);
        BtnKpi = findViewById(R.id.kpiBtn);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        BtnKpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                if (items == null) {
                    new LoadJson(getResources(), TechActivity.this).execute();
                } else {
                    loadKpi();
                }

            }
        });
    }

    @Override
    public void onLoadCompleted(List<ItemClass> items) {
        this.items = items;
        loadKpi();
    }

    private void showDialog() {
        dialog = new Dialog(this);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        ProgressBar loader = new ProgressBar(this);
        TextView text = new TextView(this);
        text.setText("Loading ...");
        layout.addView(loader);
        layout.addView(text);

        dialog.setContentView(layout);
        dialog.setCancelable(false);
        dialog.show();
    }

    private void loadKpi() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        ItemClass item = items.get(getSmallestDistance(items, location));
        dialog.hide();
        kpiDialog = new KpiDialog(this, item);
        kpiDialog.show();

    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }



}
