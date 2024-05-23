
# API RESTFUL - Gerenciamento de equipes de e-sports

Esse projeto se trata de um CRUD de gerenciamento de equipes de e-sports onde é possível adicionar, consultar, atualizar e remover um jogador, um time, o jogo e os eventos de cada jogador e time do banco de dados através dos endpoints.


## Stack utilizada
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)


## Como usar
1. Inicie a aplicação usando Maven
2. A API poderá ser acessada em http://localhost:8080

## API Endpoints
## Jogadores
A API possui os seguintes endpoints:
```bash
GET /jogador - Lista todos os jogadores cadastrados.
```
```bash
[
    {
        "idJogador": "dac4561c-d725-4e05-bb69-4a3bf1869f73",
        "nomeJogador": "Titan",
        "quantidadeTitulos": 4,
        "timeJogador": "Pain",
        "posicao": "AD Carry"
    },
    {
        "idJogador": "242061ea-d86f-4b2e-b8e8-5b12d7db64d9",
        "nomeJogador": "Kuri",
        "quantidadeTitulos": 0,
        "timeJogador": "Pain",
        "posicao": "Support"
    },
    {
        "idJogador": "20cc5bb0-cb1f-4635-a0f6-3f2a502309cc",
        "nomeJogador": "Dynquedo",
        "quantidadeTitulos": 2,
        "timeJogador": "Pain",
        "posicao": "Mid laner"
    }
```

```bash
GET /jogador/{id} - Lista um jogador específico pelo seu UUID.
```
```bash
    {
        "idJogador": "38211546-9840-47e9-99be-d9f0c1470dc7",
        "nomeJogador": "Cariok",
        "quantidadeTitulos": 1,
        "timeJogador": "Pain",
        "posicao": "Jungler"
    }
```

```bash
POST /jogador - Registra um novo jogador.
```
```bash
    {
        "nomeJogador": "Wizer",
        "quantidadeTitulos": 0,
        "timeJogador": "Pain",
        "posicao": "Top laner"
    }
```

```bash
PUT /jogador/{id} - Atualiza o registro de um jogador específico pelo seu UUID.
```

```bash
DELETE /jogador/{id} - Exclui um jogador específico pelo seu UUID.
```
## Equipes

```bash
GET /equipe - Lista todas as equipes cadastradas.
```

```bash
[
    {
        "idEquipe": "af8fa452-aa3a-4a90-83e4-ccc4a5ec8ee4",
        "nome": "Pain Gaming",
        "numeroTitulos": 3,
        "categoria": "CBLOL",
        "jogos": "League Of Legends",
        "inscrito": true
    },
    {
        "idEquipe": "a9f93225-3d42-4a27-a9fa-d76c5ef881be",
        "nome": "Loud",
        "numeroTitulos": 4,
        "categoria": "CBLOL",
        "jogos": "League Of Legends",
        "inscrito": true
    }
]
```

```bash
GET /equipe/{id} - Lista uma equipe específica pelo seu UUID.
```

```bash
{
    "idEquipe": "25db6a1b-9af5-439f-a970-80626dc51739",
    "nome": "INTZ",
    "numeroTitulos": 5,
    "categoria": "CBLOL",
    "jogos": "League Of Legends",
    "inscrito": true
}
```

```bash
POST /equipe - Registra uma nova equipe.
```

```bash
{
    "nome": "Vivo Keyd",
    "numeroTitulos": 2,
    "categoria": "CBLOL",
    "jogos": "League Of Legends",
    "inscrito": true
}
```

```bash
PUT /equipe/{id} - Atualiza o registro de um jogador específico pelo seu UUID.
```

```bash
DELETE /equipe/{id} - Exclui um jogador específico pelo seu UUID.
```

## Jogos
```bash
GET /jogo - Lista todos os jogos cadastrados.
```

```bash
[
    {
        "idJogo": "d4dac795-ebd9-4cdf-8a10-b079a192beef",
        "nome": "League Of Legends",
        "modalidade": "MOBA"
    },
    {
        "idJogo": "24076634-77e1-4569-862b-fa9158066c75",
        "nome": "Counter Strike 2",
        "modalidade": "FPS"
    }
]
```

```bash
GET /jogo/{id} - Lista um jogo especifico pelo seu UUID.
```

```bash
    {
        "idJogo": "24076634-77e1-4569-862b-fa9158066c75",
        "nome": "Counter Strike 2",
        "modalidade": "FPS"
    }
```

```bash
POST /jogo - Registra um novo jogo.
```

```bash
    {
        "nome": "Valorant",
        "modalidade": "FPS"
    }
```

```bash
PUT /jogo/{id} - Atualiza o registro de um jogo específico pelo seu UUID.
```

```bash
DELETE /jogo/{id} - Exclui um jogo específico pelo seu UUID.
```
