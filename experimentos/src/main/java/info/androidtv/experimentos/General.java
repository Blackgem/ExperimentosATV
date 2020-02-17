package info.androidtv.experimentos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class General {
    //    Clase solo para incluir metodos generales no muy complejos
    //    que se usen habitualmente.
    //    Pedir permisos
    //    Error permisos
    //    Toast
    //    Pruebas
    //    Emergente simple
    //    Emergente personalizable
    //    Salir seguro
    //    Intent?
//    public void DialogoPruebas(final String mensaje) {
//        new AlertDialog.Builder(this)
//                .setTitle("Titulo: "+mensaje)
//                .setMessage("¿Que quieres hacer?")
//                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
////                        AccionARealizar();//Algo que quiera hacerse sino quitar.
////                        finish();
//                    }})
//                .setNegativeButton("Cancelar", null)
//                .show();
//    }

//    public void borrarLugar(final int id) {
//
//        new AlertDialog.Builder(this)
//                .setTitle("Borrado de lugar")
//                .setMessage("¿Estás seguro que quieres eliminar este lugar?")
//                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        MainActivity.lugares.borrar((int) id);
////                        finish();
//                    }})
//                .setNegativeButton("Cancelar", null) //Cancelar simplemente terminaria.
//                .show();
//    }
//
//    public void miToast(View view){
//        Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show();
//    }
//
//    public void miToast(View view){
//        Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show();
//        Toast toast=Toast.makeText(getApplicationContext(),"Hello", Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0); // last two args are X and Y are used for setting position
//        toast.setDuration(10000);//you can even use milliseconds to display toast
//        toast.show();**//showing the toast is important**
////        Toast.makeText(getActivity().getApplicationContext(), "SMS sent.",Toast.LENGTH_LONG).show();
//
//    }

//    Metodo para mostrar mensaje predefinido
//    Contexto obtenido para pasarselo mediante este codigo:
//    final Context contextob1 = b1.getContext();
    public static void mensaje(Context context){
        String mensaje="Mensaje Predefinido";
        Toast.makeText(context, ""+mensaje, Toast.LENGTH_SHORT).show();
    //llamar con general.mensaje(this);
    }

    //Metodo para mostrar mensaje personalizado pasado por parametro
    //llamar con General.mensaje(this, "mensaje a enviar");
    public static void mensaje(Context context, String mensaje){
        Toast.makeText(context, ""+mensaje, Toast.LENGTH_SHORT).show();
    }


//    https://developer.android.com/reference/android/app/AlertDialog.Builder
    public static void DialogoPruebas(Context contexto, final String mensaje) {
    new AlertDialog.Builder(contexto)
            .setTitle("Titulo: "+mensaje)
            .setMessage("¿Que quieres hacer?")
            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
//                        AccionARealizar();//Algo que quiera hacerse sino quitar.
//                        finish();
                }})
            .setNegativeButton("Cancelar", null)
//            .setNegativeButton("Toast", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int whichButton) {
////                        AccionARealizar();//Algo que quiera hacerse sino quitar.
////                        finish();
//
//                    Context contexto2 = contexto;
//                    mensaje(contexto2,"mensaje desde dialogo");
//                }})
            .show();
    }

    public static void instalarpaquete(Context contexto, String paquete) {
        final Uri marketUri = Uri.parse("market://details?id=" + paquete);
        contexto.startActivity(new Intent(Intent.ACTION_VIEW, marketUri));
    }     //llamar con General.instalarpaquete(getactivity(), "com.antena3.atresplayer.tv");


//        public class GoogleServicesUtils {
//
//            public static void openAppInGooglePlay(Context context) {
//                final String appPackageName = context.getPackageName();
//                try {
//                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//                } catch (android.content.ActivityNotFoundException e) { // if there is no Google Play on device
//                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//                }
//            }
//

//        Buscar aplicacion en el market
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=" + query)));


    //Obliga a elegir con que ejecutar, 1= eleccion obligada, 0= normal guardado en el sistema.
    public static void instalarpaquete(Context contexto, String paquete, Integer elegir) {
//        final Uri marketUri = Uri.parse("market://details?id=" + paquete);
        if (elegir==2) {
            contexto.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + paquete)));
        }
        if (elegir==3) {
        contexto.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(paquete)));
        }
        if (elegir==1) {
//            contexto.startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, marketUri), "Elige con que ejecutar:"));
            contexto.startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + paquete)), "Elige con que ejecutar:"));

        } else {
//            contexto.startActivity(new Intent(Intent.ACTION_VIEW, marketUri));
//            contexto.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + paquete)));
        }
    }


    /**
     * Crea un Diálogo con una lista de selección simple
     *
     * @return La instancia del diálogo
     */
//    public AlertDialog createSingleListDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
//        final CharSequence[] items = new CharSequence[3];
//
//        items[0] = "Naranja";
//        items[1] = "Mango";
//        items[2] = "Banano";
//
//        builder.setTitle("Diálogo De Lista")
//                .setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(
//                                getActivity(),
//                                "Seleccionaste:" + items[which],
//                                Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                });
//
//        return builder.create();
//    }



    //    Para test
//    @Override protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override protected void onPause() {
//        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
//        super.onPause();
//    }
//
//    @Override protected void onStop() {
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
//        super.onStop();
//    }
//
//    @Override protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override protected void onDestroy() {
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
//        super.onDestroy();
//    }
    //Metodos anteriores para tests

}
