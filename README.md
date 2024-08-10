# Reserva Rápida - Projeto Pós FIAP
##### _Facilidade ao reservar_

Este projeto é uma API que permite que os clientes de um restaurante consigam reservar lugares em uma mesa, facilitando assim toda a organização e previsibilidade de atendimento na hora certa.


#####  Tecnologias utilizadas
- Java
- Spring Boot
- Spring Data JPA

##### Pré-requisitos
- Java JDK 17
- Maven

##### Instalação 
```s
1. Clone o repositorio https://github.com/felipeyajima/reservas
2. Instale as dependências com o comando cd reservas mvn clean package
3. A Api estará disponível no endereço localhost:8080
```

##### Endpoints

| Verbo | Recurso | Finalidade|
| ------ | ------ |------|
| GET | /reservas |obtém todas reservas|
| GET | /reservas/{id} |obtém uma reserva específica|
| POST | /reservas|envia uma reserva|
| PUT | /reservas/{id}|edita uma reserva|
| DELETE | /reservas/{id}|apaga uma reserva|
| PUT | /reservas/{id}/valida|ao chegar na fila do restaurante, o cliente precisa validar sua presença|
| PUT | /reservas/{id}/encerra|na finalização dos serviços, o restaurante encerra o serviço|
| PUT | /reservas/{id}/cancela|realiza o cancelamento automático caso o cliente não valide a reserva em um tempo hábil|
| POST | /atendimento |libera uma reserva para ir para mesa|


##### Exemplo do fluxo de uso

O cliente que deseja reservar uma mesa em um estabelecimento, necessita informar ao sistema algumas informações para a reserva. 
   
   ```
POST /reserva
   {
    "responsavel": "joão batista",
    "email": "joao@batista.com",
    "telefone": 11900000000,
    "quantidadeDeLugares": 5
   }
```

Ao enviar sua requisição, sua reserva estará com o status 'agendado'. Assim que chegar no estabelecimento, o cliente necessitará validar sua presença, fazendo com que o status de sua reserva mude para 'aguardando'. 

Assim que uma mesa for liberada no restaurante, o garçom ou atendente irá lançar no sistema uma nova liberação no endereço POST /atendimento. Nesta liberação, o garçom irá informar no body da requisição a quantidade de lugares da mesa que foi liberada. O sistema avaliará os clientes em ordem de chegada e irá liberar a reserva com quantidade compatível de lugares para sair da fila e ir para a mesa. O Garçom irá recepcionar o cliente cuja reserva foi liberada e alocar na mesa. 

   ```
POST /atendimento

{
    "id": 1,
    "responsavel": "Rodrigo Silva",
    "email": "rodrigo@silva.com",
    "telefone": 1190111110,
    "inicioDaReserva": "2024-08-10T10:42:18.638746",
    "status": "alocado",
    "quantidadeDeLugares": 10
}
```


Por fim, assim que os serviços forem finalizados para o cliente com o pagamento, o status da reserva mudará para 'encerrado'.

