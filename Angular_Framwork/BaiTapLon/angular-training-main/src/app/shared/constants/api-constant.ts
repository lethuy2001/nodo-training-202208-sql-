import {environment} from "../../../environments/environment";

export const ApiConstant = {
    login: `${environment.service.authDomain}/api/login`,
    logout: `${environment.service.authDomain}/api/logout`,
    category: `${environment.service.apiDomain}/api/categories`,
    product: `${environment.service.apiDomain}/api/products`
};
