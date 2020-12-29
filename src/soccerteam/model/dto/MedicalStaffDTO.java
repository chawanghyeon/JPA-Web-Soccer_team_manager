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
	private int dnumber;

	private String tname;

	private String dname;

	private int dage;

	private String dposition;
	
	public MedicalStaffEntity toEntity(TeamEntity team) {
		return MedicalStaffEntity.builder().dNumber(dnumber).dName(dname).dAge(dage).dPosition(dposition).team(team).build();
	}
}
