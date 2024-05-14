import React, { useState, useEffect } from "react";
import { getForecastHistory } from "../../services/config/RESTService";
import { getTokenId } from "../../services/config/CookieService";

export function ForecastHistoryTable() {
    const [history, setHistory] = useState([]);

    useEffect(() => {
        async function fetchHistory() {
            const userId = getTokenId();
            const historyData = await getForecastHistory(userId);
            setHistory(historyData);
        }
        fetchHistory();
    }, []);

    return (
        <div className="container mt-4">
            <h2 className="mb-3">Forecast History</h2>
            {history == null ? (
                <p className="text-muted">Nessuna ricerca effettuata!</p>
            ) : (
                <div className="row row-cols-1 row-cols-md-2 g-4">
                    {history.map((forecast, index) => (
                        <div key={index} className="col">
                            <div className="card h-100">
                                <div className="card-body">
                                    <h5 className="card-title">Data {forecast.date_forecast}</h5>
                                    <p className="card-text">
                                        <strong>Città: </strong>
                                        {forecast.city.name}
                                    </p>
                                    <p className="card-text">
                                        <strong>Temperature (°C): </strong>
                                        {forecast.temperatures.map((temp, index) => (
                                            <span key={index}>
                                                {temp.value.toFixed(1)}
                                                {index != forecast.temperatures.length - 1 ? ", " : ""}
                                            </span>
                                        ))}
                                    </p>
                                    <p className="card-text">
                                        <strong>Probabilità di precipitazione (%): </strong>
                                        {forecast.precipitations.map((precip, index) => (
                                            <span key={index}>
                                                {precip.value.toFixed(1)}
                                                {index != forecast.precipitations.length - 1 ? ", " : ""}
                                            </span>
                                        ))}
                                    </p>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
}
