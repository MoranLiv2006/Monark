package Extenstions;

import Utilities.Base;

public class ApiActions extends Base {

    public String getChuckNorrisJoke() {
        response = getRequestForAJoke();
        jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        return jsonPath.getString("value");
    }
}
