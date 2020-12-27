package soccerteam.model.entity;

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
@ToString
@Builder

@Entity(name = "team")
@Table(name = "team")
public class TeamEntity {

	@Id
	@Column(name="t_name")
	@OneToMany(mappedBy="t_name")
	private String t_name;

	@Column(name = "userid")
	@ManyToOne(targetEntity = LoginsEntity.class)
	@JoinColumn(name = "userid")
	@NotNull
	private String userid;

}
