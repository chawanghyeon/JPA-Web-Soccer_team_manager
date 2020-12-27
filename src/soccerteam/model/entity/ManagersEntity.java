package soccerteam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity(name = "managers")
@Table(name = "managers")
public class ManagersEntity {

	@Id
	@Column(name = "m_number")
	private int mNumber;

	@Column(name = "t_name")
	@ManyToOne(targetEntity = TeamEntity.class)
	@JoinColumn(name = "t_name")
	@NotNull
	private String tName;

	@Column(name = "m_name")
	@NotNull
	private String mName;

	@Column(name = "m_age")
	@NotNull
	private int mAge;

	@Column(name = "m_position")
	@NotNull
	private String mPosition;

}
