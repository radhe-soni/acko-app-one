package rk.interview.appone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rk.interview.appone.dto.TeamCreationRequest;
import rk.interview.appone.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	@PostMapping
	public void createTeam(@RequestBody TeamCreationRequest request) {
		teamService.createTeam(request);
	}
	
}
