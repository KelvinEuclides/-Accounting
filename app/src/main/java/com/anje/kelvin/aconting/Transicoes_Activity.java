package com.anje.kelvin.aconting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.anje.kelvin.aconting.Adapters.AdapterTransicoes;
import com.anje.kelvin.aconting.Adapters.Transacao_itens;
import com.anje.kelvin.aconting.BaseDeDados.Conta;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class Transicoes_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    public List<Transacao_itens> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transicoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rv_transicoes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);
        lista = new ArrayList<Transacao_itens>();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Conta> contas = realm.where(Conta.class).findAll();
        if (contas.get(0).getStock().size() > 0) {
            for (int i = 0; i < contas.get(0).getTransacaoDbs().size(); i++) {
                Conta conta = contas.get(0);
                Transacao_itens transacao = new Transacao_itens(conta.getTransacaoDbs().get(i).getDescricao(), conta.getTransacaoDbs().get(i).getCategoria(), conta.getTransacaoDbs().get(i).getValor());
                lista.add(transacao);
            }

            }
        adapter = new AdapterTransicoes(lista,Transicoes_Activity.this);
        recyclerView.setAdapter(adapter);

        }

    }

