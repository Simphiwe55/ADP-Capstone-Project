package za.ac.cput.factory;

/**
 * ShipmentFactory.java
 * Factory class for Shipment
 * Author: Simphiwe (221549323)
 * Date: 25 March 2026
 */

import za.ac.cput.domain.Shipment;
import java.time.LocalDate;

public class ShipmentFactory {

    public static Shipment createShipment(String shipmentId, String orderId,
                                          LocalDate shipmentDate, LocalDate deliveryDate,
                                          String status, String carrier) {

        if (shipmentId == null || shipmentId.isEmpty() ||
                orderId == null || orderId.isEmpty() ||
                shipmentDate == null ||
                status == null || status.isEmpty() ||
                carrier == null || carrier.isEmpty()) {
            return null;
        }

        return new Shipment.Builder()
                .setShipmentId(shipmentId)
                .setOrderId(orderId)
                .setShipmentDate(shipmentDate)
                .setDeliveryDate(deliveryDate)
                .setStatus(status)
                .setCarrier(carrier)
                .build();
    }
}