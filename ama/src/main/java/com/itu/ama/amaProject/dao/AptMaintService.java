package com.itu.ama.amaProject.dao;

import java.util.Collection;

import com.itu.ama.amaProject.model.Category;
import com.itu.ama.amaProject.model.HousingGroup;
import com.itu.ama.amaProject.model.Issue;
import com.itu.ama.amaProject.model.Owner;
import com.itu.ama.amaProject.model.Resident;
import com.itu.ama.amaProject.model.Technician;
import com.itu.ama.amaProject.model.WorkOrder;
import com.itu.ama.amaProject.type.WorkOrderStatus;

public interface AptMaintService {
	
	/* Resident ws */
	Resident saveResidentInfo(Resident resident);
	
	Resident getResidentInfo(Long id);
	
	Collection<Resident> getAllResidents();
	
	Collection<Resident> getAllResidentsByGroupId(Long id);
	
	/*Owner ws*/
	Owner saveOwnerInfo(Owner owner);
	
	Owner getOwnerInfo(Long id);
	
	Collection<Owner> getAllOwners();
	
	Collection<Owner> getAllOwnersByGroupId(Long id);
	
	/*Technician ws*/
	Technician saveTechnicianInfo(Technician technician);
	
	Technician getTechnicianInfo(Long id);
	
	Collection<Technician> getAllTechnicians();
	
	Collection<Technician> getAllTechniciansByHousingGroupId(Long groupId);
	
	/*HousingGroup ws*/
	HousingGroup createHousingGroup(HousingGroup group);
	
	HousingGroup getHousingGroup(Long id);
	
	Collection<HousingGroup> getHousingGroupByName(String name);
	
	
	
	Category createCategory(Category category);
	
	Category getCategory(Long id);
	
	Collection<Category> getAllCategories();
	
	
	Category addIssueToCategory(Issue issue, Long categoryId) throws Exception;
	
	Category removeIssueFromCategory(Long categoryId, Long issueId);
	
	Issue createIssue(Issue issue);
	
	Issue getIssue(Long id);
	
	Collection<Issue> getAllIssuesByCategory(Long categoryId);
	
	
	
	WorkOrder createNewWorkOrder(WorkOrder workOrder);
	
	Collection<WorkOrder> getAllWorkOrdersByOwner(Long ownerId);
	
	Collection<WorkOrder> getAllWorkOrdersByResident(Long residentId);
	
	Collection<WorkOrder> getAllWorkOrdersByTechnician(Long technicianId);
	
	Collection<WorkOrder> getAllWorkOrdersByResidentStatus(Long residentId, WorkOrderStatus status);
	Collection<WorkOrder> getAllWorkOrdersByOwnerStatus(Long ownerId, WorkOrderStatus status);
	Collection<WorkOrder> getAllWorkOrdersByTechnicianStatus(Long technicianId, WorkOrderStatus status);

	
	
	
	
	
	
	
	
	
	
	
	

}
