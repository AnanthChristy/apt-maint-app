package com.itu.ama.amaProject.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itu.ama.amaProject.dao.AptMaintService;
import com.itu.ama.amaProject.model.Category;
import com.itu.ama.amaProject.model.HousingGroup;
import com.itu.ama.amaProject.model.Issue;
import com.itu.ama.amaProject.model.Owner;
import com.itu.ama.amaProject.model.Resident;
import com.itu.ama.amaProject.model.Technician;
import com.itu.ama.amaProject.model.WorkOrder;
import com.itu.ama.amaProject.type.WorkOrderStatus;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AptMaintAppController {
	
	@Autowired
	private AptMaintService aptMaintService;
	
	@RequestMapping(value="/registerResident",
			method=RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes= {"application/json"})
	public Resident residentInfo(@RequestBody Resident resident) throws Exception{
		return aptMaintService.saveResidentInfo(resident);
	}
	
	@RequestMapping(value="/getAllResidents",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Resident> getAllResidents(){
		return aptMaintService.getAllResidents();
	}
	
	@RequestMapping(value="/getResident/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Resident getResidentById(@PathVariable("id") Long id) {
		return aptMaintService.getResidentInfo(id);
	}
	
	@RequestMapping(value="/getResidentByEmail/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Resident getResidentByEmailId(@PathVariable("id") String id) {
		return aptMaintService.getResidentByEmailId(id);
	}
	
	
	
	@RequestMapping(value="/getResidentsByHousingGroupId/{groupId}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Resident> getResidentByHomeGroupId(@PathVariable("groupId") Long groupId){
		return aptMaintService.getAllResidentsByGroupId(groupId);
	}
	
	@RequestMapping(value="/createHousingGroup",
			method=RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public HousingGroup createHousingGroup(@RequestBody HousingGroup group) throws Exception {
		return aptMaintService.createHousingGroup(group);
		
	}
	
	@RequestMapping(value="/getHousingGroup/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public HousingGroup getHousingGroupById(@PathVariable("id") Long id) {
		return aptMaintService.getHousingGroup(id);
	}
	
	@RequestMapping(value="/getHousingGroupByName/{name}")
	public Collection<HousingGroup> getHousingGroupByName(@PathVariable("name") String name) {
		return aptMaintService.getHousingGroupByName(name);
	}
	
	
	@RequestMapping(value="/registerOwner",
			method=RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes= {"application/json"})
	public Owner ownerInfo(@RequestBody Owner owner) throws Exception{
		return aptMaintService.saveOwnerInfo(owner);
	}
	
	@RequestMapping(value="/getAllOwners",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Owner> getAllOwners(){
		return aptMaintService.getAllOwners();
	}
	
	/**
	 * Search Owner By Id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getOwner/{id}")
	public Owner getOwnerById(@PathVariable("id") Long id) {
		return aptMaintService.getOwnerInfo(id);
	}
	
	@RequestMapping(value="/getOwnerByEmail/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Owner getOwnerByEmailId(@PathVariable("id") String id) {
		return aptMaintService.getOwnerByEmailId(id);
	}
	
	@RequestMapping(value="/getOwnersByHomeGroupId/{groupId}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Owner> getOwnersByHomeGroupId(@PathVariable("groupId") Long groupId){
		return aptMaintService.getAllOwnersByGroupId(groupId);
	}
	
	
	/*** Technician Web services 
	 */
	
	/**
	 * 
	 * @param technician
	 * @return registered technician
	 * @throws Exception
	 */
	@RequestMapping(value="/registerTechnician",
			method=RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Technician technicianInfo(@RequestBody Technician technician) throws Exception{
		return aptMaintService.saveTechnicianInfo(technician);
	}
	
	@RequestMapping(value="/getAllTechnicians",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Technician> getAllTechnicians(){
		return aptMaintService.getAllTechnicians();
	}
	
	@RequestMapping(value="/getTechnician/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Technician getTechnicianById(@PathVariable("id") Long id) {
		return aptMaintService.getTechnicianInfo(id);
	}
	
	@RequestMapping(value="/getTechnicianByEmail/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Technician getTechnicianByEmailId(@PathVariable("id") String id) {
		return aptMaintService.getTechnicianByEmailId(id);
	}
	
	@RequestMapping(value="/getTechnicianByHousingGroupId/{groupId}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Technician> getTechnicianByHomeGroupId(@PathVariable("groupId") Long groupId){
		return aptMaintService.getAllTechniciansByHousingGroupId(groupId);
	}
	
	
	
	/*** Catgeory Web services
	 * 
	 * 
	 */
	@RequestMapping(value="/createCategory",
			method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Category createCategory(@RequestBody Category category) throws Exception {
		return aptMaintService.createCategory(category);
	}
	
	@RequestMapping(value="/getCategory/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Category getCategoryById(@PathVariable("id") Long id) {
		return aptMaintService.getCategory(id);
	}

	@RequestMapping(value="/getAllCategories",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Category> getAllCategories(){
		return aptMaintService.getAllCategories();
	}
	
	@RequestMapping(value="/addIssueToCategory/{categoryId}",
			method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Category addIssueToCategory(@RequestBody Issue issue, @PathVariable("categoryId") Long id) throws Exception {
		return aptMaintService.addIssueToCategory(issue, id);
	}
	
	@RequestMapping(value="/removeIssueFromCategory/{categoryId}/{issueId}",
			method=RequestMethod.DELETE,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Category removeIssueFromCategory(@PathVariable("categoryId") Long categoryId, @PathVariable("issueId") Long id) {
		return aptMaintService.removeIssueFromCategory(categoryId, id);
	}
	
	@RequestMapping(value="/addIssue",
			method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Issue createIssue(@RequestBody Issue issue) {
		return aptMaintService.createIssue(issue);
	}
	
	@RequestMapping(value="/getIssue/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Issue getIssue(@PathVariable("id") Long id) {
		return aptMaintService.getIssue(id);
	}
	
	@RequestMapping(value="/getAllIssuesByCategory/{cid}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<Issue> getAllIssuesByCategory(@PathVariable("cid") Long cId){
		return aptMaintService.getAllIssuesByCategory(cId);
	}
	
	
	/**
	 * Work Order web services
	 * @param workOrder
	 * @return work Order
	 */
	
	@RequestMapping(value="/createWorkOrder",
			method=RequestMethod.POST,
					consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
					produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public WorkOrder createWorkOrder(@RequestBody WorkOrder workOrder) {
		return aptMaintService.createNewWorkOrder(workOrder);
	}
	
	@RequestMapping(value="/getAllWorkOrdersByResidentId/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<WorkOrder> getAllWorkOrdersByResidentId(@PathVariable("id") Long id){
		return aptMaintService.getAllWorkOrdersByResident(id);
	}
	
	@RequestMapping(value="/getAllWorkOrdersByOwnerId/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<WorkOrder> getAllWorkOrdersByOwnerId(@PathVariable("id") Long id){
		return aptMaintService.getAllWorkOrdersByOwner(id);
	}
	
	@RequestMapping(value="/getAllWorkOrdersByTechnicianId/{id}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<WorkOrder> getAllWorkOrdersByTechnicianId(@PathVariable("id") Long id){
		return aptMaintService.getAllWorkOrdersByTechnician(id);
	}
	
	@RequestMapping(value="/getWorkOrdersByOwnerIdNStatus/{id}/{status}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<WorkOrder> getAllWorkOrdersByOwnerStatus(@PathVariable("id") Long id, @PathVariable("status") WorkOrderStatus status){
		return aptMaintService.getAllWorkOrdersByOwnerStatus(id, status);
	}
	
	@RequestMapping(value="/getWorkOrdersByResidentIdNStatus/{id}/{status}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<WorkOrder> getAllWorkOrdersByResidentStatus(@PathVariable("id") Long id, @PathVariable("status") WorkOrderStatus status){
		return aptMaintService.getAllWorkOrdersByResidentStatus(id, status);
	}
	
	@RequestMapping(value="/getWorkOrdersByTechnicianIdNStatus/{id}/{status}",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Collection<WorkOrder> getAllWorkOrdersByTechnicianStatus(@PathVariable("id") Long id, @PathVariable("status") WorkOrderStatus status){
		return aptMaintService.getAllWorkOrdersByTechnicianStatus(id, status);
	}
	
	
	
}
