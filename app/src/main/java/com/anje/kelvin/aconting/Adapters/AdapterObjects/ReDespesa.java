package com.anje.kelvin.aconting.Adapters.AdapterObjects;

import java.util.Date;

/**
 * Created by sala on 23-02-2018.
 */

public class ReDespesa {
    String descricao,preco;
    Date date;

    public ReDespesa(String descricao, String preco, Date date) {
        this.descricao = descricao;
        this.preco = preco;
        this.date = date;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
