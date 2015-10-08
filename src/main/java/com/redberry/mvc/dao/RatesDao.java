package com.redberry.mvc.dao;

import com.redberry.mvc.database.Rates;

import java.util.List;

/**
 * Created by Lakshan Vithana on 9/11/2015.
 */
public interface RatesDao {

    public void addRates(Rates[] rates);
    public List<Rates> getRates();
    public void updateRates(Rates rates);
    public void removeRates(Rates rates);
}
