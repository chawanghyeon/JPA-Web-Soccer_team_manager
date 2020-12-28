package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import soccerteam.model.entity.MedicalStaffEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainerEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class MedicalStaffDTO {
	private int dNumber;

	private String tName;

	private String dName;

	private int dAge;

	private String dPosition;
	
	public MedicalStaffEntity toEntity(TeamEntity team) {
		return MedicalStaffEntity.builder().dNumber(dNumber).dName(dName).dAge(dAge).dPosition(dPosition).team(team).build();
	}
}
