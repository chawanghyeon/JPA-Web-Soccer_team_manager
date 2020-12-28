package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import soccerteam.model.entity.PlayersEntity;
import soccerteam.model.entity.TeamEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class PlayersDTO {

	private int pNumber;

	private String tName;

	private String pName;

	private int pAge;

	private String pPosition;
	
	public PlayersEntity toEntity(TeamEntity team) {
		return PlayersEntity.builder().pNumber(pNumber).pName(pName).pAge(pAge).pPosition(pPosition).team(team).build();
	}
}
