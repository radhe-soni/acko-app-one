package rk.interview.appone.dto;

import lombok.Getter;
import lombok.Setter;
import rk.interview.appone.entity.Team;

@Getter
@Setter
public class TeamDTO {
	private String name;

	public Team toTeam() {
		Team team = new Team();
		team.setName(name);
		return team;
	}
}
