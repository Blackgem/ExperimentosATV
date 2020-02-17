package info.androidtv.experimentos;

import android.content.Context;
import android.net.Uri;
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
 * Activities that contain this fragment must implement the
 * {@link Fragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //        Notas: en el curso explicaban que esto es mejor asi.
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        //return inflater.inflate(R.layout.fragment_fragment1, container, false);




/**
 * Probando transicion de fragment
 */




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


        Button b6 = view.findViewById(R.id.button6);
        b6.setText("Pruebas Cambio Fragment");
//        b6.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Fragment fragmenthijo = new Fragment3();
////                FragmentTransaction transaction = ((Fragment1) context).getSupportFragmentManager().beginTransaction();
////                transaction.replace(R.id.fragmentcontenedor, fragmenthijo ).commit();
////            }
//        });



        // Return the view as Fragment layout
        return view;

    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    NOTAS: Con este metodo activo en un fragment peta en tiempo de ejecucion
//    Aunque aun no entienda el porque aun.
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }











}

