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

	private int trnumber;

	private String tname;

	private String trname;

	private int trage;

	private String trposition;
	
	public TrainerEntity toEntity(TeamEntity team) {
		return TrainerEntity.builder().trNumber(trnumber).trName(trname).trAge(trage).trPosition(trposition).team(team).build();
	}
	
}
