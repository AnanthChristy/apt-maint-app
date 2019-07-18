package com.itu.ama.amaProject.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itu.ama.amaProject.model.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long>{
	
	@Query(value="SELECT * FROM WORK_ORDER WHERE OWNER_ID=?1", nativeQuery = true)
	Collection<WorkOrder> getAllWorkOrdersByOwner(Long id);
	
	@Query(value="SELECT * FROM WORK_ORDER WHERE RESIDENT_ID=?1", nativeQuery = true)
	Collection<WorkOrder> getAllWorkOrdersByResident(Long id);
	
	@Query(value="SELECT * FROM WORK_ORDER WHERE TECHNICIAN_ID=?1", nativeQuery = true)
	Collection<WorkOrder> getAllWorkOrdersByTECHNICIAN(Long id);
	
//	@Query(value="SELECT * FROM WORK_ORDER WHERE OWNER_ID=?1 AND STATUS LIKE '?2'", nativeQuery = true)
//	Collection<WorkOrder> getAllWorkOrdersByOwnerStatus(Long id, WorkOrderStatus status);
//	
//	@Query(value="SELECT * FROM WORK_ORDER WHERE RESIDENT_ID=?1 AND STATUS LIKE '?2'", nativeQuery = true)
//	Collection<WorkOrder> getAllWorkOrdersByResidentStatus(Long id, WorkOrderStatus status);
//	
//	@Query(value="SELECT * FROM WORK_ORDER WHERE TECHNICIAN_ID=?1 AND STATUS='?2'", nativeQuery = true)
//	Collection<WorkOrder> getAllWorkOrdersByTechnicianStatus(Long id, WorkOrderStatus status);

}
