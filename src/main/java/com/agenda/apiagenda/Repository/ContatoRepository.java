package com.agenda.apiagenda.Repository;

import com.agenda.apiagenda.Model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
