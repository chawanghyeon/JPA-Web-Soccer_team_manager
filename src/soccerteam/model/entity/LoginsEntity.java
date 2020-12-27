package soccerteam.model.entity;

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
@ToString
@Builder

@Entity(name = "login")
@Table(name = "login")
public class LoginsEntity {

	@Id
	@Column(name = "userid")
	@OneToMany(mappedBy="userid")
	private String userid;

	@Column(name = "userpw")
	@NotNull
	private String userpw;

}
