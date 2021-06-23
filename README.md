# JogoDaVelha-Spring

Aplicação desenvolvida em SpringBoot de um jogo da velha utilizando o Maven como gerenciador de dependências.

Para rodar o projeto localmente, basta ir em Import -> Existing Maven Project, e selecionar a pasta do projeto e o arquivo pom.xml.

O projeto conta com alguns testes unitários realizados na classe GameTest.

Os end-points disponíveis são:

/player -> 
  POST -> Recebe uma requisição conforme o exemplo, cria um jogador com o nome fornecido e retorna um ok para caso a criação do jogador seja feita com sucesso.
    {
       “name”: “João”
    }
  GET -> Retorna uma lista de todos os jogadores como o exemplo abaixo:
    [
    {
        "id": 1,
        "name": "João",
        "wins": 0,
        "losses": 0
    },
    {
        "id": 2,
        "name": "Sarah",
        "wins": 0,
        "losses": 0
    }
    ]

/game -> POST -> Recebe uma requisição conforme o exemplo e cria um jogo baseado nela caso os ids de jogadores fornecidos existam.
      Exemplo requisição -> 
      
          {
          firstPlayer: “1”
          secondPlayer: “2”
          }
          
      Exemplo retorno sucesso ->
      
          {
          "id": 1,
          "currentPlayer": "X",
          "msg": "Jogo criado com sucesso"
          }
          
      Exemplo retorno falha -> 
          {
          "id": null,
          "currentPlayer": null,
          "msg": "Jogador inválido"
          }

/game/{id}/movement -> POST -> Responsável por realizar um movimento no jogo e avaliar quem ganhou, ou se houve empate ao fim do jogo. Existem também validações para caso seja fornecido um jogo inexistente ou caso não seja a vez do jogador.
      Exemplo requisição -> 
        {
        "player": "X",
        "position": {
            "x": 0,
            "y": 1
        }
        }
        
      Exemplo retorno caso vitória ->
        {
        "msg": "Partida finalizada",
        "winner": "João" (Nome do jogador cadastrado)
        }
        
      Exemplo retorno caso vitória ->
        {
        "msg": "Partida finalizada",
        "winner": "João" (Nome do jogador cadastrado)
        }
      
      Exemplo retorno caso empate ->
        {
        "status": "Partida finalizada",
        "winner": "Draw"
        }
      

