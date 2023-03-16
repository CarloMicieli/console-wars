# The REST API

|        Endpoint	         |  Method  | Req. body  | Status |  Resp. body  | Description    		                                   |
|:------------------------:|:--------:|:----------:|:------:|:------------:|:------------------------------------------------------|
|        `/games`          |  `POST`  |   `Game`   |  201   |              | Add a new game to the catalog                         |
|      `/games/{urn}`      |  `PUT`   |   `Game`   |  204   |              | Update the game with the given `{urn}`                |
|      `/games/{urn}`      |  `GET`   |            |  200   |    `Game`    | Get the game with the given `{urn}`                   |
|      `/games/{urn}`      | `DELETE` |            |  204   |              | Delete the game with the given `{urn}`                |
|      `/platforms`        |  `POST`  | `Platform` |  201   |              | Add a new platform to the catalog                     |
|    `/platforms/{urn}`    |  `PUT`   | `Platform` |  204   |              | Update the platform with the given `{urn}`            |
|      `/platforms`        |  `GET`   |            |  200   | `Platform[]` | Get all platforms in the catalog                      |
|    `/platforms/{urn}`    |  `GET`   |            |  200   |  `Platform`  | Get the platform with the given `{urn}`               |
| `/platforms/{urn}/games` |  `GET`   |            |  200   |   `Game[]`   | Get all games for the platform with the given `{urn}` |

## Visual Studio code

Add this to the `.vscode/settings.json` file:

```json
{
    "rest-client.environmentVariables": {
        "micronaut-jdbc": {
            "host": "localhost",
            "port": "8000"
        },
        "micronaut-r2dbc": {
            "host": "localhost",
            "port": "8002"
        },
        "spring-mvc": {
            "host": "localhost",
            "port": "8004"
        },
        "spring-webflux": {
            "host": "localhost",
            "port": "8006"
        },
        "rust-actix-web": {
            "host": "localhost",
            "port": "8008"
        }
    }
}
```