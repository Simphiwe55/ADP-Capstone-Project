package za.ac.cput.factory;

/**
 * ShipmentFactoryTest.java
 * Test class for ShipmentFactory
 * Author: Simphiwe (221549323)
 * Date: 27 March 2026
 */

import za.ac.cput.domain.Shipment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ShipmentFactoryTest {

    @Test
    public void testCreateShipment() {
        LocalDate shipmentDate = LocalDate.of(2026, 3, 10);
        LocalDate deliveryDate = LocalDate.of(2026, 3, 15);

        Shipment shipment = ShipmentFactory.createShipment(
                "S123",
                "O456",
                shipmentDate,
                deliveryDate,
                "In Transit",
                "DHL"
        );

        assertNotNull(shipment);
        assertEquals("S123", shipment.getShipmentId());
        assertEquals("O456", shipment.getOrderId());
        assertEquals(shipmentDate, shipment.getShipmentDate());
        assertEquals(deliveryDate, shipment.getDeliveryDate());
        assertEquals("In Transit", shipment.getStatus());
        assertEquals("DHL", shipment.getCarrier());
    }



}