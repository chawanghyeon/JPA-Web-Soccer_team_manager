package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import soccerteam.model.entity.PlayerEntity;
import soccerteam.model.entity.TeamEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class PlayerDTO {

	private int pnumber;

	private String tname;

	private String pname;

	private int page;

	private String pposition;
	
	public PlayerEntity toEntity(TeamEntity team) {
		return PlayerEntity.builder().pNumber(pnumber).pName(pname).pAge(page).pPosition(pposition).team(team).build();
	}
}
