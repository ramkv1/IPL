package com.rk.rest.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.entity.IPLTeam;
import com.rk.service.team.ITeamMgmtService;

@RestController
@RequestMapping("/team")
public class TeamOperationsController {
	
	@Autowired
	private ITeamMgmtService teamservice;
	
	//===========================Create operations=============
	@PostMapping("/save")
	public ResponseEntity<String>  registerTeam(@RequestBody IPLTeam team){
		//use service
		String msg=teamservice.registerTeam(team);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	//================find Operation=================
	@GetMapping("/find")
	public ResponseEntity<Iterable<IPLTeam>> showAllTeams(){
		//use service
		Iterable<IPLTeam> list=teamservice.showAllTeams();
		return new ResponseEntity<Iterable<IPLTeam>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLTeam> findTeamById(@PathVariable Integer id){
		//use service
		IPLTeam team=teamservice.showteamById(id);
		return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}
	//====================Update Team===============
	@PutMapping("/modify")
	public ResponseEntity<?> modifyTeamInfo(@RequestBody IPLTeam team){
		//use service
		String resultmsg=teamservice.updateTeam(team);
		return new ResponseEntity<String>(resultmsg,HttpStatus.OK);
	}
	//===================Delete Team =================
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTeamByid(@PathVariable Integer id){
		//use service
		String resultmsg=teamservice.deleteTeam(id);
		return new ResponseEntity<String>(resultmsg,HttpStatus.OK);
	}
} 
