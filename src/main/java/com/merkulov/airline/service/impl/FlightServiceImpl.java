package com.merkulov.airline.service.impl;

import com.merkulov.airline.entity.Flight;
import com.merkulov.airline.repository.FlightRepository;
import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.service.FlightService;

import java.sql.SQLException;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    private TransactionManager transactionManager;
    private FlightRepository flightRepository;

    public FlightServiceImpl(TransactionManager transactionManager, FlightRepository flightRepository) {
        this.transactionManager = transactionManager;
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlight()  {
        return transactionManager.transaction(
                connection -> flightRepository.getAllFlight(connection)
        );
    }

    @Override
    public boolean addFlight(Flight flight)  {
        return transactionManager.transaction(
                connection -> flightRepository.addFlight(connection, flight)
        );
    }

    @Override
    public boolean removeFlight(Flight flight) {
        return false;
    }
}
