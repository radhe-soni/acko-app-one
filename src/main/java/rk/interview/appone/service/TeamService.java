package rk.interview.appone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rk.interview.appone.dto.TeamCreationRequest;
import rk.interview.appone.entity.Team;
import rk.interview.appone.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	public Team createTeam(TeamCreationRequest request) {
		Team team = request.toTeam();
		return teamRepository.save(team);
	}
}
