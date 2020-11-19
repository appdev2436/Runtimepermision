package com.mypermision;



import android.Manifest; 
import android.content.pm.PackageManager; 
import android.support.annotation.NonNull; 
import android.support.v4.app.ActivityCompat; 
import android.support.v4.content.ContextCompat; 
import android.app.Activity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.Toast; 

public class MainActivity extends Activity { 

	
	private Button storage, camera,location; 

	
	private static final int cammerapermision = 1; 
	private static final int storagepermission = 2; 
	private static final int locationpermission = 3; 

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{ 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.main); 

		storage = findViewById(R.id.storage); 
		camera = findViewById(R.id.camera); 
		location = findViewById(R.id.location); 
		

		//oncick Button
		
		storage.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View v) 
				{ 
					checkPermission( 
						Manifest.permission.WRITE_EXTERNAL_STORAGE, 
						storagepermission); 
				} 
			}); 
			

		camera.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View v) 
				{ 
					checkPermission(Manifest.permission.CAMERA, 
									cammerapermision); 
				} 
			}); 
			
			
			
		location.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View v) 
				{ 
					checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, 
									locationpermission); 
				} 
			}); 
	} 
	
	
	

	
	public void checkPermission(String permission, int requestCode) 
	{ 
		if (ContextCompat.checkSelfPermission(MainActivity.this, permission) 
			== PackageManager.PERMISSION_DENIED) { 

			
			
			ActivityCompat.requestPermissions(MainActivity.this, 
											  new String[] { permission }, 
											  requestCode); 
		} 
		else { 
			Toast.makeText(MainActivity.this, 
						   "Permission already granted", 
						   Toast.LENGTH_SHORT) 
				.show(); 
		} 
	} 
	
	
	
	

	@Override
	public void onRequestPermissionsResult(int requestCode, 
										   @NonNull String[] permissions, 
										   @NonNull int[] grantResults) 
	{ 
		super
			.onRequestPermissionsResult(requestCode, 
										permissions, 
										grantResults); 

		if (requestCode == cammerapermision) { 
			if (grantResults.length > 0
				&& grantResults[0] == PackageManager.PERMISSION_GRANTED) { 
				Toast.makeText(MainActivity.this, 
							   "Camera Permission Granted", 
							   Toast.LENGTH_SHORT) 
					.show(); 
			} 
			else { 
				Toast.makeText(MainActivity.this, 
							   "Camera Permission Denied", 
							   Toast.LENGTH_SHORT) 
					.show(); 
			} 
		} 
		else if (requestCode == storagepermission) { 
			if (grantResults.length > 0
				&& grantResults[0] == PackageManager.PERMISSION_GRANTED) { 
				Toast.makeText(MainActivity.this, 
							   "Storage Permission Granted", 
							   Toast.LENGTH_SHORT) 
					.show(); 
			} 
			else { 
				Toast.makeText(MainActivity.this, 
							   "Storage Permission Denied", 
							   Toast.LENGTH_SHORT) 
					.show(); 
			} 
		} 
		
		else if (requestCode == locationpermission) { 
			if (grantResults.length > 0
				&& grantResults[0] == PackageManager.PERMISSION_GRANTED) { 
				Toast.makeText(MainActivity.this, 
							   "Location Permission Granted", 
							   Toast.LENGTH_SHORT) 
					.show(); 
			} 
			else { 
				Toast.makeText(MainActivity.this, 
							   "Location  Permission Denied", 
							   Toast.LENGTH_SHORT) 
					.show(); 
			} 
		} 
		
	} 
} 

