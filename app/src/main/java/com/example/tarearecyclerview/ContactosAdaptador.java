package com.example.tarearecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactosAdaptador extends RecyclerView.Adapter <ContactosAdaptador.ModeloViewHolder> {

    private final ArrayList <Contactos> listaContactos;

    public ContactosAdaptador(ArrayList<Contactos> listaContactos) {
        this.listaContactos = listaContactos;
    }

    // Vista de la subclase y conexión con los views
    @NonNull
    @Override
    public ContactosAdaptador.ModeloViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        // Inflar la vista
        View itemView = LayoutInflater.from ( parent.getContext ()).inflate ( R.layout.mostrar_contactos , parent, false );
        return new ModeloViewHolder(itemView);
    }

    // Asocia los datos de los elementos de la colección a cada una de las vistas del ViewHolder.
    @Override
    public void onBindViewHolder(@NonNull ContactosAdaptador.ModeloViewHolder holder , int position) {
        // Obtener el modelo de contacto en la posición dada
        Contactos contacto = listaContactos.get(position);
        holder.nombre.setText(contacto.getNombre ());
        holder.apellidos.setText(contacto.getApellidos ());
        holder.email.setText(contacto.getEmail ());
        holder.telefono.setText(contacto.getTelefono ());
        holder.foto.setImageResource(contacto.getFoto ());
    }

    // Devuelve la cantidad de elementos
    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    // ViewHolder para gestionar los elementos de cada item
    public static class ModeloViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView apellidos;
        private final TextView email;
        private final TextView telefono;
        private final ImageView foto;
        public ModeloViewHolder(View itemView) {
            super (itemView);
            nombre = itemView.findViewById ( R.id.nombre );
            apellidos = itemView.findViewById ( R.id.apellidos );
            email = itemView.findViewById ( R.id.email );
            telefono = itemView.findViewById ( R.id.telefono);
            foto = itemView.findViewById ( R.id.imagen );
        }
    }
}
