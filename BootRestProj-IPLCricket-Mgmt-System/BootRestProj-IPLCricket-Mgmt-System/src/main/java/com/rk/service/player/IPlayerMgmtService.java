package com.rk.service.player;

import com.rk.entity.IPLPlayer;

public interface IPlayerMgmtService {
	public String registerPlayer(IPLPlayer player);
	public Iterable<IPLPlayer> showAllplayers();
	public IPLPlayer showPlayerById(Integer id);
	public String updatePlayer(IPLPlayer player);
	public String deletePlayerById(Integer id);
	
}
