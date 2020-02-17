package info.androidtv.experimentos.EJRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidtv.experimentos.R; //por estar en otro paquete.
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//    private List<Anime> items; //AnimeCambiar a MyTipoDatos?
    //pruebas
//    private List<String> names; //Para cambiarle por parametro?
    private List<String> items; //Cambiado para entenderlo yo mejor?
    private OnItemClickListener itemClickListener; //todo metido para pruebas con onitemcliok
    private int layout; //todo aadido por pruebas
//todo varX = variable interna solo para usar en ese metodo.

    //metodo principal de la clase creo
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // Elementos UI a rellenar
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;

        public MyViewHolder(View itemViewX) {
            super(itemViewX);
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            imagen = (ImageView) itemViewX.findViewById(R.id.imagen);
            nombre = (TextView) itemViewX.findViewById(R.id.nombre);
            visitas = (TextView) itemViewX.findViewById(R.id.visitas);
        }

        //todo añadido luego para revisar el onclicklistener
        public void bind(final String itemX, final OnItemClickListener listenerX){
            //que se le debe pasar a este?
            //aqui que le pongo, sera que falta el xml?

            // Definimos que por cada elemento de nuestro recycler view, tenemos un click listener
            // que se comporta de la siguiente manera...        itemView.setOnClickListener(new View.OnClickListener(){
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public  void onClick(View view) {
                    // ... pasamos nuestro objeto modelo (este caso String) y posición
                    listenerX.onItemClick(itemX, getAdapterPosition());
                }
            });
        }
    }

    //Especifico de cada adaptador?
    public MyAdapter(List<String> itemsX) {
        this.items = itemsX;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Constructor para inflar la vista que deba mostrar
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroupX, int i) {
        //Variable "v" es solo para almacenar el view a tratar.
        //Para que se usa el parametro i?
        //Modificar el layout R.layout.ALGO al que corresponda.
        View vX = LayoutInflater.from(viewGroupX.getContext())
                .inflate(R.layout.fragment_fragment_recycler_view, viewGroupX, false);
        //viewgroup o parent?
        return new MyViewHolder(vX);
    }

    //Metodo para coger los datos tras cada itineracion?
    @Override
    public void onBindViewHolder(MyViewHolder viewHolderX, int pos) {
        //By Google: Llamado por RecyclerView para mostrar los datos en la posición especificada.
        //Llamado por RecyclerView
        //"pos" es la posicion usada en este metodo
        //Se usa la primera vez, pero no se llama cada vez. No se renderiza en cada accion.
//todo revisar cuando tengan get los que tirar, es lo unico que necesito un adaptador de fuera.
//        viewHolderX.imagen.setImageResource(items.get(pos).getImagen());
//        viewHolderX.nombre.setText(items.get(pos).getNombre());
//        viewHolderX.visitas.setText("Visitas:" + String.valueOf(items.get(pos).getVisitas()));
        //todo
        // Llamamos al método Bind del ViewHolder pasándole objeto y listener
        viewHolderX.bind(items.get(pos), itemClickListener);

    }

    /** implementar interface para onclicklistener para cuando este en main sea aqui nativo
     * muy lioso a mi parecer... o tal vez simplemente se nutra de una actividad que le digamos.
     * Recordar, solo las actividades pueden tener interacciones con el usuario en si.
     */

//    todo sobrecarga con listener para que vaya el onItemClick?
    public MyAdapter(List<String> itemsX, int layoutX, OnItemClickListener listenerX){
        this.items = itemsX;
        this.layout = layoutX;
        this.itemClickListener = listenerX;
    }


//    Este sera sobreeescrito en la actividad creo
    public interface OnItemClickListener {
        void    onItemClick(String item, int position);
    }

}

//todo el onclick deberia simplificarse mejor su codigo, eficiente y mas facil de seguir
//todo tampoco se si es la mejor manera de modificar los datos, habra que modificar en profundidad