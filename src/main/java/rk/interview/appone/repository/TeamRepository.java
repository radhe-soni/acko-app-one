package rk.interview.appone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rk.interview.appone.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
