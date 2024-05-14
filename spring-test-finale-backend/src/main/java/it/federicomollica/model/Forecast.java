package it.federicomollica.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "forecast")
public class Forecast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date_forecast")
	private String date_forecast;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private User user;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_city", referencedColumnName = "id")
	private City city;

	@OneToMany(mappedBy = "forecast", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Temperature> temperatures = new ArrayList<>();

	@OneToMany(mappedBy = "forecast", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Precipitation> precipitations = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate_forecast() {
		return date_forecast;
	}

	public void setDate_forecast(String date_forecast) {
		this.date_forecast = date_forecast;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Temperature> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(List<Temperature> temperatures) {
		this.temperatures = temperatures;
	}

	public List<Precipitation> getPrecipitations() {
		return precipitations;
	}

	public void setPrecipitations(List<Precipitation> precipitations) {
		this.precipitations = precipitations;
	}

}
