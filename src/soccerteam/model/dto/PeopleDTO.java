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
	
}
