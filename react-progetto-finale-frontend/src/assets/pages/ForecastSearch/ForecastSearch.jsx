import { ForecastSearchForm } from "../../components/ForecastSearchForm/ForecastSearchForm";
export function ForecastSearch() {
    return (
        <div className="d-flex flex-column align-items-center justify-content-center text-center">
            <h2>Cerca il meteo della tua città</h2>
            <ForecastSearchForm />
        </div>
    );
}