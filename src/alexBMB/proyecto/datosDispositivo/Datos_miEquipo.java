package alexBMB.proyecto.datosDispositivo;

import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

public class Datos_miEquipo extends Activity{

	private String hora;
	private String minuto;
	private String segundo;
	
	private String dia;
	private String mes;
	private String ano;
	
	private String IMEI;
	
	public void fecha(){
		
		Date horaActual=new Date();
		
			hora    = String.valueOf(horaActual.getHours());
			minuto  = String.valueOf(horaActual.getMinutes());
			segundo = String.valueOf(horaActual.getSeconds());
			
			dia     = String.valueOf(horaActual.getDay());
			mes     = String.valueOf(horaActual.getMonth());
			ano     = String.valueOf(horaActual.getYear());
			
	}
	
	@SuppressLint("ServiceCast")
	public void IMEI(){
		TelephonyManager imei = (TelephonyManager)getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);		
		String IMEI = imei.getDeviceId(); 
	}

	public String getHora() {
		return hora;
	}

	public String getMinuto() {
		return minuto;
	}

	public String getSegundo() {
		return segundo;
	}

	public String getDia() {
		return dia;
	}

	public String getMes() {
		return mes;
	}

	public String getAno() {
		return ano;
	}

	public String getIMEI() {
		return IMEI;
	}
	
	
	
	
}
