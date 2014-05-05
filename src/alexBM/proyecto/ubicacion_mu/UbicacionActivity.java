package alexBM.proyecto.ubicacion_mu;

import java.util.Date;

import alexBM.proyecto.GPS.Mi_GPS;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UbicacionActivity extends Activity {

	private TextView latitud, longitud;
	private String lat, lon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ubicacion);
	}
	
	public void printDatos(View view){
		
		MiLocationListener mi_gps = new MiLocationListener();
		
		latitud = (TextView)findViewById(R.id.cord_latitud);
		longitud = (TextView)findViewById(R.id.cord_longitud);
		
		LocationManager mi_ubicacionM = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		LocationListener mi_ubicacionL = new MiLocationListener();
		
		mi_ubicacionM.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mi_ubicacionL);
		
		
		
		latitud.setText("" + mi_gps.getLat());
		longitud.setText("" + mi_gps.getLon());
		
		//TOMANDO DATOS DE HORA DEL DISPOSITIVO
		Date horaActual = new Date();
		
		String hora = String.valueOf(horaActual.getHours());
		String minuto = String.valueOf(horaActual.getMinutes());
		String segundo = String.valueOf(horaActual.getSeconds());
		
		String dia = String.valueOf(horaActual.getDay());
		String mes = String.valueOf(horaActual.getMonth());
		String ano = String.valueOf(horaActual.getYear());
		
		
		
		Toast.makeText(getApplicationContext(), " HORA  "+ hora +" : " + minuto +" : "+ segundo, Toast.LENGTH_LONG).show();
		
	}
	
	
	
	@SuppressLint("ServiceCast")
	public void IMEI(){
		TelephonyManager imei = (TelephonyManager)getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);		
		String IMEI = imei.getDeviceId(); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ubicacion, menu);
		return true;
	}

}
