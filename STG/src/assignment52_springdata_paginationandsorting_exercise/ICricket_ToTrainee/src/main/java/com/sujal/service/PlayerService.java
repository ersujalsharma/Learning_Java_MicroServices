package com.sujal.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.sujal.dto.PlayerDTO;
import com.sujal.exception.SujalPlayerException;

public interface PlayerService {

	public List<PlayerDTO> getFirstSevenPlayers(int pageNo, int pageSize) throws SujalPlayerException;

	public List<PlayerDTO> getAllPlayersByDebutDateAfter(String debutDate, int i, int j) throws SujalPlayerException;

	public List<PlayerDTO> getAllPlayersSortedByRanking(Sort sort) throws SujalPlayerException;

	public List<PlayerDTO> getAllPlayersOfCountrySortedByRanking(String country, Sort sort) throws SujalPlayerException;
}