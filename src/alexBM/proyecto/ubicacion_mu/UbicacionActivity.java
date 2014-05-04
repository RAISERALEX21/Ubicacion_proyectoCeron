package alexBM.proyecto.ubicacion_mu;

import alexBM.proyecto.GPS.Mi_GPS;
import alexBMB.proyecto.datosDispositivo.Datos_miEquipo;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UbicacionActivity extends Activity {

	private TextView latitud, longitud;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ubicacion);
	}
	
	public void printDatos(View view){
		
		Mi_GPS mi_gps = new Mi_GPS(getApplicationContext());
		Datos_miEquipo mi_datos = new Datos_miEquipo();
		
		latitud = (TextView)findViewById(R.id.cord_latitud);
		longitud = (TextView)findViewById(R.id.cord_longitud);
		
		latitud.setText("" + mi_gps.get_latitud());
		longitud.setText("" + mi_gps.get_longitud());
		
		Toast.makeText(getApplicationContext(), "HORA"+ mi_datos.getHora() +" : " + mi_datos.getMinuto() +" : "+ mi_datos.getSegundo(), Toast.LENGTH_LONG).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ubicacion, menu);
		return true;
	}

}
