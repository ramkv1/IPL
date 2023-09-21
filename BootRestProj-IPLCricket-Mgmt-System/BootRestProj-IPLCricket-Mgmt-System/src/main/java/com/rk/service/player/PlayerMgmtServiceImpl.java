package com.rk.service.player;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.IPLPlayer;
import com.rk.repository.IIPLPlayerRepository;

@Service("playerService")
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {
	
	@Autowired
	private IIPLPlayerRepository PlayerRepo;

	@Override
	public String registerPlayer(IPLPlayer player) {
		IPLPlayer Iplp=PlayerRepo.save(player);
		return "Player obj is saved with id value::"+Iplp.getPlayerId();
	}

	@Override
	public Iterable<IPLPlayer> showAllplayers() {	
		return PlayerRepo.findAll();
	}

	@Override
	public IPLPlayer showPlayerById(Integer id) {
		IPLPlayer player=PlayerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Player Id"));
		return player;
	}

	@Override
	public String updatePlayer(IPLPlayer player) {
		//find the Object
		Optional<IPLPlayer> opt=PlayerRepo.findById(player.getPlayerId());
		if(opt.isPresent()) {
			//update the Object
			PlayerRepo.save(player);
			return player.getPlayerId()+"Player Details are Updated";
		}
		else {
			throw new IllegalArgumentException(player.getPlayerId()+"::Player is Not Found");
		}
	}

	@Override
	public String deletePlayerById(Integer id) {
		//get find the Player
		Optional<IPLPlayer> opt=PlayerRepo.findById(id);
		if(opt.isPresent()) {
			PlayerRepo.deleteById(id);
			return id+"::id Player is deleted";
		}
		else {
			throw new IllegalArgumentException(id+"Player is not found");
		}
	}
	
}
