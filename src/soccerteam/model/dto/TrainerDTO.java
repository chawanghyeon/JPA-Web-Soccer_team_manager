package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import soccerteam.model.entity.PlayerEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainerEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class TrainerDTO {

	private int trNumber;

	private String tName;

	private String trName;

	private int trAge;

	private String trPosition;
	
	public TrainerEntity toEntity(TeamEntity team) {
		return TrainerEntity.builder().trNumber(trNumber).trName(trName).trAge(trAge).trPosition(trPosition).team(team).build();
	}
	
}
