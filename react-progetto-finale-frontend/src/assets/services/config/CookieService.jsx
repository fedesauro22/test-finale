import Cookies from "js-cookie";
import { getNameClaim, getEmailClaim, getIdClaim } from "./JWTTokenService";
export function setJWTCookies(token, expireDate) {
    Cookies.set("token", token, { expires: expireDate });
}

export function isTokenExpired() {
    return Cookies.get("token") == null;
}

export function getToken() {
    return Cookies.get("token");
}

export function deleteToken() {
    return Cookies.remove("token");
}

export function getTokenName() {
    return !isTokenExpired() ? getNameClaim(getToken()) : "";
}


export function getTokenEmail() {
    return !isTokenExpired() ? getEmailClaim(getToken()) : "";
}

export function getTokenId() {
    return !isTokenExpired() ? getIdClaim(getToken()) : "";
}