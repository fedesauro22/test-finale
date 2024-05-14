export async function registerUser(formData) {
    const jsonBody = JSON.stringify(formData);
    const response = await fetch("http://127.0.0.1:8080/api/user/register", {
        mode: "cors",
        method: "POST",
        body: jsonBody,
        headers: {
            "Content-Type": "application/json",
        },
    });
    return response.status;
}

export async function loginUser(formData) {
    const jsonBody = JSON.stringify(formData);
    const response = await fetch("http://127.0.0.1:8080/api/user/login", {
        mode: "cors",
        method: "POST",
        body: jsonBody,
        headers: {
            "Content-Type": "application/json",
        },
    });
    if (!response.ok) {
        return null;
    }
    const user = await response.json();
    return user;
}

export async function getAllCities() {
    const response = await fetch(`http://127.0.0.1:8080/api/city/get/all`, {
        mode: "cors",
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
    if (!response.ok) {
        return null;
    }
    const cities = await response.json();
    return cities;
}

export async function getCityInfo(cityName) {
    const response = await fetch(`http://127.0.0.1:8080/api/city/get/${cityName}`, {
        mode: "cors",
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
    if (!response.ok) {
        return null;
    }
    const cityInfo = await response.json();
    return cityInfo;
}

export async function getForecast(cityName) {
    const cityInfo = await getCityInfo(cityName);
    const latitude = cityInfo.latitude;
    const longitude = cityInfo.longitude;
    const response = await fetch(`https://api.open-meteo.com/v1/forecast?latitude=${latitude}&longitude=${longitude}&hourly=temperature_2m,precipitation_probability&timezone=auto&forecast_days=1`, {
        mode: "cors",
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
    if (!response.ok) {
        return null;
    }
    const forecast = await response.json();
    return forecast;
}

export async function insertForecast(userId, cityName, forecast) {
    const cityInfo = await getCityInfo(cityName);
    const cityId = cityInfo.id;
    const dateForecast = forecast.hourly.time[0];
    const [datePart] = dateForecast.split("T");
    const temperatures = forecast.hourly.temperature_2m.map(value => ({ value }));
    const precipitations = forecast.hourly.precipitation_probability.map(value => ({ value }));
    const requestBody = {
        date_forecast: datePart,
        temperatures: temperatures,
        precipitations: precipitations,
        userId: userId,
        cityId: cityId,
    };
    const response = await fetch(`http://localhost:8080/api/forecast/insert`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(requestBody),
    });
}

export async function getForecastHistory(userId){
    const response = await fetch(`http://localhost:8080/api/forecast/get?id=${userId}`, {
        mode: "cors",
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
    if (!response.ok) {
        return null;
    }
    const cityInfo = await response.json();
    return cityInfo;
}
