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
import lombok.ToString;

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
	@Column(name = "user_id")
	@ManyToOne(targetEntity = LoginsEntity.class)
	@JoinColumn(name = "user_id")
	private LoginsEntity logins;

	@OneToMany(mappedBy="team")
	private List list;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("t_name=");
		builder.append(tName);
		return builder.toString();
	}

	
}
