package info.androidtv.experimentos;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    public Fragment3() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragment3, container, false);
//
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //con el return que se genera por defecto no pasa hay variable view
        //y por lo tanto el codigo siguienga da problemas
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        // get the widgets reference from Fragment XML layout


        Button b1 = view.findViewById(R.id.B1);
        b1.setText("Texto de misma clase");
        // Set a click listener for Fragment button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear mensaje del Toast
                Toast toast = Toast.makeText(
                        //getActivity(),"Custom Toast From Fragment",Toast.LENGTH_LONG
                        getActivity().getApplicationContext(), "Toast de Pruebas para que veas", Toast.LENGTH_LONG
                );
                // Set the Toast display position layout center
                toast.setGravity(Gravity.CENTER,0,0);
                // Mostrar Toast
                toast.show();
            }
        });

        //todo como pasar contexto, view o algo para que se ejecute algo de otra clase.
        Button b2 = view.findViewById(R.id.B2);
        b2.setText("Cuadro de Dialogo");
        final Context contextob2 = b2.getContext();
        b2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  General.DialogoPruebas(contextob2, "personalizado");
              }
        });

        Button b3 = view.findViewById(R.id.B3);
        b3.setText("Texto personalizado");
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.mensaje(getActivity(), "mensaje personalizado");
            }
        });

        Button b4 = view.findViewById(R.id.B4);
        b4.setText("Instalar paquete");
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                General.mensaje(getActivity(), "mensaje personalizado");
                General.instalarpaquete(getActivity(), "com.antena3.atresplayer.tv");
            }
        });

        Button b5 = view.findViewById(R.id.B5);
        b5.setText("Instalar paquete eligiendo obligatoriamente");
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                General.mensaje(getActivity(), "mensaje personalizado");
                General.instalarpaquete(getActivity(), "com.antena3.atresplayer.tv", 1);
            }
        });

        Button b6 = view.findViewById(R.id.B6);
        b6.setText("Abrir url via navegador");
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                General.mensaje(getActivity(), "mensaje personalizado");
                General.instalarpaquete(getActivity(), "https://www.amazon.es/appstore", 3);
            }
        });



        // Return the view as Fragment layout
        return view; //return del layout del inflater
//        Ejemplo directo de Google
//        Button button = (Button) findViewById(R.id.button_send);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Do something in response to button click
//            }
//        });
    }

}
