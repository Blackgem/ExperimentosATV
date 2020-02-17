package info.androidtv.experimentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import info.androidtv.experimentos.ItemFragment.OnListFragmentInteractionListener;
import info.androidtv.experimentos.dummy.DummyContent;

//Usado casi siempre
//    public class MainActivity extends AppCompatActivity {

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Con este se conseguiria mostrar el fragment1 solo, peero queremos que sean 2
//        setContentView(R.layout.fragment_fragment1);


    }

    //usado por itemfragment al ser implementado
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}

