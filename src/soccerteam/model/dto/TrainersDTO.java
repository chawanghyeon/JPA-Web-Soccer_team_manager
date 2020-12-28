package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import soccerteam.model.entity.PlayersEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainersEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class TrainersDTO {

	private int trNumber;

	private String tName;

	private String trName;

	private int trAge;

	private String trPosition;
	
	public TrainersEntity toEntity(TeamEntity team) {
		return TrainersEntity.builder().trNumber(trNumber).trName(trName).trAge(trAge).trPosition(trPosition).team(team).build();
	}
	
}
