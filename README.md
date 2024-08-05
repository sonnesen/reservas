# Reserva Rápida
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
| GET!!!! | /reserva |obtém todas reservas|
| GET!!!! | /reserva/{id} |obtém uma reserva específica|
| POST!!! | /reserva|envia uma reserva|
| PUT! | /reserva{id}|edita uma reserva|
| DELETE!! | /reserva{id}|apaga uma reserva|
| POST!!! | /atendimento |libera uma reserva para ir para mesa|
