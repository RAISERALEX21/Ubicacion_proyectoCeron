package alexBM.proyecto.ubicacion_mu;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;


public class MiLocationListener extends Activity implements LocationListener{
	
	private String lat, lon;
	
	public void onLocationChanged(Location loc)
	{
	loc.getLatitude();
	loc.getLongitude();
	String coordenadas = "Mis coordenadas son:" + "Latitud = " + loc.getLatitude() + "Longitud = " + loc.getLongitude();
	Toast.makeText( getApplicationContext(),coordenadas,Toast.LENGTH_LONG).show();
	
	setLat(String.valueOf(loc.getLatitude()));
	setLon(String.valueOf(loc.getLongitude()));
	
	}
	
	public void onProviderDisabled(String provider)
	{
	Toast.makeText( getApplicationContext(),"Gps Desactivado",Toast.LENGTH_SHORT ).show();
	}
	
	public void onProviderEnabled(String provider)
	{
	Toast.makeText( getApplicationContext(),"Gps Activo",Toast.LENGTH_SHORT ).show();
	}
	
	public void onStatusChanged(String provider, int status, Bundle extras){
	}
	


public String getLat() {
	return lat;
}

public void setLat(String lat) {
	this.lat = lat;
}

public String getLon() {
	return lon;
}

public void setLon(String lon) {
	this.lon = lon;
}
}