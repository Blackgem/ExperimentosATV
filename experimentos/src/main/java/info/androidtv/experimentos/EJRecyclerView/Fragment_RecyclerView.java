package info.androidtv.experimentos.EJRecyclerView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidtv.experimentos.MainActivity;
import info.androidtv.experimentos.R;

///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link Fragment_RecyclerView.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link Fragment_RecyclerView#newInstance} factory method to
// * create an instance of this fragment.
// */






public class Fragment_RecyclerView extends Fragment {

    private RecyclerView cRecyclerView;
    private List<String> items;
    private RecyclerView.LayoutManager cLmanager;
    private RecyclerView.Adapter cAdapter;


    public Fragment_RecyclerView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);

        //variable private del fragmento, tal vez haya que poner antes del inglater.
        items = this.getAllNames();//coge los valores.
        //todo aqui ponen para lo de itemclick...
        //todo pero creo que se puede poner con onbindwiewholder en el adapter
        //todo y luego sobreeescribir en la actividad el onclick

        //todo esto deberia borrarse.
//        List items = new ArrayList();
//        items.add(new MyAdapter(R.drawable.ic_launcher_background, "Angel Beats", null));
//        items.add(new MyAdapter(R.drawable.death, "Death Note", 456));
//        items.add(new MyAdapter(R.drawable.fate, "Fate Stay Night", 342));
//        items.add(new MyAdapter(R.drawable.nhk, "Welcome to the NHK", 645));
//        items.add(new MyAdapter(R.drawable.suzumiya, "Suzumiya Haruhi", 459));

// Obtener el Recycler
        cRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        cRecyclerView.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        cLmanager = new LinearLayoutManager(getActivity());
        cRecyclerView.setLayoutManager(cLmanager);



        // Implementamos nuestro OnItemClickListener propio, sobreescribiendo el método que nosotros
        // definimos en el adaptador, y recibiendo los parámetros que necesitamos
        cAdapter = new MyAdapter(items, R.layout.anime_card, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Toast.makeText(getActivity().getApplicationContext(), name + " - " + position, Toast.LENGTH_LONG).show();
//                deleteName(position);
            }
        });
//reciclamos layout de las cartas?




// Crear un nuevo adaptador
        cAdapter = new MyAdapter(items);
        cRecyclerView.setAdapter(cAdapter);



        return view;
    }


//esto no lo habia usado pero es una "base de datos" simple
    private List<String> getAllNames(){
        return new ArrayList<String>() {{
        add("Alejandro");
        add("Alejandro1");
        add("Alejandro2");
        add("Alejandro3");
        add("Alejandro4");
        add("Alejandro5");
        add("Alejandro6");
        add("Alejandro7");
        add("Alejandro8");
        }};
    }

}


//todo esto es lo autogenerado
//public class Fragment_RecyclerView extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public Fragment_RecyclerView() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Fragment_RecyclerView.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Fragment_RecyclerView newInstance(String param1, String param2) {
//        Fragment_RecyclerView fragment = new Fragment_RecyclerView();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
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
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//}
