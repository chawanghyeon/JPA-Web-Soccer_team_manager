package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginsDTO {
	
	private String userId;
	private String userPw;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginsDTO [userid=");
		builder.append(userId);
		builder.append(", userpw=");
		builder.append(userPw);
		builder.append("]");
		return builder.toString();
	}
	
}
