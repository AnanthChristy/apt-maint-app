package com.itu.ama.amaProject.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itu.ama.amaProject.model.Category;
import com.itu.ama.amaProject.model.HousingGroup;
import com.itu.ama.amaProject.model.Issue;
import com.itu.ama.amaProject.model.Owner;
import com.itu.ama.amaProject.model.Resident;
import com.itu.ama.amaProject.model.Technician;
import com.itu.ama.amaProject.model.WorkOrder;
import com.itu.ama.amaProject.repository.CategoryRepository;
import com.itu.ama.amaProject.repository.HousingGroupRepository;
import com.itu.ama.amaProject.repository.IssueRepository;
import com.itu.ama.amaProject.repository.OwnerRepository;
import com.itu.ama.amaProject.repository.ResidentRepository;
import com.itu.ama.amaProject.repository.TechnicianRepository;
import com.itu.ama.amaProject.repository.WorkOrderRepository;
import com.itu.ama.amaProject.type.WorkOrderStatus;

@Repository
public class AptMaintServiceImpl implements AptMaintService {
	
	@Autowired
	private ResidentRepository residentRepo;
	
	@Autowired
	private OwnerRepository ownerRepo;
	
	@Autowired
	private TechnicianRepository technicianRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private IssueRepository issueRep;
	
	@Autowired
	private HousingGroupRepository housingGroupRepo;
	
	@Autowired
	private WorkOrderRepository workOrderRepo;
	
	List<Resident> listOfResidents = new ArrayList<>();

	@Override
	public Resident saveResidentInfo(Resident resident) {
		residentRepo.save(resident);
		return resident;
	}

	@Override
	public Resident getResidentInfo(Long id) {
		return residentRepo.getOne(id);
	}

	@Override
	public Collection<Resident> getAllResidents() {
		listOfResidents =  residentRepo.findAll();
		return  listOfResidents;
	}
	
	@Override
	public Collection<Resident> getAllResidentsByGroupId(Long id) {
		return residentRepo.getResidentsByGroupID(id);
	}

	@Override
	public HousingGroup createHousingGroup(HousingGroup group) {
		housingGroupRepo.save(group);
		return group;
	}

	@Override
	public HousingGroup getHousingGroup(Long id) {
		return housingGroupRepo.getOne(id);
	}

	@Override
	public Collection<HousingGroup> getHousingGroupByName(String name) {
		return housingGroupRepo.findByGroupName(name);
	}

	@Override
	public Owner saveOwnerInfo(Owner owner) {
		ownerRepo.save(owner);
		return owner;
	}

	@Override
	public Owner getOwnerInfo(Long id) {
		return ownerRepo.getOne(id);
	}

	@Override
	public Collection<Owner> getAllOwners() {
		return ownerRepo.findAll();
	}
	
	@Override
	public Collection<Owner> getAllOwnersByGroupId(Long id) {
		return ownerRepo.getOwnersByGroupID(id);
	}

	@Override
	public Technician saveTechnicianInfo(Technician technician) {
		technicianRepo.save(technician);
		return technician;
	}

	@Override
	public Technician getTechnicianInfo(Long id) {
		return technicianRepo.getOne(id);
	}

	@Override
	public Collection<Technician> getAllTechnicians() {
		return technicianRepo.findAll();
	}

	
	public Collection<Technician> getAllTechniciansByHousingGroupId(Long groupId) {
		return technicianRepo.findByHomeGroupId(groupId);
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepo.getOne(id);
	}

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category addIssueToCategory(Issue issue, Long categoryId) throws Exception {
		Category category = categoryRepo.getOne(categoryId);
		issue.setCategory(category);
		issueRep.save(issue);
		return category;
	}

	@Override
	public Category removeIssueFromCategory(Long categoryId, Long issueId) {
		Category category = categoryRepo.getOne(categoryId);
		Issue issue = issueRep.getOne(issueId);
		issueRep.delete(issue);
		return category;
	}

	@Override
	public Issue createIssue(Issue issue) {
		issueRep.save(issue);
		return issue;
	}

	@Override
	public Issue getIssue(Long id) {
		return issueRep.getOne(id);
	}

	@Override
	public Collection<Issue> getAllIssuesByCategory(Long categoryId) {
		return issueRep.getAllIssueByCategory(categoryId);
	}

	@Override
	public WorkOrder createNewWorkOrder(WorkOrder workOrder) {
		return workOrderRepo.save(workOrder);
	}

	@Override
	public Collection<WorkOrder> getAllWorkOrdersByOwner(Long ownerId) {
		return workOrderRepo.getAllWorkOrdersByOwner(ownerId);
	}

	@Override
	public Collection<WorkOrder> getAllWorkOrdersByResident(Long residentId) {
		return workOrderRepo.getAllWorkOrdersByResident(residentId);
	}

	@Override
	public Collection<WorkOrder> getAllWorkOrdersByTechnician(Long technicianId) {
		return workOrderRepo.getAllWorkOrdersByTECHNICIAN(technicianId);
	}

	@Override
	public Collection<WorkOrder> getAllWorkOrdersByResidentStatus(Long residentId, WorkOrderStatus status) {
		Collection<WorkOrder> listOfWorkOrderByResident = workOrderRepo.getAllWorkOrdersByResident(residentId);
		Collection<WorkOrder> newList = new ArrayList<WorkOrder>();
		for(WorkOrder listItem : listOfWorkOrderByResident) {
			if(listItem.getStatus() == status) {
				newList.add(listItem);
			}
		}
		
		return newList;
	}

	@Override
	public Collection<WorkOrder> getAllWorkOrdersByOwnerStatus(Long ownerId, WorkOrderStatus status) {
		Collection<WorkOrder> listOfWorkOrderByOwner = workOrderRepo.getAllWorkOrdersByOwner(ownerId);
		Collection<WorkOrder> newList = new ArrayList<WorkOrder>();
		for(WorkOrder listItem : listOfWorkOrderByOwner) {
			if(listItem.getStatus() == status) {
				newList.add(listItem);
			}
		}
		
		return newList;
	}

	@Override
	public Collection<WorkOrder> getAllWorkOrdersByTechnicianStatus(Long technicianId, WorkOrderStatus status) {
		Collection<WorkOrder> listOfWorkOrderByTechnician = workOrderRepo.getAllWorkOrdersByTECHNICIAN(technicianId);
		Collection<WorkOrder> newList = new ArrayList<WorkOrder>();
		for(WorkOrder listItem : listOfWorkOrderByTechnician) {
			if(listItem.getStatus() == status) {
				newList.add(listItem);
			}
		}
		
		return newList;
	}

	@Override
	public Resident getResidentByEmailId(String emailId) {
		emailId.trim();
		return residentRepo.getResidentByEmailId(emailId);
	}

	@Override
	public Owner getOwnerByEmailId(String emailId) {
		emailId.trim();
		return ownerRepo.getOwnerByEmailId(emailId);
	}

	@Override
	public Technician getTechnicianByEmailId(String id) {
		return technicianRepo.getTechnicianByEmailId(id.trim());
	}
	
	
	public Collection<HousingGroup> getAllHousingGroups(){
		return housingGroupRepo.findAll();
	}
	
	
	
	
	

}
