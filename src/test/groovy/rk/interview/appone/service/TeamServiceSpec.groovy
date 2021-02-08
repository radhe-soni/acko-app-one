package rk.interview.appone.service

import static org.junit.Assert.*

import org.junit.Test

import com.fasterxml.jackson.databind.ObjectMapper

import rk.interview.appone.dto.TeamCreationRequest
import rk.interview.appone.dto.TeamDTO
import rk.interview.appone.entity.Developer
import rk.interview.appone.entity.Team
import rk.interview.appone.repository.TeamRepository
import spock.lang.Specification

class TeamServiceSpec  extends Specification{

	def "for a given request create team"() {
		given:
		def teamRequestJson =  getClass().getResource("/team-request.json").getBytes()
		def teamRequest = new ObjectMapper().readValue(teamRequestJson, TeamCreationRequest.class)
		TeamRepository repo = Mock();
		TeamService teamService = new TeamService(teamRepository: repo)
		when:
		teamService.createTeam(teamRequest)
		then:
		1*repo.save(_) >> {Team team ->
			team.name = "claims"
			team.developers[0].name = "someone"
			team.developers[0].phoneNumber = "9999999999"
			team
		}
	}
}