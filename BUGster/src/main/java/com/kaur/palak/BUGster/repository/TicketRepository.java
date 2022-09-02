package com.kaur.palak.BUGster.repository;

import com.kaur.palak.BUGster.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
