package com.rk.service.team;

import com.rk.entity.IPLTeam;

public interface ITeamMgmtService {
	public String registerTeam(IPLTeam team);
	public Iterable<IPLTeam> showAllTeams();
	public IPLTeam showteamById(Integer id);
	public String updateTeam(IPLTeam team);
	public String deleteTeam(Integer id);
}
