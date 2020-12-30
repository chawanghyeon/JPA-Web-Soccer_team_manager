package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soccerteam.model.entity.LoginEntity;
import soccerteam.model.entity.TeamEntity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TeamDTO {

	private String team;
	private String userID;
	
	public TeamEntity toEntity(LoginEntity login) {
		return TeamEntity.builder().team(team).login(login).build();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TeamDTO [team=");
		builder.append(team);
		builder.append(", userID=");
		builder.append(userID);
		builder.append("]");
		return builder.toString();
	}

}
