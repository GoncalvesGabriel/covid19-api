# covid19-api

### Objetivo
- Cosumir a https://corona.lmao.ninja/v2/historical 
Essa aplicação é responsável por consumir a api, consolidar e comparar informações entre os casos de corona virus nos diversos paíse, devolvendo a informação no seguinte formato.

[
    {
        "country": "brazil",
        "firstCaseDate": "2/26/20",
        "firstDeathDate": "3/17/20",
        "currentCasesAmount": 3417,
        "currentDeathsAmount": 92,
        "mostCasesDate": "3/22/20 - 525",
        "mostDeathsDate": "3/26/20 - 18"
    },
    {
        "country": "china",
        "firstCaseDate": "1/22/20",
        "firstDeathDate": "1/22/20",
        "currentCasesAmount": 81897,
        "currentDeathsAmount": 3296,
        "mostCasesDate": "2/13/20 - 15136",
        "mostDeathsDate": "2/13/20 - 252"
    },
    {
        "country": "japan",
        "firstCaseDate": "1/22/20",
        "firstDeathDate": "2/13/20",
        "currentCasesAmount": 1468,
        "currentDeathsAmount": 49,
        "mostCasesDate": "3/25/20 - 114",
        "mostDeathsDate": "3/22/20 - 6"
    },
    {
        "country": "usa",
        "firstCaseDate": "1/22/20",
        "firstDeathDate": "2/29/20",
        "currentCasesAmount": 101657,
        "currentDeathsAmount": 1581,
        "mostCasesDate": "3/26/20 - 18058",
        "mostDeathsDate": "3/27/20 - 372"
    }
]

### Tecnologias
- Java
- Gradle
- Spring boot
- Spring web
- Swagger
- Lombok
- Rest

### Executar na IDE
- Basta executar a classe Covid19ApiApplication, com a aplicação rodando o seguinte endpoint estará disponível:  
        http://localhost:8080/covid19-api/historicos?paises={PAIS} <br/>
  Sendo {PAIS} subistituido pela lista de paises separados por vírgulas 
