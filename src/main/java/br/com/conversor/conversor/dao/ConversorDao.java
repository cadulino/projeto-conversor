package br.com.conversor.conversor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.conversor.conversor.models.ConversorModel;

public interface ConversorDao extends JpaRepository<ConversorModel, Long>{
	
	@Query("from ConversorModel c where c.name = ?1")
    public List<ConversorModel> findByName(String name);
}
