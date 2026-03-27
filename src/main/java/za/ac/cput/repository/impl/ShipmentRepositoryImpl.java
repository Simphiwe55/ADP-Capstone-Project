package za.ac.cput.repository.impl;

/**
 * ShipmentRepositoryImpl.java
 * Repository implementation for Shipment
 * Author: Simphiwe (221549323)
 * Date: 26 March 2026
 */

import za.ac.cput.domain.Shipment;
import za.ac.cput.repository.ShipmentRepository;

import java.util.HashSet;
import java.util.Set;

public class ShipmentRepositoryImpl implements ShipmentRepository {

    private static ShipmentRepositoryImpl repository = null;
    private Set<Shipment> shipmentDB = null;

    private ShipmentRepositoryImpl() {
        shipmentDB = new HashSet<>();
    }

    public static ShipmentRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ShipmentRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Shipment create(Shipment shipment) {
        boolean added = shipmentDB.add(shipment);
        if (!added) return null;
        return shipment;
    }

    @Override
    public Shipment read(String shipmentId) {
        return shipmentDB.stream()
                .filter(shipment -> shipment.getShipmentId().equals(shipmentId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Shipment update(Shipment shipment) {
        Shipment oldShipment = read(shipment.getShipmentId());
        if (oldShipment != null) {
            shipmentDB.remove(oldShipment);
            shipmentDB.add(shipment);
            return shipment;
        }
        return null;
    }

    @Override
    public boolean delete(String shipmentId) {
        Shipment shipmentToDelete = read(shipmentId);
        if (shipmentToDelete == null) return false;
        shipmentDB.remove(shipmentToDelete);
        return true;
    }

    @Override
    public Set<Shipment> getAll() {
        return shipmentDB;
    }
}