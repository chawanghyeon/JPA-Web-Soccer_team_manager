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
public class LoginsEntity {

	@Id
	@Column(name = "userid")
	private String userId;

	@NotNull
	@Column(name = "userpw")
	private String userPw;
	

	@OneToMany(mappedBy="userId")
	private List<TeamEntity> list;

	public LoginsEntity(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userId=");
		builder.append(userId);
		return builder.toString();
	}
	
}
