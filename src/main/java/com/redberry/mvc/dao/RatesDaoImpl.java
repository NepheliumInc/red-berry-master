package com.redberry.mvc.dao;

import com.redberry.mvc.database.Rates;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lakshan Vithana on 9/11/2015.
 */
public class RatesDaoImpl implements RatesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRates(Rates[] rates){
        for(Rates r: rates) {
            sessionFactory.getCurrentSession().saveOrUpdate(r);
        }
    }

    @Override
    public List<Rates> getRates(){
        List<Rates> rateList=sessionFactory.getCurrentSession().createCriteria(Rates.class).list();
        return rateList;
    }

    @Override
    public void updateRates(Rates rates){
        sessionFactory.getCurrentSession().update(rates);
    }

    @Override
    public void removeRates(Rates rates){
        sessionFactory.getCurrentSession().delete(rates);
    }


}
