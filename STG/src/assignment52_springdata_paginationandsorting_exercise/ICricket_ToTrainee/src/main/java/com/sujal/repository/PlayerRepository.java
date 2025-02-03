package com.sujal.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sujal.entity.Player;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {
	List<Player> findByDebutDateAfter(String debutDate,Pageable pageable);
	List<Player> findByCountry(String country,Sort sort);
}