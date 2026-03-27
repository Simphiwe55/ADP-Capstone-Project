

package za.ac.cput.repository;

/**
 * ShipmentRepository.java
 * Repository interface for Shipment
 * Author: Simphiwe (221549323)
 * Date: 26 March 2026
 */

import za.ac.cput.domain.Shipment;
import java.util.Set;

public interface ShipmentRepository extends Repository<Shipment, String> {
    Set<Shipment> getAll();
}