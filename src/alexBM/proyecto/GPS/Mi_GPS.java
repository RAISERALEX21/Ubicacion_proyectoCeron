package alexBM.proyecto.GPS;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

 

public class Mi_GPS extends Thread implements LocationListener{

	Context mi_contexto;
	boolean activo=true;
	int intervalo=3000; //Cada cuantos milisegundo guardara las coordenadas
    LocationManager local;
    String num_unidad="";
    double latitud;
    double longitud;
    double altitud;
    double precision;
    String proveedor;
    
	
	
		public Mi_GPS(Context mi_contexto,String num_unidad){
		
			this.mi_contexto=mi_contexto;
	   	    local = (LocationManager) mi_contexto.getSystemService(Context.LOCATION_SERVICE);
	   	    local.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, Mi_GPS.this);		
		}
		
		
		public Mi_GPS(Context mi_contexto,String num_unidad, int tiempo){
			
			this.mi_contexto=mi_contexto;
			this.num_unidad=num_unidad;
	   	    local = (LocationManager) mi_contexto.getSystemService(Context.LOCATION_SERVICE);
	   	    local.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, Mi_GPS.this);
	   	    intervalo=tiempo;
			
		}
		
		public Mi_GPS(Context mi_contexto)
		{
			this.mi_contexto=mi_contexto;
			local = (LocationManager) mi_contexto.getSystemService(Context.LOCATION_SERVICE);
	   	    local.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, Mi_GPS.this);
			
		}

		
		


		public Mi_GPS(LocationManager localiza,String num_unidad)
		{
			
			/*this.local=localiza;
			this.num_instalador=num_instalador;
			 local.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ClsGPS.this);*/
		}
	
	


	public void run()
	{
	    while(activo)
	    {
	    	 
	    	  Location mi_localizacion=local.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	    	
	    	try{
	    		
	    	   this.sleep(intervalo);	
	    	   
	    	}
	    	catch(Exception e)
	    	{
	    		
	    		
	    	}   
		        try{
		        latitud     = mi_localizacion.getLatitude();
		        altitud     = mi_localizacion.getAltitude();
		        longitud    = mi_localizacion.getLongitude();
		        precision   = mi_localizacion.getAccuracy();
		        proveedor   = mi_localizacion.getProvider();
		        }catch(Exception e)
		        {
		        	 latitud=0.0;
				     longitud=0.0;
				     altitud=0.0;
				     precision = 0.0;
				     proveedor = "NULL";
		        	
		        }
		        
		        
		        Toast.makeText(mi_contexto, mi_localizacion.toString(), Toast.LENGTH_SHORT).show();
		        //servicio_web.SetCoordenadas(latitud+"", longitud+"", altitud+"","S","0",num_instalador,"1","today", "current");	
	    		
		        try{    		
			    	   this.sleep(intervalo);	   
			    	}
			    	catch(Exception e)
			    	{}
	    }
	}
public void get_coordenadas()
{
	
	 Location mi_localizacion=local.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	 try{
	        latitud     = mi_localizacion.getLatitude();
	        altitud     = mi_localizacion.getAltitude();
	        longitud    = mi_localizacion.getLongitude();
	        precision   = mi_localizacion.getAccuracy();
	        proveedor   = mi_localizacion.getProvider();
	        }catch(Exception e)
	        {
	        	 latitud   = 0.0;
			     longitud  = 0.0;
			     altitud   = 0.0;
			     precision = 0.0;
			     proveedor = "NULL";
	        	
	        }

}
	

public double getPrecision() {
	return precision;
}


public String getProveedor() {
	return proveedor;
}

public double get_Precision() {
	return precision;
}

public double get_latitud()
{
	return latitud;
}

public double get_longitud()
{
   return longitud;	
}

public double get_altitud()
{
  return altitud;	
}
	
	
public void finaliza()
{
  activo = false;	
}

@Override
public void onLocationChanged(Location location) {
	// TODO Auto-generated method stub
	
}

@Override
public void onProviderDisabled(String provider) {
	// TODO Auto-generated method stub
	
}

@Override
public void onProviderEnabled(String provider) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
	// TODO Auto-generated method stub
	
}
	
	
}
