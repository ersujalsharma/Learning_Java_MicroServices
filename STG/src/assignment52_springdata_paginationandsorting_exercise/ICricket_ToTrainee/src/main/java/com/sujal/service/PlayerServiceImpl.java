package com.sujal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sujal.dto.PlayerDTO;
import com.sujal.entity.Player;
import com.sujal.exception.SujalPlayerException;
import com.sujal.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service(value="bookService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;

	@Override
	public List<PlayerDTO> getFirstSevenPlayers(int pageNo, int pageSize) throws SujalPlayerException {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Player> page = playerRepository.findAll(pageable);
		List<Player> list = page.getContent();
		if(list.isEmpty()) throw new SujalPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		List<PlayerDTO> playerDTOs = list.stream().map(p->new PlayerDTO(p.getPlayerId(), p.getPlayerName(), p.getRanking(), p.getBattingStyle(), p.getBowlingStyle(), p.getDebutDate(), p.getCountry())).toList();
		return playerDTOs;
	}

	@Override
	public List<PlayerDTO> getAllPlayersByDebutDateAfter(String debutDate, int i, int j) throws SujalPlayerException {
		Pageable pageable = PageRequest.of(i,j);
		List<Player> list = playerRepository.findByDebutDateAfter(debutDate,pageable);
		if(list.isEmpty()) throw new SujalPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		List<PlayerDTO> playerDTOs = list.stream().map(p->new PlayerDTO(p.getPlayerId(), p.getPlayerName(), p.getRanking(), p.getBattingStyle(), p.getBowlingStyle(), p.getDebutDate(), p.getCountry())).toList();
		return playerDTOs;
	}

	@Override
	public List<PlayerDTO> getAllPlayersSortedByRanking(Sort sort) throws SujalPlayerException {
		Iterable<Player> list = playerRepository.findAll(sort);
		List<PlayerDTO> playerDTOs = new ArrayList<>();
		list.forEach(t->playerDTOs.add(new PlayerDTO(t.getPlayerId(), t.getPlayerName(), t.getRanking(), t.getBattingStyle(), t.getBowlingStyle(), t.getDebutDate(), t.getCountry())));
		if(playerDTOs.isEmpty()) throw new SujalPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		return playerDTOs;
	}

	@Override
	public List<PlayerDTO> getAllPlayersOfCountrySortedByRanking(String country, Sort sort) throws SujalPlayerException {
		
		List<Player> list = playerRepository.findByCountry(country, sort);
		if(list.isEmpty()) throw new SujalPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		List<PlayerDTO> playerDTOs = list.stream().map(p->new PlayerDTO(p.getPlayerId(), p.getPlayerName(), p.getRanking(), p.getBattingStyle(), p.getBowlingStyle(), p.getDebutDate(), p.getCountry())).toList();
		return playerDTOs;
	}

}