package info.androidtv.experimentos.Kawaii;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidtv.experimentos.R;


/**
 * Modificado por mi para meter Cardview en Fragment
 * Tambien se adapto un xml el cual basto con copiar el contenido de cardview normal.
 *     tools:context=".MainActivity"> del xml es lo unico chirriante
 *     pero aun cambiandolo no sin acciones que lo requieran no afecta al parecer
 *     Parece que no puedo hacer desde alli referencia a esta clase autorrellenable,
 *     eso no lo tengo claro.
 */

/**
 * Vista para los leads del CRM
 */
public class CardViewFragment extends Fragment {
    private ListView mLeadsList;
    private AnimeAdapter mLeadsAdapter;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    public CardViewFragment() {
        // Required empty public constructor
    }

    public static CardViewFragment newInstance(/*parámetros*/) {
        CardViewFragment fragment = new CardViewFragment();
        // Setup parámetros
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Gets parámetros
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cardview, container, false);

//        // Instancia del ListView.
//        mLeadsList = (ListView) root.findViewById(R.id.leads_list);
//
//        // Inicializar el adaptador con la fuente de datos.
//        mLeadsAdapter = new AnimeAdapter(getActivity(),
//                LeadsRepository.getInstance().getLeads());
//
//        //Relacionando la lista con el adaptador
//        mLeadsList.setAdapter(mLeadsAdapter);
//
//        // Eventos
//        mLeadsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Lead currentLead = mLeadsAdapter.getItem(position);
//                Toast.makeText(getActivity(),
//                        "Iniciar screen de detalle para: \n" + currentLead.getName(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });



        List items = new ArrayList();

        items.add(new Anime(R.drawable.angel, "Angel Beats", 230));
        items.add(new Anime(R.drawable.death, "Death Note", 456));
        items.add(new Anime(R.drawable.fate, "Fate Stay Night", 342));
        items.add(new Anime(R.drawable.nhk, "Welcome to the NHK", 645));
        items.add(new Anime(R.drawable.suzumiya, "Suzumiya Haruhi", 459));

// Obtener el Recycler
        recycler = (RecyclerView) root.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new AnimeAdapter(items);
        recycler.setAdapter(adapter);

//        setHasOptionsMenu(true);
        return root;
    }
}