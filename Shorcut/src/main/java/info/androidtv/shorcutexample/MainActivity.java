/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package info.androidtv.shorcutexample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.content.pm.PackageManager.NameNotFoundException;

/*
 * MainActivity class that loads {@link MainFragment}.
 */
public class MainActivity extends Activity{

//    String test = "org.videolan.vlc";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.test);
//        if (launchIntentForPackage != null) {
            //Esto al incluirlo machaca la configuracion que deberia ser usada anteriormente.
//            Intent launchIntentForPackage = org.videolan.vlc;
        //todo metodo para comprobar si esta paquete.
//        final String paquete = "com.nvidia.nvgamecast";
//        final String actividadpaquete ="com.nvidia.nvgamecast.GamecastActivity";
        final String paquete = "com.android.chrome"; //todo en un futuro cambiar a xml la variable
        //todo incluso crear version que te pida el nombre del paquete a iniciar la primera vez que ejecutes la app ( borrar datos para reiniciar ese valor).
        //App atajo 1 Atajo 2, Atajo 3..., la primera gratuita, el resto a 50 centimos.
//        final String actividadpaquete ="com.android.tv.settings.MainSettings";
//        if (isPackageInstalled(paquete,this) == true) {
//                        Intent launchIntentForPackage = new Intent();
//            launchIntentForPackage.setComponent(new ComponentName(paquete, actividadpaquete));
//            startActivity(launchIntentForPackage);

        //Iniciar actividad inferior nueva copiada de web
        startNewActivity(this, paquete);


        //Funciona!!!, para que busque el Main especifico de la app (los servicios y de apoyo no tienen).
//        Intent intent = this.getPackageManager().getLaunchIntentForPackage(paquete);
//        this.startActivity(intent);

        }
        //todo si true para delante, si false mensaje y salir.
//            Intent launchIntentForPackage = new Intent();
//            launchIntentForPackage.setComponent(new ComponentName("com.nvidia.nvgamecast", "com.nvidia.nvgamecast.GamecastActivity"));
//            startActivity(launchIntentForPackage);
//        } else {
//            Toast.makeText(this, "Aplicacion \"" + this.test + "\" no encontrada!", 1).show();
//        }
//        finish();


//    }

    // Where “packagename” is the package name of the Twitch app:

    private boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            //todo toast esta paquete
//                Toast.makeText(this, "Paquete encontrado", Toast.LENGTH_LONG).show();
                return true;
        } catch (NameNotFoundException e) {
            //todo toast no esta paquete
            Toast.makeText(this, "Dispositivo no compatible / Device not compatible", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    //https://stackoverflow.com/questions/3872063/how-to-launch-an-activity-from-another-application-in-android
    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            // Bring user to the market or let them choose an app?
            Toast.makeText(this, "Aplicacion no encontrada / App not found", Toast.LENGTH_LONG).show(); //Añadido por mi
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}

