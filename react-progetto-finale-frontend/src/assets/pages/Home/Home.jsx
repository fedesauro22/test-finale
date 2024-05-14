import { ForecastSearch } from "../ForecastSearch/ForecastSearch";

export function Home() {

    return (
        <div className="container-fluid d-flex flex-column align-items-center">
            <ForecastSearch />
        </div>
    );
}
