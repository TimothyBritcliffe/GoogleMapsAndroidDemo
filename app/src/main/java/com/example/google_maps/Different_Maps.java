
package com.example.google_maps;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Different_Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    // Kamloops coordinates
    LatLng kamloops = new LatLng(50.6745, -120.3273);

    // Creating buttons
    private Button hybridMapBtn, terrainMapBtn, satelliteMapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_maps);

        // Initialize buttons
        hybridMapBtn = findViewById(R.id.idBtnHybridMap);
        terrainMapBtn = findViewById(R.id.idBtnTerrainMap);//emphasizes the physical features of the Earth's surface, including elevation, contours, and landforms.
        satelliteMapBtn = findViewById(R.id.idBtnSatelliteMap);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);//This method is used to asynchronously  to get a reference to the
        // GoogleMap object associated with the SupportMapFragment. When the GoogleMap is ready,
        // it will trigger the onMapReady callback method in the current activity

        // Set onClickListeners for map type buttons
        hybridMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        terrainMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

        satelliteMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker for Kamloops

        mMap.addMarker(new MarkerOptions().position(kamloops).title("Marker in Kamloops"));

        // Move the camera to Kamloops
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kamloops, 20)); // Zoom level can be adjusted
    }
}
