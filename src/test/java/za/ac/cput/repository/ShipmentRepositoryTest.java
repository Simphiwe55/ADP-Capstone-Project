package za.ac.cput.repository;

/**
 * ShipmentRepositoryTest.java
 * Test class for ShipmentRepository
 * Author: Simphiwe (221549323)
 * Date: 27 March 2026
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ShipmentFactory;
import za.ac.cput.repository.impl.ShipmentRepositoryImpl;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ShipmentRepositoryTest {

    private ShipmentRepository repository;
    private Shipment shipment;

    @BeforeEach
    public void setUp() {
        repository = ShipmentRepositoryImpl.getRepository();


        Set<Shipment> existingShipments = repository.getAll();
        for (Shipment s : existingShipments) {
            repository.delete(s.getShipmentId());
        }


        shipment = ShipmentFactory.createShipment(
                "S123",
                "O456",
                LocalDate.of(2026, 3, 10),
                LocalDate.of(2026, 3, 15),
                "In Transit",
                "DHL"
        );
    }

    @Test
    public void testCreate() {
        Shipment created = repository.create(shipment);
        assertNotNull(created);
        assertEquals(shipment.getShipmentId(), created.getShipmentId());
    }

    @Test
    public void testRead() {
        repository.create(shipment);
        Shipment read = repository.read(shipment.getShipmentId());
        assertNotNull(read);
        assertEquals(shipment.getShipmentId(), read.getShipmentId());
    }

    @Test
    public void testUpdate() {
        repository.create(shipment);
        Shipment updatedShipment = new Shipment.Builder()
                .copy(shipment)
                .setStatus("Delivered")
                .build();
        Shipment updated = repository.update(updatedShipment);
        assertNotNull(updated);
        assertEquals("Delivered", updated.getStatus());
    }

    @Test
    public void testDelete() {
        repository.create(shipment);


        Shipment beforeDelete = repository.read(shipment.getShipmentId());
        assertNotNull(beforeDelete);


        boolean deleted = repository.delete(shipment.getShipmentId());
        assertTrue(deleted);


        Shipment afterDelete = repository.read(shipment.getShipmentId());
        assertNull(afterDelete);
    }

    @Test
    public void testGetAll() {

        repository.create(shipment);


        Set<Shipment> allShipments = repository.getAll();
        assertFalse(allShipments.isEmpty());
        assertEquals(1, allShipments.size());
    }
}