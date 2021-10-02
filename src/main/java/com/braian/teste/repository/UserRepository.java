package com.braian.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.braian.teste.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT j FROM tbl_usuario j WHERE j.user = :user AND j.senha = :senha")
	public Usuario buscarLogin(String user, String senha); 
}
