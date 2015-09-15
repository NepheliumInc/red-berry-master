package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.RatesDaoImpl;
import com.redberry.mvc.database.Rates;
import com.redberry.mvc.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Lakshan Vithana on 9/11/2015.
 */
public class RatesServiceImpl implements RatesService {

    @Autowired
    private RatesDaoImpl ratesDaoImpl;

    @Transactional
    @Override
    public Response getRates(){
        return Response.ok(ratesDaoImpl.getRates()).build();
    }

    @Transactional
    @Override
    public Response addRates(final Rates[] rates){
        ratesDaoImpl.addRates(rates);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateRates(Rates rates){
        ratesDaoImpl.updateRates(rates);
        return Response.status(Response.Status.CREATED).build();

    }

    @Transactional
    @Override
    public Response removeRates(Rates rates){
        ratesDaoImpl.removeRates(rates);
        return Response.status(Response.Status.GONE).build();
    }



}
