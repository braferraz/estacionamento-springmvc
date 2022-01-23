package com.braian.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.braian.teste.model.Preco;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long>{

}
