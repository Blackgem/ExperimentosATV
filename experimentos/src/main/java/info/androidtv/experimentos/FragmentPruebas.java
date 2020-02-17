package info.androidtv.experimentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button; //necesario para usar botones
import android.widget.Toast; //necesario para hacer uso de Toast

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPruebas extends Fragment {


    public FragmentPruebas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//con el return que se genera por defecto no pasa hay variable view
//y por lo tanto el codigo siguienga da problemas
        View view = inflater.inflate(R.layout.fragment_fragment_pruebas, container, false);

        // get the widgets reference from Fragment XML layout
        Button mibotontoast = view.findViewById(R.id.MiBoton);
        // Set a click listener for Fragment button
        mibotontoast.setOnClickListener(new View.OnClickListener() {
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
