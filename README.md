# covid19-api

### Objetivo
- Cosumir a https://corona.lmao.ninja/v2/historical 
Essa aplicação é responsável por consumir a api, consolidar e comparar informações entre os casos de corona virus nos diversos paíse, devolvendo a informação no seguinte formato.

[<br/>
    {<br/>
        "country": "brazil",<br/>
        "firstCaseDate": "2/26/20",<br/>
        "firstDeathDate": "3/17/20",<br/>
        "currentCasesAmount": 3417,<br/>
        "currentDeathsAmount": 92,<br/>
        "mostCasesDate": "3/22/20 - 525",<br/>
        "mostDeathsDate": "3/26/20 - 18"<br/>
    },<br/>
    {<br/>
        "country": "china",<br/>
        "firstCaseDate": "1/22/20",<br/>
        "firstDeathDate": "1/22/20",<br/>
        "currentCasesAmount": 81897,<br/>
        "currentDeathsAmount": 3296,<br/>
        "mostCasesDate": "2/13/20 - 15136",<br/>
        "mostDeathsDate": "2/13/20 - 252"<br/>
    },<br/>
    {<br/>
        "country": "japan",<br/>
        "firstCaseDate": "1/22/20",<br/>
        "firstDeathDate": "2/13/20",<br/>
        "currentCasesAmount": 1468,<br/>
        "currentDeathsAmount": 49,<br/>
        "mostCasesDate": "3/25/20 - 114",<br/>
        "mostDeathsDate": "3/22/20 - 6"<br/>
    },<br/>
    {<br/>
        "country": "usa",<br/>
        "firstCaseDate": "1/22/20",<br/>
        "firstDeathDate": "2/29/20",<br/>
        "currentCasesAmount": 101657,<br/>
        "currentDeathsAmount": 1581,<br/>
        "mostCasesDate": "3/26/20 - 18058",<br/>
        "mostDeathsDate": "3/27/20 - 372"<br/>
    }<br/>
]<br/>

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
