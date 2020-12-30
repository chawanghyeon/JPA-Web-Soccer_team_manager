package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import soccerteam.model.entity.ManagerEntity;
import soccerteam.model.entity.MedicalStaffEntity;
import soccerteam.model.entity.PlayerEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainerEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class PeopleDTO {

	private int number;

	private String team;

	private String name;

	private int age;

	private String position;
	
	public TrainerEntity toTrainerEntity(TeamEntity team) {
		return TrainerEntity.builder().number(number).name(name).age(age).position(position).team(team).build();
	}
	
	public PlayerEntity toPlayerEntity(TeamEntity team) {
		return PlayerEntity.builder().number(number).name(name).age(age).position(position).team(team).build();
	}
	
	public MedicalStaffEntity toMedicalStaffEntity(TeamEntity team) {
		return MedicalStaffEntity.builder().number(number).name(name).age(age).position(position).team(team).build();
	}
	
	public ManagerEntity toManagerEntity(TeamEntity team) {
		return ManagerEntity.builder().number(number).team(team).name(name).age(age).position(position).build();
	}
}
