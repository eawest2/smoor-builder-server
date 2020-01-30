//package com.smoorbuilderserver.repository;
//
//import java.util.List;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.smoorbuilderserver.model.ProductionSkillDescription;
//
//@Repository
//public interface ProductionSkillDescriptionRepository extends CrudRepository<ProductionSkillDescription, Long> {
//	
//	public ProductionSkillDescription findByProductionName(String productionlName);
//	
//	public ProductionSkillDescription findByid(Integer id);
//	
//	public List<ProductionSkillDescription> findDistinctProductionSkillDescriptionByProductionName(String productionName);
//	
//	public List<ProductionSkillDescription> saveProductionSkillDescriptions (List<ProductionSkillDescription> list);
//
//}