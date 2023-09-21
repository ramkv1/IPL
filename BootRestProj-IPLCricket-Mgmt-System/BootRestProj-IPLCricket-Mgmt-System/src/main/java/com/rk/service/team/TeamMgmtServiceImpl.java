package com.rk.service.team;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.IPLTeam;
import com.rk.repository.IIPLTeamRepository;

@Service("teamService")
public class TeamMgmtServiceImpl implements ITeamMgmtService{

	
	@Autowired
	private IIPLTeamRepository teamRepo;
	
	@Override
	public String registerTeam(IPLTeam team) {
		return "Team is Saved with id value::"+teamRepo.save(team).getTeamId();
	}

	@Override
	public Iterable<IPLTeam> showAllTeams() {
		return teamRepo.findAll();
	}

	@Override
	public IPLTeam showteamById(Integer id){
		IPLTeam team=teamRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Team Id"));
		return team;
	}

	@Override
	public String updateTeam(IPLTeam team){
		// find the object
		Optional<IPLTeam> opt=teamRepo.findById(team.getTeamId());
		if(opt.isPresent()) {
			//update the Object
			teamRepo.save(team);
			return team.getTeamId()+"Team Details are Updated";
		}
		else {
			throw new IllegalArgumentException(team.getTeamId()+":: Team is not Found");
		}
	}

	@Override
	public String deleteTeam(Integer id){
		Optional<IPLTeam> opt=teamRepo.findById(id);
		if(opt.isPresent()) {
			teamRepo.deleteById(id);
			return id+"::id Team is deleted";
		}
		else {
			throw new IllegalArgumentException(id+"::::Team is not found");
		}
		
	}
}
