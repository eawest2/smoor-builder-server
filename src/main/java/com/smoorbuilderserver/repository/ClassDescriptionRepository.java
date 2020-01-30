//package com.smoorbuilderserver.repository;
//
//import java.util.List;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.smoorbuilderserver.model.ClassDescription;
//import com.smoorbuilderserver.model.CombatActionDescription;
//
//@Repository
//public interface ClassDescriptionRepository extends CrudRepository<ClassDescription, Long> {
//	
//	public ClassDescription findByClassName(String generalClassName);
//	
//	public ClassDescription findByid(Integer id);
//	
//	public List<ClassDescription> findDistinctClassDescriptionByClassName(String generalClassName);
//	
//	public List<ClassDescription> saveClassDescriptions (List<ClassDescription> list);
//}