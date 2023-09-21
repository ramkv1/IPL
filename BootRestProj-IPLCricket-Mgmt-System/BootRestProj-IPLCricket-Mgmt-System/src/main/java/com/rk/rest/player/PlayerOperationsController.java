package com.rk.rest.player;

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

import com.rk.entity.IPLPlayer;
import com.rk.service.player.IPlayerMgmtService;

@RestController
@RequestMapping("/Player")
public class PlayerOperationsController {
	
	@Autowired
	private IPlayerMgmtService playerService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		//use Service
		String resultMsg=playerService.registerPlayer(player);
		//return responseEntity Object
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
	}
	//==============Find Operations============
	@GetMapping("/find")
	public ResponseEntity<Iterable<IPLPlayer>> showAllPlayers(){
		//use Service
		Iterable<IPLPlayer> list=playerService.showAllplayers();
		return  new ResponseEntity<Iterable<IPLPlayer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLPlayer> findPlayerById(@PathVariable Integer id){
		//use service
		IPLPlayer player=playerService.showPlayerById(id);
		return new ResponseEntity<IPLPlayer>(player,HttpStatus.OK);
	}
	
	//======================Update Operations===========
	@PutMapping("/modify")
	public ResponseEntity<?> modifyPlayerInfo(@RequestBody IPLPlayer player){
		//use service
		String resultmsg=playerService.updatePlayer(player);
		return new ResponseEntity<String>(resultmsg,HttpStatus.OK);
	}
	//===================Delete Operation=====================
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removePlayerByid(@PathVariable Integer id){
		//use service
		String resultmsg=playerService.deletePlayerById(id);
		return new ResponseEntity<String>(resultmsg,HttpStatus.OK);
	}
}
