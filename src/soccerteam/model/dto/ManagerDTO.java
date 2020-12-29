package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soccerteam.model.entity.ManagerEntity;
import soccerteam.model.entity.TeamEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ManagerDTO {
	
	private int mnumber;
	private String tname;
    private String mname;
	private int mage;
	private String mposition;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagersDTO [m_number=");
		builder.append(mnumber);
		builder.append(", t_name=");
		builder.append(tname);
		builder.append(", m_name=");
		builder.append(mname);
		builder.append(", m_age=");
		builder.append(mage);
		builder.append(", m_position=");
		builder.append(mposition);
		builder.append("]");
		return builder.toString();
	}

	public ManagerEntity toEntity(TeamEntity team) {
		
		return ManagerEntity.builder().mNumber(mnumber).team(team).mName(mname).mAge(mage).mPosition(mposition).build();
	}
	
}
