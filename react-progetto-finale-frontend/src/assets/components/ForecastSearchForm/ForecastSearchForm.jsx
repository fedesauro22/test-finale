import React, { useState, useEffect } from "react";
import { getForecast, getAllCities, insertForecast } from "../../services/config/RESTService";
import { isTokenExpired } from "../../services/config/CookieService";
import { getTokenId } from "../../services/config/CookieService";

export function ForecastSearchForm({ onSearch }) {
    const [cityOptions, setCityOptions] = useState([]);
    const [selectedCity, setSelectedCity] = useState("");
    const [searchResults, setSearchResults] = useState(null);

    useEffect(() => {
        async function fetchCities() {
            const cities = await getAllCities();
            setCityOptions(cities);
        }
        fetchCities();
    }, []);

    const handleChange = (e) => {
        setSelectedCity(e.target.value);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const results = await getForecast(selectedCity);
        setSearchResults(results.hourly);
        if(!isTokenExpired()){
            const userId = getTokenId();
            await insertForecast(userId, selectedCity,results);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div className="input-group mb-3">
                <select className="form-select" value={selectedCity} onChange={handleChange}>
                    <option value="">Seleziona una città</option>
                    {cityOptions.map((city) => (
                        <option key={city.id} value={city.name}>
                            {city.name}
                        </option>
                    ))}
                </select>
                <button className="btn btn-primary" type="submit">
                    Cerca
                </button>
            </div>
            {searchResults && (
                <div>
                    <h3>Risultati della ricerca:</h3>
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Data</th>
                                <th>Temperatura (°C)</th>
                                <th>Probabilità di precipitazione (%)</th>
                            </tr>
                        </thead>
                        <tbody>
                            {searchResults.time.map((time, index) => (
                                <tr key={index}>
                                    <td>{time}</td>
                                    <td>{searchResults.temperature_2m[index]}</td>
                                    <td>{searchResults.precipitation_probability[index]}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            )}
        </form>
    );
}
