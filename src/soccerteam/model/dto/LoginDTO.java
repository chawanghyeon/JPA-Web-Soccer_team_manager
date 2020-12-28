package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soccerteam.model.entity.LoginEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginDTO {
	
	private String userID;
	private String userPW;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginsDTO [userid=");
		builder.append(userID);
		builder.append(", userpw=");
		builder.append(userPW);
		builder.append("]");
		return builder.toString();
	}
	
	public LoginEntity toEntity() {
		return LoginEntity.builder().userID(userID).userPW(userPW).build();
	}
}
