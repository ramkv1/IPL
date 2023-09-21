package com.rk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IPL_Players",uniqueConstraints = {@UniqueConstraint(columnNames = {"TEAM_ID"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class IPLPlayer {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "Player_Id_Seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer playerId;
	@NonNull
	@Column(length = 20)
	private String playerName;
	@Column(length = 10)
	@NonNull
	private String role;
	@NonNull
	private Integer jersyNo;


	@JsonBackReference
	@ManyToOne(targetEntity = IPLTeam.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID",referencedColumnName = "TEAM_ID",nullable = true)
	private IPLTeam teamInfo;

	//ToString
	@Override
	public String toString() {
		return "IPLPlayer [playerId=" + playerId + ", playerName=" + playerName + ", role=" + role + ", jersyNo="
				+ jersyNo + "]";
	}
}
