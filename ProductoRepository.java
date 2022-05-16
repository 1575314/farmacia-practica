package com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public List <Producto> findByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	public List <Producto> findByNomeAndLaboratorio(String nome, String laboratorio);
	
	@Query(value = "select * from tb_produtos where preco between :inicio and :fim", nativeQuery = true)
	public List <Producto> buscarProdutosEntre(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);

	public List<Producto> findByPrecoIn(List<BigDecimal> preco);

}

