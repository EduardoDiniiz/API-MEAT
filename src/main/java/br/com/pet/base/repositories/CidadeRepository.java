package br.com.pet.base.repositories;

import br.com.pet.base.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query(value = "SELECT c FROM Cidade c WHERE c.nome = :nome and c.estado.sigla = :sigla")
    Cidade getCidade(@Param("nome") String nome, @Param("sigla") String sigla);
}
