package com.example.tarearecyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_main );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ) , (v , insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars () );
            v.setPadding ( systemBars.left , systemBars.top , systemBars.right , systemBars.bottom );
            return insets;
        } );

        // Crear lista contactos
        ArrayList <Contactos> listaContactos = new ArrayList<> ();
        listaContactos.add(new Contactos ("Juan", "Pérez", "juan.perez@email.com", "123456789", R.drawable.caricatura1));
        listaContactos.add(new Contactos ("Carlos", "Gómez", "carlos.gomez@email.com", "987654321", R.drawable.caricatura2));
        listaContactos.add(new Contactos ("Miguel", "López", "miguel.lopez@email.com", "112233445", R.drawable.caricatura3));
        listaContactos.add(new Contactos ("Pedro", "Martínez", "pedro.martinez@email.com", "998877665", R.drawable.caricatura4));
        listaContactos.add(new Contactos ("David", "Sánchez", "david.sanchez@email.com", "556677889", R.drawable.caricatura5));
        listaContactos.add(new Contactos ("Andrés", "Hernández", "andres.hernandez@email.com", "223344556", R.drawable.caricatura6));
        listaContactos.add(new Contactos ("José", "Ramírez", "jose.ramirez@email.com", "334455667", R.drawable.caricatura7));
        listaContactos.add(new Contactos ("Luis", "Torres", "luis.torres@email.com", "445566778", R.drawable.caricatura8));
        listaContactos.add(new Contactos ("Fernando", "Díaz", "fernando.diaz@email.com", "556677889", R.drawable.caricatura9));
        listaContactos.add(new Contactos ("Antonio", "Ruiz", "antonio.ruiz@email.com", "667788990", R.drawable.caricatura10));

        // Crear el adaptador y pasar el listener
        ContactosAdaptador adaptador = new ContactosAdaptador(listaContactos, new ContactosAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Contactos contacto, int position) {
                // Mostrar un Toast con la información del contacto
                Toast.makeText(MainActivity.this, "Contacto: " + contacto.getNombre() + " " + contacto.getApellidos() + "\nEmail: " + contacto.getEmail() + "\nTeléfono: " + contacto.getTelefono(), Toast.LENGTH_SHORT).show();
            }
        });

        // Instanciar el RecyclerView y asignar el adaptador
        RecyclerView recyclerView = findViewById(R.id.reciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
    }
}