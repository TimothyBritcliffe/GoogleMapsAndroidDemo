package com.example.google_maps;

// Import necessary classes for Android app functionality
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

// Import classes for Google Maps functionality
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// Import classes for checking Google Play Services availability
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

// MainActivity class that extends AppCompatActivity and implements OnMapReadyCallback interface
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    // Variable to hold the GoogleMap instance
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity to activity_main.xml which contains the map fragment
        setContentView(R.layout.activity_main);

        // Check if Google Play services are available before initializing the map
        if (isGooglePlayServicesAvailable()) {
            // Retrieve the SupportMapFragment defined in the layout using its ID (R.id.map)
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            // Request to load the map asynchronously, which will trigger the onMapReady callback when done
            mapFragment.getMapAsync(this);
        } else {
            // If Google Play services are not available, show a toast message to the user
            Toast.makeText(this, "Google Play services are not available.", Toast.LENGTH_SHORT).show();
        }
    }

    // This method is called when the map is ready to be used
    @Override
    public void onMapReady(GoogleMap map) {
        // Store the map object in the googleMap variable for later use
        googleMap = map;

        // Check if the map is initialized successfully
        if (googleMap != null) {
            // Define the latitude and longitude for the desired location (San Francisco in this case)
            LatLng location = new LatLng(50.671154, -120.3611305);  // San Francisco coordinates 37.7749, -122.4194//Sydney -33.8688, 151.2093


            // Create a marker and set its position, title, and add it to the map
            //This method adds a marker to the map. A marker is a visual symbol that indicates a specific geographical location.
            //MarkerOptions object, which is used to specify the properties of the marker.
            //position(location): Sets the geographical position where the marker should appear.
            //title("San Francisco"):sets the title of the marker
           googleMap.addMarker(new MarkerOptions().position(location).title("Sydney"));

            // Move the camera to focus on the specified location and set the zoom level to 12
            // Higher zoom levels provide a closer view of the area
           googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));

            // Enable zoom controls (optional feature) to allow the user to zoom in and out of the map

            // googleMap.getUiSettings().setZoomControlsEnabled(true);
        }
    }

    // Example code for using a custom marker color
    // This method shows how to change the marker's icon to a different color using a BitmapDescriptor
//        public void onMapReady(GoogleMap map) {
//            googleMap = map; // Assign the map instance when it's ready
//
//            // Check if the map is ready
//            if (googleMap != null) {
//                // Add a custom marker at a specific location and move the camera
//
//                // Define the location using latitude and longitude coordinates
//                LatLng location = new LatLng(37.7749, -122.4194);  // Example: San Francisco
//
//                // Create a custom marker icon with a magenta color
//                BitmapDescriptor customMarkerIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN);
//
//                // Configure the marker options with custom icon and position
//                MarkerOptions markerOptions = new MarkerOptions()
//                        .position(location)       // Set the marker's position
//                        .icon(customMarkerIcon);  // Set the custom marker icon
//
//                // Add the marker to the Google Map
//                googleMap.addMarker(markerOptions);
//
//                // Move the camera to the specified location with a zoom level of 12
//                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
//            }
//        }

    // Method to check if Google Play services are available on the device
    private boolean isGooglePlayServicesAvailable() {
        // Get the availability status of Google Play services for the current device
        int availability = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

        // Return true if Google Play services are available and up-to-date
        // ConnectionResult.SUCCESS indicates that the device is capable of using Google Maps
        return availability == ConnectionResult.SUCCESS;
    }
}
