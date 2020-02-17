package info.androidtv.experimentos;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

//Crear asi clase de ayuda con metodos habituales independientes de test y pruebas.


//Extiende de actividad, no se como puede afectar ello)
public class Dialogo extends Activity {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        createAndShowAlertDialog();
    }


    //Metida a lo loco, adaptada de apuntes y MisLugares
    public void DialogoPruebas(final String mensaje) {
        //Habria que mirar de pasarle un contexto pues aqui no tiene.
        new AlertDialog.Builder(this)
                .setTitle("Titulo: "+mensaje)
                .setMessage("¿Que quieres hacer?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
//                        AccionARealizar();//Algo que quiera hacerse sino quitar.
                        finish();
                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }

    //Cogida de Libreelec
    private void createAndShowAlertDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Reiniciar a LibreELEC?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
//                Dialogo.sudo("reboot update");//Algo a realizar
                dialog.dismiss();
                finish(); //Para cerrar bien la app?
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                System.exit(0);
                finish(); //Para cerrar bien la app?
            }
        });
        builder.create().show();
    }

    //Al ser llamado genere un toast
    public void sePulsa(View view){
        Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show();
    }

    public void lanzaraplicacion() {
//        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.test);
//        if (launchIntentForPackage != null) {
        //Esto al incluirlo machaca la configuracion que deberia ser usada anteriormente.
//            Intent launchIntentForPackage = org.videolan.vlc;
        Intent launchIntentForPackage = new Intent();
        launchIntentForPackage.setComponent(new ComponentName("com.nvidia.nvgamecast", "com.nvidia.nvgamecast.GamecastActivity"));
        startActivity(launchIntentForPackage);
//        } else {
//            Toast.makeText(this, "Aplicacion \"" + this.test + "\" no encontrada!", 1).show();
//        }
        finish();
    }

}
