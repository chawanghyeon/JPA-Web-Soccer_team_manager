package soccerteam.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(name = "logins")
@Table(name = "logins")
public class LoginEntity {

	
	@Id
	@Column(name = "user_id")
	private String userID;

	@NotNull
	@Column(name = "user_pw")
	private String userPW;
	

	@OneToMany(mappedBy="logins")
	private List<TeamEntity> list;

	public LoginEntity(String userId, String userPw) {
		this.userID = userId;
		this.userPW = userPw;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userId=");
		builder.append(userID);
		return builder.toString();
	}
	
}
