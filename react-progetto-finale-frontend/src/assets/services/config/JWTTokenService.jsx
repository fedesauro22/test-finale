import { jwtDecode } from "jwt-decode";

export function getClaims(token) {
    const claims = jwtDecode(token);
    return claims;
}

export function getNameClaim(token) {
    return getClaims(token).firstname;
}

export function getEmailClaim(token) {
    return getClaims(token).email;
}

export function getIdClaim(token) {
    return getClaims(token).id;
}

//funzione per prendere un claim con chiave key
export function getSpecifiedClaim(token, key){
    return (getClaims(token))[key];
}