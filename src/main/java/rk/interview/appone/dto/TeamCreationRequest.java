package rk.interview.appone.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import rk.interview.appone.entity.Developer;
import rk.interview.appone.entity.Team;

@Getter
@Setter
public class TeamCreationRequest {
	private TeamDTO team;
	private List<DeveloperDTO> developers;

	public Team toTeam() {
		Team teamEntity = team.toTeam();
		Optional.ofNullable(developers).map(devs -> this.toDeveloperEntities(devs, teamEntity))
				.ifPresent(teamEntity::setDevelopers);
		return teamEntity;
	}

	private Developer setTeam(Developer developer, Team teamEntity) {
		developer.setTeam(teamEntity);
		return developer;
	}

	private List<Developer> toDeveloperEntities(List<DeveloperDTO> devs, Team teamEntity) {
		return devs.stream().map(DeveloperDTO::toDeveloper).map(dev -> this.setTeam(dev, teamEntity))
				.collect(Collectors.toList());
	}
}
