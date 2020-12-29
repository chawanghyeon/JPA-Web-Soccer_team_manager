package soccerteam.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "team")
@Table(name = "team")
public class TeamEntity {

	@Id
	@Column(name="t_name")
	private String tName;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private LoginEntity login;

	@OneToMany//(mappedBy="team")//team이 27번 라인의 team을 의미해서 오류?mappedBy reference an unknown target entity property:
	private List<TeamEntity> list; //team이 playentity, managerentity등 여러 곳에서 참조하는데 어느 곳인지 몰라서 오류?

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("t_name=");
		builder.append(tName);
		return builder.toString();
	}

	
}
