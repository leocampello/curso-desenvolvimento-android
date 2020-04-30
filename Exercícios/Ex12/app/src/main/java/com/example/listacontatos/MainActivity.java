package com.example.listacontatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listview_contatos;
    private EditText edt_nome;
    private EditText edt_telefone;
    private CheckBox cbx_fixo;

    private ArrayList<Contato> contatos;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview_contatos = (ListView) findViewById(R.id.listview_contatos);
        edt_nome = (EditText) findViewById(R.id.edt_nome);
        edt_telefone = (EditText) findViewById(R.id.edt_telefone);
        cbx_fixo = (CheckBox) findViewById(R.id.cbx_fixo);

        contatos = new ArrayList<Contato>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contatos);
        listview_contatos.setAdapter(arrayAdapter);

        AdapterView.OnItemLongClickListener itemClickListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int localPosition = position;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Remover contato da lista")
                        .setMessage("Você realmente deseja remover este contato da lista?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                contatos.remove(localPosition);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();

                return true;
            }
        };

        listview_contatos.setOnItemLongClickListener(itemClickListener);
    }

    public void addProdutos(View view) {
        String nome = edt_nome.getText().toString();
        String telefone = edt_telefone.getText().toString();
        boolean fixo = cbx_fixo.isChecked();
        int count = 0;

        Contato c = new Contato(nome, telefone, fixo);

        if(fixo) {
            for (int i = 0; i < contatos.size(); i++)
                if (contatos.get(i).isFixo())
                    count++;

            if (count < 3)
                contatos.add(0, c);
            else {
                Toast.makeText(this, "Número de contatos fixos excedido. Novo contato adicionado ao final da lista.", Toast.LENGTH_SHORT).show();
                c.setFixo(false);
                contatos.add(c);
            }
        } else
            contatos.add(c);

        arrayAdapter.notifyDataSetChanged();
    }

}
