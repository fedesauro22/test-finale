import React from "react";
import { NavLink } from "react-router-dom";
import { getToken, getTokenName, isTokenExpired } from "../../services/config/CookieService";

export function Navbar() {
    const token = getToken();
    const name = !isTokenExpired() ? getTokenName() : null;

    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container-fluid" style={{ maxWidth: "100vh" }}>
                <NavLink className="navbar-brand" to="/">
                    Weather Report
                </NavLink>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
                        {token ? (
                            <li className="nav-item dropdown">
                                <button className="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                                    Ciao, {name}
                                </button>
                                <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li>
                                        <NavLink className="nav-link" to="/forecast/history">
                                            Vedi le tue riceche
                                        </NavLink>
                                    </li>
                                </ul>
                            </li>
                        ) : (
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/user/register">
                                    Registrati
                                </NavLink>
                            </li>
                        )}
                    </ul>
                </div>
            </div>
        </nav>
    );
}
