import { getToken, getTokenName } from "../../services/config/CookieService";
import { AuthContext } from "./AuthContext";
import { useState } from "react";
export function AuthContextProvider({ children }) {
    const [user, setUser] = useState({
        token: getToken(),
        name: getTokenName(),
    });

    return (
        <AuthContext.Provider value={{ user, setUser }}>
            {children}
        </AuthContext.Provider>
    );
}
