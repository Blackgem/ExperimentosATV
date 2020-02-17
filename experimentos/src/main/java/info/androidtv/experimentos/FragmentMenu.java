package info.androidtv.experimentos;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMenu extends Fragment {


    public FragmentMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragment_menu, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_menu, container, false);


        Button b1 = view.findViewById(R.id.button3);
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

        Button b5 = view.findViewById(R.id.button5);
        b5.setText("URL");
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.instalarpaquete(getActivity(), "https://www.amazon.es/appstore", 3);
//                General.instalarpaquete(getActivity(), "https://www.amazon.es", 3);

            }
        });

        Button b6 = view.findViewById(R.id.button6);
        b6.setText("Pruebas Cambio Fragment");
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fragmenthijo = new Fragment3();
//                FragmentTransaction transaction = ((Fragment1) context).getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragmentcontenedor, fragmenthijo ).commit();
//                FragmentManager manager = getSupportFragmentManager();
//tal vez necesite ser puesto mediante codigo en el main activity para realizar estas funciones.
            }
        });


        Button b4 = view.findViewById(R.id.button4);
        b4.setText("Paquete");
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                General.mensaje(getActivity(), "mensaje personalizado");
                General.instalarpaquete(getActivity(), "com.antena3.atresplayer.tv", 2);
            }
        });




        return view;
    }

}
