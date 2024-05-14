import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { Home } from "../pages/Home/Home";
import { NotFound } from "../pages/NotFound/NotFound";
import { MainLayout } from "../components/layouts/MainLayout/MainLayout";
import { AuthContextProvider } from "../contexts/AuthContext/AuthContextProvider";
import { UserRegistration } from "../pages/UserRegistration/UserRegistration";
import { UserLogin } from "../pages/UserLogin/UserRegistration";
import { ForecastHistory } from "../pages/ForecastHistory/ForecastHistory";
const routes = createBrowserRouter([
    {
        element: (
            <AuthContextProvider>
                <MainLayout />
            </AuthContextProvider>
        ),
        children: [
            {
                path: "/",
                children: [
                    {
                        path: "",
                        element: <Home />,
                    },
                    {
                        path: "user/",
                        children: [
                            {
                                path: "register/",
                                element: <UserRegistration />,
                            },
                            {
                                path: "login/",
                                element: <UserLogin />,
                            },
                        ],
                    },
                    {
                        path: "forecast/",
                        children: [
                            {
                                path: "history/",
                                element: <ForecastHistory />,
                            },
                        ],
                    },
                ],
            },
            {
                path: "*",
                element: <NotFound />,
            },
        ],
    },
]);

export function Routes() {
    return <RouterProvider router={routes} />;
}
